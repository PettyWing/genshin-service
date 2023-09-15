package com.example.uumemory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.example.uumemory.constants.EquipType;
import com.example.uumemory.constants.ResultCode;
import com.example.uumemory.dto.RelicsDTO;
import com.example.uumemory.dto.Result;
import com.example.uumemory.entity.RelicsParam;
import com.example.uumemory.req.CalculateReq;
import com.example.uumemory.resp.CalculateResp;
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

    /**
     * 保存圣遗物信息
     *
     * @param uid
     * @return
     */
    @RequestMapping(value = "/saveRelic", method = RequestMethod.GET)
    public Result<List<RelicsDTO>> saveRelic(Long uid) {
        if (uid == null) {
            return Result.fail(ResultCode.PARAM_ERROR);
        }
        try {
            List<RelicsDTO> newDTOs = yuanServcie.loadRelicsInfos(uid);
            if (newDTOs == null || newDTOs.isEmpty()) {
                return Result.fail(ResultCode.PARAM_ERROR);
            }
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
        if (req == null || req.getUid() == null || StringUtils.isBlank(req.getCharacterId())) {
            return Result.fail(ResultCode.PARAM_ERROR);
        }
        CalculateResp resp = new CalculateResp();
        List<RelicsDTO> randomRelicsDTOs = new ArrayList<>();
        List<RelicsDTO> targetRelicsDTOs = new ArrayList<>();
        JSONObject equipTypes = req.getEquipTypes() != null ? JSON.parseObject(JSON.toJSONString(req.getEquipTypes())) : null;
        for (EquipType equipType : EquipType.values()) {
            RelicsParam relicsParam = new RelicsParam();
            RelicsParam.Criteria criteria = relicsParam.createCriteria().andUidEqualTo(req.getUid()).andTypeEqualTo(equipType.getName());
            if (equipTypes != null && equipTypes.containsKey(equipType.getLowName())) {
                List<String> mainTypes = equipTypes.getJSONArray(equipType.getLowName()).toJavaList(String.class);
                if (mainTypes != null && !mainTypes.isEmpty()) {
                    criteria.andMainTypeIn(mainTypes);
                }
            }
            List<RelicsDTO> relics = yuanServcie.queryRelics(relicsParam);
            List<RelicsDTO> result = Optional.ofNullable(yuanServcie.calculateRelicsScore(req.getCharacterId(), relics, req.getGroupType())).orElse(new ArrayList<>());
            randomRelicsDTOs.add(result.isEmpty() ? null : result.get(0));
            targetRelicsDTOs.add(result.size() > 1 ? result.get(1) : null);
        }
        double maxScore = 0;
        List<RelicsDTO> result = new ArrayList<>();
        for (int i = 0; i < randomRelicsDTOs.size(); i++) {
            double score = randomRelicsDTOs.get(0) == null ? 0 : randomRelicsDTOs.get(i).getScore();
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
        resp.setRelicsDTOS(result);
        resp.setScore(maxScore);
        return Result.success(resp);
    }
}
