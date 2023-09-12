package com.example.uumemory.service;

import com.example.uumemory.constants.MainType;
import com.example.uumemory.constants.Type;
import com.example.uumemory.dto.RelicsAttributes;
import com.example.uumemory.dto.RelicsDTO;
import org.springframework.stereotype.Service;

import static com.example.uumemory.constants.Constants.CHARACTER_DTOS;

@Service
public class YuanServcie {

    /**
     * 计算单个圣遗物的评分
     *
     * @param name      人物
     * @param relicsDTO 圣遗物数据
     */
    public double calculateSingleRelicsScore(String name, RelicsDTO relicsDTO) {
        RelicsAttributes relicsAttributes = relicsDTO.getAttributes();
        RelicsAttributes relicsYield = CHARACTER_DTOS.get(name).getRelicsAttributes();
        double score = relicsAttributes.getCriticalStrikeRate() * 2 * relicsYield.getCriticalStrikeRate()
            + relicsAttributes.getCriticalStrikeDamage() * 1 * relicsYield.getCriticalStrikeDamage()
            + relicsAttributes.getProficients() * 0.33 * relicsYield.getProficients()
            + relicsAttributes.getChargingRate() * 1.1979 * relicsYield.getChargingRate()
            + relicsAttributes.getMaxAttack() * 1.33 * relicsYield.getMaxAttack()
            + relicsAttributes.getMaxHealth() * 1.33 * relicsYield.getMaxHealth()
            + relicsAttributes.getMaxDefense() * 1.06 * relicsYield.getMaxDefense();
        if (relicsDTO.getType().equals(Type.CROWN) &&
            (relicsAttributes.getMainType().equals(MainType.CRITICAL_STRIKE_DAMAGE)) || relicsAttributes.getMainType().equals(MainType.CRITICAL_STRIKE_RATE)){
            // 如果是暴击率或者暴击头，加20分
            score +=20;
        }
        return score;
    }
}
