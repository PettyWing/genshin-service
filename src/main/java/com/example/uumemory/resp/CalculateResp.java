package com.example.uumemory.resp;

import java.util.List;

import com.example.uumemory.dto.RelicsDTO;

public class CalculateResp {
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
