package com.example.uumemory.dto;

public class CharacterDTO {
    private Long characterId;
    private String characterName;
    private RelicsAttributes relicsAttributes;

    public Long getCharacterId() {
        return characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public RelicsAttributes getRelicsAttributes() {
        return relicsAttributes;
    }

    public CharacterDTO(Long characterId, RelicsAttributes relicsAttributes) {
        this.characterId = characterId;
        this.relicsAttributes = relicsAttributes;
    }
}
