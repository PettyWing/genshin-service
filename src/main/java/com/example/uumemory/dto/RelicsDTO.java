package com.example.uumemory.dto;

import com.example.uumemory.constants.EquipType;
import com.example.uumemory.constants.AppendProp;

public class RelicsDTO {
    private EquipType equipType;
    private String groupType;
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

    public RelicsDTO() {
    }

    public RelicsDTO(EquipType equipType, String groupType, AppendProp appendProp, double mainValue) {
        this.equipType = equipType;
        this.groupType = groupType;
        this.relicsAttributes = new RelicsAttributes(appendProp, mainValue);
    }
}


