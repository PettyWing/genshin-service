package com.example.uumemory.constants;

/**
 * 圣遗物主属性
 */
public enum MainType {

    FIRE_DAMAGE("fireDamage"),
    WATER_DAMAGE("waterDamage"),
    ROCK_DAMAGE("rockDamage"),
    GRASS_DAMAGE("grassDamage"),
    WIND_DAMAGE("windDamage"),
    THUNDERBOLT_DAMAGE("thunderboltDamage"),
    ICE_DAMAGE("iceDamage"),
    MAX_HEALTH("maxHealth"),
    MIN_HEALTH("minHealth"),
    MAX_ATTACK("maxAttack"),
    MIN_ATTACK("minAttack"),
    MAX_DEFENSE("maxDefense"),
    MIN_DEFENSE("minDefense"),
    CRITICAL_STRIKE_RATE("criticalStrikeRate"),
    CRITICAL_STRIKE_DAMAGE("criticalStrikeDamage"),
    PROFICIENTS("proficients"),
    CHARGING_RATE("chargingRate");

    private String name;

    MainType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
