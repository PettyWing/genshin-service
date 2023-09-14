package com.example.uumemory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import com.example.uumemory.constants.AppendProp;
import com.example.uumemory.constants.Constants;
import com.example.uumemory.constants.EquipType;
import com.example.uumemory.converter.YuanConverter;
import com.example.uumemory.dto.EnKaDO;
import com.example.uumemory.dto.RelicsAttributes;
import com.example.uumemory.dto.RelicsDTO;
import com.example.uumemory.entity.Relics;
import com.example.uumemory.entity.RelicsParam;
import com.example.uumemory.mappers.RelicsMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.example.uumemory.constants.Constants.CHARACTER_DTOS;

@Service
public class YuanServcie {
    private static final Logger logger = LoggerFactory.getLogger(YuanServcie.class);
    @Resource
    RelicsMapper relicsMapper;
    @Resource
    HttpSupportClient client;

    /**
     * 计算单个圣遗物的评分
     *
     * @param characterId 人物
     * @param relicsDTOs  圣遗物数据
     */
    public List<RelicsDTO> calculateRelicsScore(Long characterId, List<RelicsDTO> relicsDTOs, String groupType) {
        try {
            if (relicsDTOs == null || relicsDTOs.isEmpty()) {
                return null;
            }
            // 任意的圣遗物
            AtomicReference<Double> tmpRandomScore = new AtomicReference<>((double)0);
            AtomicReference<RelicsDTO> tmpRandomRelicsDTO = new AtomicReference<>();
            // 符合类型的圣遗物
            AtomicReference<Double> tmpTargetScore = new AtomicReference<>((double)0);
            AtomicReference<RelicsDTO> tmpTargetRelicsDTO = new AtomicReference<>();
            relicsDTOs.forEach(relicsDTO -> {
                RelicsAttributes relicsAttributes = relicsDTO.getAttributes();
                RelicsAttributes relicsYield = CHARACTER_DTOS.get(characterId).getRelicsAttributes();
                double score = Optional.ofNullable(relicsAttributes.getCriticalStrikeRate()).orElse(0.0) * 2 * relicsYield.getCriticalStrikeRate()
                    + Optional.ofNullable(relicsAttributes.getCriticalStrikeDamage()).orElse(0.0) * 1 * relicsYield.getCriticalStrikeDamage()
                    + Optional.ofNullable(relicsAttributes.getProficients()).orElse(0.0) * 0.33 * relicsYield.getProficients()
                    + Optional.ofNullable(relicsAttributes.getChargingRate()).orElse(0.0) * 1.1979 * relicsYield.getChargingRate()
                    + Optional.ofNullable(relicsAttributes.getMaxAttack()).orElse(0.0) * 1.33 * relicsYield.getMaxAttack()
                    + Optional.ofNullable(relicsAttributes.getMaxHealth()).orElse(0.0) * 1.33 * relicsYield.getMaxHealth()
                    + Optional.ofNullable(relicsAttributes.getMaxDefense()).orElse(0.0) * 1.06 * relicsYield.getMaxDefense();
                if (relicsDTO.getType().equals(EquipType.DRESS) &&
                    (relicsAttributes.getAppendProp().equals(AppendProp.CRITICAL_STRIKE_DAMAGE)) || relicsAttributes.getAppendProp().equals(AppendProp.CRITICAL_STRIKE_RATE)) {
                    // 如果是暴击率或者暴击头，加20分
                    score += 20;
                }
                relicsDTO.setScore(score);
                if (score > tmpRandomScore.get()) {
                    tmpRandomRelicsDTO.set(relicsDTO);
                    tmpRandomScore.set(score);
                }
                if (StringUtils.equals(Constants.LOC_INFO.getString(groupType), relicsDTO.getGroupType()) && score > tmpTargetScore.get()) {
                    tmpTargetRelicsDTO.set(relicsDTO);
                    tmpTargetScore.set(score);
                }
            });
            return Stream.of(tmpRandomRelicsDTO.get(),tmpTargetRelicsDTO.get()).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("calculateRelicsScore", e);
            return null;
        }
    }

    /**
     * 加载当前用户装备的圣遗物
     * https://api.enka.network/#/api_chs?id=equiptype
     *
     * @param uid
     * @return
     */
    public List<RelicsDTO> loadRelicsInfos(Long uid) {
        if (uid == null) {
            return null;
        }
        try {
            EnKaDO enKaDO = JSON.parseObject(client.doGet("https://enka.network/api/uid/" + uid), EnKaDO.class);
            // 获取所有的圣遗物
            List<RelicsDTO> relicsDTOS = new ArrayList<>();
            enKaDO.getAvatarInfoList().stream().forEach(avatarInfoListDTO -> {
                avatarInfoListDTO.getEquipList().forEach(equipListDTO -> {
                    if (StringUtils.equals(equipListDTO.getFlat().getItemType(), "ITEM_RELIQUARY")) {
                        RelicsDTO relicsDTO = YuanConverter.convert(equipListDTO.getFlat());
                        relicsDTO.setCharacterId((long)avatarInfoListDTO.getAvatarId());
                        relicsDTOS.add(relicsDTO);
                    }
                });
            });
            return relicsDTOS;
        } catch (Exception e) {
            logger.error("loadRelicsInfos", e);
        }
        return null;
    }

    /**
     * 从数据库获取当前uid的所有圣遗物
     *
     * @return
     */
    public List<RelicsDTO> queryRelics(Long uid) {
        if (uid == null) {
            return null;
        }
        RelicsParam relicsParam = new RelicsParam();
        relicsParam.createCriteria().andUidEqualTo(uid);
        return queryRelics(relicsParam);
    }

    public List<RelicsDTO> queryRelics(RelicsParam relicsParam) {
        try {
            return relicsMapper.selectByExample(relicsParam).stream().map(YuanConverter::convert).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("getRelicsByUid", e);
        }
        return null;
    }

    /**
     * 批量插入圣遗物
     *
     * @param uid
     * @param relicsDTOS
     */
    public boolean insertRelics(Long uid, List<RelicsDTO> relicsDTOS) {
        try {
            if (relicsDTOS == null || relicsDTOS.isEmpty()) {
                return true;
            }
            Date date = new Date();
            List<Relics> relicsList = relicsDTOS.stream().map(relicsDTO -> {
                Relics relics = YuanConverter.convert(uid, relicsDTO);
                relics.setGmtCreate(date);
                relics.setGmtModified(date);
                return relics;
            }).collect(Collectors.toList());
            int result = relicsMapper.insertAll(relicsList);
            return result > 0;
        } catch (Exception e) {
            logger.error("insertRelics", e);
            return false;
        }
    }

    /**
     * 批量更新圣遗物
     *
     * @param uid
     * @param relicsDTOS
     */
    public boolean updateRelics(Long uid, List<RelicsDTO> relicsDTOS) {
        try {
            if (relicsDTOS == null || relicsDTOS.isEmpty()) {
                return true;
            }
            Date date = new Date();
            List<Relics> relicsList = relicsDTOS.stream().map(relicsDTO -> {
                Relics relics = YuanConverter.convert(uid, relicsDTO);
                relics.setGmtCreate(date);
                relics.setGmtModified(date);
                return relics;
            }).collect(Collectors.toList());
            for (Relics relics : relicsList) {
                RelicsParam param = new RelicsParam();
                param.createCriteria().andIdEqualTo(relics.getId());
                int result = relicsMapper.updateByExample(relics, param);
                if (result == 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("insertRelics", e);
            return false;
        }
    }
}
