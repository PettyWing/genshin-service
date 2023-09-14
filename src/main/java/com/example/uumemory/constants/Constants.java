package com.example.uumemory.constants;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.example.uumemory.dto.CharacterDTO;
import com.example.uumemory.dto.RelicsAttributes;
import com.example.uumemory.utils.ResourceReader;
import org.springframework.stereotype.Component;

@Component
public class Constants {
    public static JSONObject CHARACTERS;
    public static JSONObject LOC_INFO;
    @PostConstruct
    public void init(){
        CHARACTERS  = JSON.parseObject(ResourceReader.read("/store/character.json"));
        LOC_INFO  = JSON.parseObject(ResourceReader.read("/store/loc.json"));
    }

    public static Map<Long, CharacterDTO> CHARACTER_DTOS = new HashMap<Long, CharacterDTO>() {
        {
            put(10000060L, new CharacterDTO(10000060L, new RelicsAttributes(0.8, (double)0, (double)0, 1.0, 1.0, (double)0, 0.55)));
        }
    };

}
