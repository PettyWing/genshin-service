package com.example.uumemory.dto;

import com.example.uumemory.constants.Constants;
import com.example.uumemory.constants.EquipType;
import com.example.uumemory.constants.AppendProp;
import org.apache.commons.lang3.StringUtils;

public class RelicsDTO {
    private EquipType equipType;
    private String groupType;
    private Long characterId;

    private Double score;
    private RelicsAttributes relicsAttributes;

    public EquipType getType() {
        return equipType;
    }

    public void setType(EquipType equipType) {
        this.equipType = equipType;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public RelicsAttributes getAttributes() {
        return relicsAttributes;
    }

    public void setAttributes(RelicsAttributes relicsAttributes) {
        this.relicsAttributes = relicsAttributes;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getEquipTypeName() {
        return equipType.getDisplayName();
    }

    public String getCharacterName() {
        return Constants.LOC_INFO.getString(String.valueOf(characterId));
    }

    public RelicsDTO() {
    }


    public RelicsDTO(EquipType equipType, String groupType, AppendProp appendProp, double mainValue) {
        this.equipType = equipType;
        this.groupType = groupType;
        this.relicsAttributes = new RelicsAttributes(appendProp, mainValue);
    }

    public boolean isEqual(RelicsDTO other) {
        if (!StringUtils.equals(equipType.getName(), other.equipType.getName())) {
            return false;
        }
        if (!StringUtils.equals(groupType, other.groupType)) {
            return false;
        }
        if (!relicsAttributes.isEqual(other.relicsAttributes)) {
            return false;
        }
        return true;
    }
}


