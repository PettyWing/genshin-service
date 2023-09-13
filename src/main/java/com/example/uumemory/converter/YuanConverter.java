package com.example.uumemory.converter;

import com.example.uumemory.constants.AppendProp;
import com.example.uumemory.constants.Constants;
import com.example.uumemory.constants.EquipType;
import com.example.uumemory.dto.EnKaDO.AvatarInfoListDTO.EquipListDTO.FlatDTO;
import com.example.uumemory.dto.RelicsAttributes;
import com.example.uumemory.dto.RelicsDTO;

public class YuanConverter {
    public static RelicsDTO convertFlat2Relics(FlatDTO flatDTO) {
        RelicsDTO relicsDTO = new RelicsDTO();
        relicsDTO.setType(EquipType.getType(flatDTO.getEquipType()));
        relicsDTO.setGroupType(Constants.LOC_INFO.getString(flatDTO.getSetNameTextMapHash()));
        RelicsAttributes relicsAttributes = new RelicsAttributes();
        relicsAttributes.setMainType(AppendProp.getType(flatDTO.getReliquaryMainstat().getMainPropId()));
        relicsAttributes.setMainValue(flatDTO.getReliquaryMainstat().getStatValue());
        flatDTO.getReliquarySubstats().forEach(reliquarySubstatsDTO -> {
            AppendProp prop = AppendProp.getType(reliquarySubstatsDTO.getAppendPropId());
            if (prop == null) {
                return;
            }
            double statValue = reliquarySubstatsDTO.getStatValue();
            // 只有主属性存在的属性伤害和治疗加成就不放在这儿处理了
            switch (prop) {
                case MAX_HEALTH:
                    relicsAttributes.setMaxHealth(statValue);
                    break;
                case MIN_HEALTH:
                    relicsAttributes.setMinHealth(statValue);
                    break;
                case MAX_ATTACK:
                    relicsAttributes.setMaxAttack(statValue);
                    break;
                case MIN_ATTACK:
                    relicsAttributes.setMinAttack(statValue);
                    break;
                case MAX_DEFENSE:
                    relicsAttributes.setMaxDefense(statValue);
                    break;
                case MIN_DEFENSE:
                    relicsAttributes.setMinDefense(statValue);
                    break;
                case CRITICAL_STRIKE_RATE:
                    relicsAttributes.setCriticalStrikeRate(statValue);
                    break;
                case CRITICAL_STRIKE_DAMAGE:
                    relicsAttributes.setCriticalStrikeDamage(statValue);
                    break;
                case PROFICIENTS:
                    relicsAttributes.setProficients(statValue);
                    break;
                case CHARGING_RATE:
                    relicsAttributes.setChargingRate(statValue);
                    break;
                default:
                    break;
            }
        });
        relicsDTO.setAttributes(relicsAttributes);
        return relicsDTO;
    }

}
