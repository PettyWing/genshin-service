package com.example.uumemory.constants;

import java.util.HashMap;
import java.util.Map;

import com.example.uumemory.dto.CharaterDTO;
import com.example.uumemory.dto.RelicsAttributes;

public class Constants {

    public static Map<String, CharaterDTO> CHARACTER_DTOS = new HashMap<String,CharaterDTO>(){
        {
            put(Characters.YE_LAN,new CharaterDTO(Characters.YE_LAN,new RelicsAttributes(0.8, (double)0, (double)0, 1.0,1.0,(double)0,0.55)));
        }
    };

}
