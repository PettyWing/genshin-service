package com.example.uumemory.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 圣遗物主属性
 */
public enum AppendProp {

    FIRE_DAMAGE("FIGHT_PROP_FIRE_ADD_HURT","火元素伤害加成"),
    WATER_DAMAGE("FIGHT_PROP_WATER_ADD_HURT","水元素伤害加成"),
    ROCK_DAMAGE("FIGHT_PROP_ROCK_ADD_HURT","岩元素伤害加成"),
    GRASS_DAMAGE("FIGHT_PROP_GRASS_ADD_HURT","草元素伤害加成"),
    WIND_DAMAGE("FIGHT_PROP_WIND_ADD_HURT","风元素伤害加成"),
    THUNDERBOLT_DAMAGE("FIGHT_PROP_ELEC_ADD_HURT","雷元素伤害加成"),
    ICE_DAMAGE("FIGHT_PROP_ICE_ADD_HURT","冰元素伤害加成"),
    MAX_HEALTH("FIGHT_PROP_HP_PERCENT","生命值百分比"),
    MIN_HEALTH("FIGHT_PROP_HP","生命值"),
    MAX_ATTACK("FIGHT_PROP_ATTACK_PERCENT","攻击力百分比"),
    MIN_ATTACK("FIGHT_PROP_ATTACK","攻击力"),
    MAX_DEFENSE("FIGHT_PROP_DEFENSE_PERCENT","防御力百分比"),
    MIN_DEFENSE("FIGHT_PROP_DEFENSE","防御力"),
    CRITICAL_STRIKE_RATE("FIGHT_PROP_CRITICAL","暴击率"),
    CRITICAL_STRIKE_DAMAGE("FIGHT_PROP_CRITICAL_HURT","暴击伤害"),
    PROFICIENTS("FIGHT_PROP_ELEMENT_MASTERY","元素精通"),
    CHARGING_RATE("FIGHT_PROP_CHARGE_EFFICIENCY","充能效率"),
    HEAL_ADD("FIGHT_PROP_HEAL_ADD","治疗加成");

    private String name;
    private String displayName;

    AppendProp(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static AppendProp getType(String name){
        if(StringUtils.isEmpty(name)){
            return null;
        }
        for(AppendProp type: AppendProp.values()){
            if(StringUtils.equals(name,type.getName())){
                return type;
            }
        }
        return null;
    }
}
