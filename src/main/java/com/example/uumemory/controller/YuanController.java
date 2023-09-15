package com.example.uumemory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.example.uumemory.constants.EquipType;
import com.example.uumemory.constants.ResultCode;
import com.example.uumemory.dto.RelicsDTO;
import com.example.uumemory.dto.Result;
import com.example.uumemory.entity.RelicsParam;
import com.example.uumemory.req.CalculateReq;
import com.example.uumemory.req.CalculateReq.CharacterInfo;
import com.example.uumemory.resp.CalculateResp;
import com.example.uumemory.resp.CalculateResp.CharacterResp;
import com.example.uumemory.resp.LoginResp;
import com.example.uumemory.service.YuanServcie;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YuanController {
    private static final Logger logger = LoggerFactory.getLogger(YuanController.class);

    @Resource
    YuanServcie yuanServcie;

    @RequestMapping(value = "/singleRelicScore", method = RequestMethod.GET)
    public String singleRelicScore() {
        logger.info("我是测试文案");
        return "hello world";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result<LoginResp> login(Long uid) {
        if (uid == null) {
            return Result.fail(ResultCode.PARAM_ERROR);
        }
        LoginResp resp = new LoginResp();
        List<RelicsDTO> lastDTOs = yuanServcie.queryRelics(uid);
        if (lastDTOs == null || lastDTOs.isEmpty()) {
            // 数据库没有圣遗物就从接口中拿
            List<RelicsDTO> newDTOs = yuanServcie.loadRelicsInfos(uid);
            resp.setRelics(newDTOs);
            return Result.success(resp);
        } else {
            resp.setRelics(lastDTOs);
            return Result.success(resp);
        }
    }

    /**
     * 加载圣遗物的信息
     *
     * @param uid
     * @return
     */
    @RequestMapping(value = "/loadRelic", method = RequestMethod.GET)
    public Result<List<RelicsDTO>> loadRelic(Long uid) {
        if (uid == null) {
            return Result.fail(ResultCode.PARAM_ERROR);
        }
        try {
            // 从接口拉出来的目前面板中的圣遗物
            List<RelicsDTO> newDTOs = yuanServcie.loadRelicsInfos(uid);
            if (newDTOs == null || newDTOs.isEmpty()) {
                return Result.fail(ResultCode.PARAM_ERROR);
            }
            // 从数据库查出来的已有圣遗物
            List<RelicsDTO> lastDTOs = Optional.ofNullable(yuanServcie.queryRelics(uid)).orElse(new ArrayList<>());
            // 新的圣遗物需要插入
            List<RelicsDTO> insertDTOs = new ArrayList<>();
            // 老的需要更新信息的圣遗物
            List<RelicsDTO> updateDTOs = new ArrayList<>();
            newDTOs.stream()
                .forEach(newDTO -> {
                    Optional op = lastDTOs.stream().filter(lastDTO -> lastDTO.isEqual(newDTO)).findFirst();
                    if (!op.isPresent()) {
                        // 没有相同的圣遗物
                        insertDTOs.add(newDTO);
                    } else if (!newDTO.getCharacterId().equals(((RelicsDTO)op.get()).getCharacterId())) {
                        newDTO.setId(((RelicsDTO)op.get()).getId());
                        // 任务id不同
                        updateDTOs.add(newDTO);
                    }
                });
            boolean result = yuanServcie.insertRelics(uid, insertDTOs);
            if (!result) {
                logger.error("插入失败 uid:{},insertDTOs:{}", uid, insertDTOs);
                return Result.fail(ResultCode.SYSTEM_ERROR);
            }
            result = yuanServcie.updateRelics(uid, updateDTOs);
            if (!result) {
                logger.error("更新失败 uid:{},insertDTOs:{}", uid, insertDTOs);
                return Result.fail(ResultCode.SYSTEM_ERROR);
            }
            List<RelicsDTO> allDTOs = Optional.ofNullable(yuanServcie.queryRelics(uid)).orElse(new ArrayList<>());
            return Result.success(allDTOs);
        } catch (Exception e) {
            logger.error("saveRelic", e);
            return Result.fail(ResultCode.SYSTEM_ERROR);
        }
    }

    /**
     * 计算角色的圣遗物评分
     *
     * @param req
     * @returnx
     */
    @RequestMapping(value = "/calculateCharacterRelics", method = RequestMethod.POST)
    public Result<CalculateResp> calculateCharacterRelics(@RequestBody CalculateReq req) {
        if (req == null || req.getUid() == null || req.getCharacters() == null || req.getCharacters().isEmpty()) {
            return Result.fail(ResultCode.PARAM_ERROR);
        }
        try {
            CalculateResp resp = new CalculateResp();
            // 拿到所有当前uid的圣遗物
            List<RelicsDTO> allRelics = yuanServcie.queryRelics(req.getUid());
            List<CharacterResp> characterResps = new ArrayList<>();
            for (CharacterInfo characterInfo : req.getCharacters()) {
                CharacterResp characterResp = new CharacterResp();
                List<RelicsDTO> randomRelicsDTOs = new ArrayList<>();
                List<RelicsDTO> targetRelicsDTOs = new ArrayList<>();
                JSONObject equipTypes = characterInfo.getEquipTypes() != null ? JSON.parseObject(JSON.toJSONString(characterInfo.getEquipTypes())) : null;
                for (EquipType equipType : EquipType.values()) {
                    // 过滤装备位置
                    List<RelicsDTO> relics = allRelics.stream().filter(relicsDTO -> relicsDTO.getType() == equipType).collect(Collectors.toList());
                    if (equipTypes != null && equipTypes.containsKey(equipType.getLowName())) {
                        // 过滤装备主词条
                        List<String> mainTypes = equipTypes.getJSONArray(equipType.getLowName()).toJavaList(String.class);
                        relics = relics.stream().filter(relicsDTO -> mainTypes.contains(relicsDTO.getAttributes().getAppendProp().getName())).collect(Collectors.toList());
                    }
                    List<RelicsDTO> result = Optional.ofNullable(yuanServcie.calculateRelicsScore(characterInfo.getCharacterId(), relics, characterInfo.getGroupType())).orElse(
                        new ArrayList<>());
                    randomRelicsDTOs.add(result.isEmpty() ? null : result.get(0));
                    targetRelicsDTOs.add(result.size() > 1 ? result.get(1) : null);
                }
                double maxScore = 0;
                List<RelicsDTO> result = new ArrayList<>();
                for (int i = 0; i < randomRelicsDTOs.size(); i++) {
                    double score = randomRelicsDTOs.get(i) == null ? 0 : randomRelicsDTOs.get(i).getScore();
                    List<RelicsDTO> tmp = new ArrayList<>(targetRelicsDTOs);
                    tmp.remove(i);
                    for (RelicsDTO relicsDTO : tmp) {
                        score += relicsDTO == null ? 0 : relicsDTO.getScore();
                    }
                    if (score > maxScore) {
                        maxScore = score;
                        result.clear();
                        result.addAll(tmp);
                        result.add(i, randomRelicsDTOs.get(i));
                    }
                }
                allRelics = allRelics.stream()
                    .filter(relicsDTO -> result.stream()
                        .filter(Objects::nonNull)
                        .noneMatch(resultDTO -> relicsDTO.getId().equals(resultDTO.getId())))
                    .collect(Collectors.toList());
                characterResp.setRelicsDTOS(result);
                characterResp.setScore(maxScore);
                characterResps.add(characterResp);
            }
            resp.setCharacters(characterResps);
            return Result.success(resp);
        } catch (Exception e) {
            logger.error("calculateCharacterRelics", e);
        }
        return Result.fail(ResultCode.SYSTEM_ERROR);
    }
}
