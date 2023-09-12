package com.example.uumemory.dto;

public class CharaterDTO {
    private String name;
    private RelicsAttributes relicsAttributes;

    public String getName() {
        return name;
    }

    public RelicsAttributes getRelicsAttributes() {
        return relicsAttributes;
    }

    public CharaterDTO(String name, RelicsAttributes relicsAttributes) {
        this.name = name;
        this.relicsAttributes = relicsAttributes;
    }
}
