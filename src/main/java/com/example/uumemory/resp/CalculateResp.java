package com.example.uumemory.resp;

import java.util.List;

import com.example.uumemory.dto.RelicsDTO;

public class CalculateResp {
    private List<CharacterResp> characters;

    public List<CharacterResp> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterResp> characters) {
        this.characters = characters;
    }

    public static class CharacterResp{
        private double score;
        private List<RelicsDTO> relicsDTOS;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<RelicsDTO> getRelicsDTOS() {
            return relicsDTOS;
        }

        public void setRelicsDTOS(List<RelicsDTO> relicsDTOS) {
            this.relicsDTOS = relicsDTOS;
        }
    }
}
