package com.example.uumemory.constants;

public enum GroupType {
    JUE_YUAN("2276480763","绝缘之旗印");

    private String id;
    private String name;

    GroupType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
