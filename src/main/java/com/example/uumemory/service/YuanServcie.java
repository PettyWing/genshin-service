package com.example.uumemory.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import com.example.uumemory.constants.AppendProp;
import com.example.uumemory.constants.EquipType;
import com.example.uumemory.converter.YuanConverter;
import com.example.uumemory.dto.EnKaDO;
import com.example.uumemory.dto.RelicsAttributes;
import com.example.uumemory.dto.RelicsDTO;
import com.example.uumemory.entity.Relics;
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
     * @param name      人物
     * @param relicsDTO 圣遗物数据
     */
    public double calculateSingleRelicsScore(String name, RelicsDTO relicsDTO) {
        RelicsAttributes relicsAttributes = relicsDTO.getAttributes();
        RelicsAttributes relicsYield = CHARACTER_DTOS.get(name).getRelicsAttributes();
        double score = relicsAttributes.getCriticalStrikeRate() * 2 * relicsYield.getCriticalStrikeRate()
            + relicsAttributes.getCriticalStrikeDamage() * 1 * relicsYield.getCriticalStrikeDamage()
            + relicsAttributes.getProficients() * 0.33 * relicsYield.getProficients()
            + relicsAttributes.getChargingRate() * 1.1979 * relicsYield.getChargingRate()
            + relicsAttributes.getMaxAttack() * 1.33 * relicsYield.getMaxAttack()
            + relicsAttributes.getMaxHealth() * 1.33 * relicsYield.getMaxHealth()
            + relicsAttributes.getMaxDefense() * 1.06 * relicsYield.getMaxDefense();
        if (relicsDTO.getType().equals(EquipType.DRESS) &&
            (relicsAttributes.getMainType().equals(AppendProp.CRITICAL_STRIKE_DAMAGE)) || relicsAttributes.getMainType().equals(AppendProp.CRITICAL_STRIKE_RATE)) {
            // 如果是暴击率或者暴击头，加20分
            score += 20;
        }
        return score;
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
                        relicsDTOS.add(YuanConverter.convertFlat2Relics(equipListDTO.getFlat()));
                    }
                });
            });
            // TODO: 2023/9/13 做去重操作
            return relicsDTOS;
        } catch (Exception e) {
            logger.error("loadRelicsInfos", e);
        }
        return null;
    }


    public void insertRelics() {
        Relics relics = new Relics();
        relics.setUid(1L);
        relics.setType(EquipType.BRACER.getName());
        relics.setGroupType(GroupType.BRACER.getName());
        relics.setMainType(AppendProp.CRITICAL_STRIKE_RATE.getName());
        relics.setMainValue(100.0);
        relicsMapper.insert(relics);
    }
}
