package com.example.uumemory.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 圣遗物位置
 */
public enum EquipType {
    BRACER("EQUIP_BRACER", "生之花"),
    NECKLACE( "EQUIP_NECKLACE", "死之羽"),
    SHOES( "EQUIP_SHOES", "时之沙"),
    RING( "EQUIP_RING", "空之杯"),
    DRESS( "EQUIP_DRESS", "理之冠");

    // enka对应的名字
    private String name;
    private String displayName;

    EquipType(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static EquipType getType(String name){
        if(StringUtils.isEmpty(name)){
            return null;
        }
        for(EquipType equipType : EquipType.values()){
            if(StringUtils.equals(name, equipType.getName())){
                return equipType;
            }
        }
        return null;
    }
}
