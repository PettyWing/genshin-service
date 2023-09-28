package com.example.uumemory.constants;

import javax.annotation.PostConstruct;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.example.uumemory.dto.RelicsAttributes;
import com.example.uumemory.utils.ResourceReader;
import org.springframework.stereotype.Component;

@Component
public class Constants {
    public static JSONObject CHARACTERS;
    public static JSONObject LOC_INFO;

    public static JSONObject RELICS_INFO;

    @PostConstruct
    public void init(){
        CHARACTERS  = JSON.parseObject(ResourceReader.read("/store/character.json"));
        LOC_INFO  = JSON.parseObject(ResourceReader.read("/store/loc.json"));
        RELICS_INFO  = JSON.parseObject(ResourceReader.read("/store/relics.json"));
    }

    // TODO: 2023/9/15 目前缺少的10000061,10000081,10000082,10000083,10000084,10000085,10000005-503,10000007-503
    public static RelicsAttributes getCharacter(String characterId){
        JSONObject character = CHARACTERS.getJSONObject(characterId);
        if(!character.containsKey("RelicsAttributes")){
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(character.getJSONObject("RelicsAttributes")), RelicsAttributes.class);
    }
}
