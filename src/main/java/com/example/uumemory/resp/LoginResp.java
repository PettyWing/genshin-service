package com.example.uumemory.resp;

import java.util.List;

import com.example.uumemory.dto.RelicsDTO;

public class LoginResp {
    private List<RelicsDTO> relics;

    public List<RelicsDTO> getRelics() {
        return relics;
    }

    public void setRelics(List<RelicsDTO> relics) {
        this.relics = relics;
    }
}
