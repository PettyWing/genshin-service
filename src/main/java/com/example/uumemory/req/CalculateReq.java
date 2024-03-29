package com.example.uumemory.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class CalculateReq {

    @JSONField(name = "uid")
    private Long uid;
    @JSONField(name = "characters")
    List<CharacterInfo> characters;

    public Long getUid() {return uid;}

    public void setUid(Long uid) {this.uid = uid;}

    public List<CharacterInfo> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterInfo> characters) {
        this.characters = characters;
    }

    public static class CharacterInfo{
        @JSONField(name = "characterId")
        private String characterId;
        @JSONField(name = "equipTypes")
        private EquipTypesDTO equipTypes;
        @JSONField(name = "groupType")
        private String groupType;

        public String getCharacterId() {return characterId;}

        public void setCharacterId(String characterId) {this.characterId = characterId;}

        public EquipTypesDTO getEquipTypes() {return equipTypes;}

        public void setEquipTypes(EquipTypesDTO equipTypes) {this.equipTypes = equipTypes;}

        public String getGroupType() {return groupType;}

        public void setGroupType(String groupType) {this.groupType = groupType;}
    }

    public static class EquipTypesDTO {
        @JSONField(name = "equipShoes")
        private List<String> equipShoes;
        @JSONField(name = "equipRing")
        private List<String> equipRing;
        @JSONField(name = "equipDress")
        private List<String> equipDress;

        public List<String> getEquipShoes() {
            return equipShoes;
        }

        public void setEquipShoes(List<String> equipShoes) {
            this.equipShoes = equipShoes;
        }

        public List<String> getEquipRing() {
            return equipRing;
        }

        public void setEquipRing(List<String> equipRing) {
            this.equipRing = equipRing;
        }

        public List<String> getEquipDress() {
            return equipDress;
        }

        public void setEquipDress(List<String> equipDress) {
            this.equipDress = equipDress;
        }
    }
}
