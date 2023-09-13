package com.example.uumemory.constants;

public enum GroupType {

    BRACER("BRACER", "生之花"),
    NECKLACE("NECKLACE", "死之羽"),
    DRESS("DRESS", "理之冠"),
    SHOES("SHOES", "时之沙"),
    RING("RING", "空之杯");

    private String name;
    private String displayName;

    GroupType(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }
}
