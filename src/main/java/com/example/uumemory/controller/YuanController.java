package com.example.uumemory.controller;

import javax.annotation.Resource;

import com.example.uumemory.service.HttpSupportClient;
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
    HttpSupportClient client;
    @Resource
    YuanServcie yuanServcie;

    @RequestMapping(value="/singleRelicScore" ,method = RequestMethod.GET)
    public String singleRelicScore() {
        logger.info("我是测试文案");
        return "hello world";
    }

    @RequestMapping(value="/loadRelic" ,method = RequestMethod.GET)
    public String loadRelic(String uid) {
        return client.doGet("https://enka.network/api/uid/"+uid);
    }

    @RequestMapping(value="/insertRelic" ,method = RequestMethod.GET)
    public void insertRelic() {
        yuanServcie.insertRelics();
    }
}
