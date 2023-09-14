package com.example.uumemory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import com.example.uumemory.constants.ResultCode;
import com.example.uumemory.dto.RelicsDTO;
import com.example.uumemory.dto.Result;
import com.example.uumemory.service.YuanServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public Result<String> saveRelic(Long uid) {
        List<RelicsDTO> newDTOs = yuanServcie.loadRelicsInfos(uid);
        if (newDTOs == null || newDTOs.isEmpty()) {
            return Result.fail(ResultCode.PARAM_ERROR);
        }
        List<RelicsDTO> lastDTOs = Optional.ofNullable(yuanServcie.getRelicsByUid(uid)).orElse(new ArrayList<>());
        // 新的圣遗物需要插入
        List<RelicsDTO> insertDTOs = new ArrayList<>();
        // 老的需要更新信息的圣遗物
        List<RelicsDTO> updateDTOs = new ArrayList<>();
        newDTOs.stream()
            .forEach(newDTO -> {
                Optional op = lastDTOs.stream().filter(lastDTO -> lastDTO.isEqual(newDTO)).findFirst();
                if(!op.isPresent()){
                    // 没有相同的圣遗物
                    insertDTOs.add(newDTO);
                }else if(!newDTO.getCharacterId().equals(((RelicsDTO)op.get()).getCharacterId())){
                    // 任务id不同
                    updateDTOs.add(newDTO);
                }
            });
        yuanServcie.insertRelics(uid, insertDTOs);
        yuanServcie.updateRelics(uid, updateDTOs);
        return Result.success(JSON.toJSONString(lastDTOs));
    }
}
