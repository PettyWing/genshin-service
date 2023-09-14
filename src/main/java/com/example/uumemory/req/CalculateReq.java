package com.example.uumemory.req;

import java.util.List;
import java.util.Map;

public class CalculateReq {
    private Long uid;
    private Long characterId;
    private Map<String, List<String>> equipTypes;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public Map<String, List<String>> getEquipTypes() {
        return equipTypes;
    }

    public void setEquipTypes(Map<String, List<String>> equipTypes) {
        this.equipTypes = equipTypes;
    }
}
