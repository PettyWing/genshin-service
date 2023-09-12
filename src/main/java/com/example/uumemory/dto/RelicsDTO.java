package com.example.uumemory.dto;

import com.example.uumemory.constants.GroupType;
import com.example.uumemory.constants.MainType;
import com.example.uumemory.constants.Type;

public class RelicsDTO {
    private Type type;
    private GroupType groupType;
    private RelicsAttributes relicsAttributes;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    public RelicsAttributes getAttributes() {
        return relicsAttributes;
    }

    public void setAttributes(RelicsAttributes relicsAttributes) {
        this.relicsAttributes = relicsAttributes;
    }

    public RelicsDTO(Type type, GroupType groupType, MainType mainType, double mainValue) {
        this.type = type;
        this.groupType = groupType;
        this.relicsAttributes = new RelicsAttributes(mainType, mainValue);
    }
}


