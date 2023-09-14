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

    @RequestMapping(value = "/loadRelic", method = RequestMethod.GET)
    public Result<String> loadRelic(Long uid) {
        List<RelicsDTO> newDTOs = yuanServcie.loadRelicsInfos(uid);
        if (newDTOs == null || newDTOs.isEmpty()) {
            return Result.fail(ResultCode.PARAM_ERROR);
        }
        List<RelicsDTO> lastDTOs = Optional.ofNullable(yuanServcie.getRelicsByUid(uid)).orElse(new ArrayList<>());
        List<RelicsDTO> resultDtos = newDTOs.stream()
            .filter(newDTO -> lastDTOs.stream().noneMatch(lastDTO -> lastDTO.isEqual(newDTO)))
            .collect(Collectors.toList());
        return Result.success(JSON.toJSONString(resultDtos));
    }
}
