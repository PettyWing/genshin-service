package com.example.uumemory.dto;

public class CharacterDTO {
    private Long characterId;
    private RelicsAttributes relicsAttributes;

    public Long getCharacterId() {
        return characterId;
    }

    public RelicsAttributes getRelicsAttributes() {
        return relicsAttributes;
    }

    public CharacterDTO(Long characterId, RelicsAttributes relicsAttributes) {
        this.characterId = characterId;
        this.relicsAttributes = relicsAttributes;
    }
}
