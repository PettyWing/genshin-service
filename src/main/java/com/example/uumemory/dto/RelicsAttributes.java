package com.example.uumemory.dto;

import com.example.uumemory.constants.AppendProp;

public class RelicsAttributes {
    private AppendProp appendProp;
    private double mainValue;
    private double maxHealth;
    private double minHealth;
    private double maxAttack;
    private double minAttack;
    private double maxDefense;
    private double minDefense;
    private double criticalStrikeRate;
    private double criticalStrikeDamage;
    private double proficients;
    private double chargingRate;

    public AppendProp getMainType() {
        return appendProp;
    }

    public void setMainType(AppendProp appendProp) {
        this.appendProp = appendProp;
    }

    public double getMainValue() {
        return mainValue;
    }

    public void setMainValue(double mainValue) {
        this.mainValue = mainValue;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getMinHealth() {
        return minHealth;
    }

    public void setMinHealth(double minHealth) {
        this.minHealth = minHealth;
    }

    public double getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(double maxAttack) {
        this.maxAttack = maxAttack;
    }

    public double getMinAttack() {
        return minAttack;
    }

    public void setMinAttack(double minAttack) {
        this.minAttack = minAttack;
    }

    public double getMaxDefense() {
        return maxDefense;
    }

    public void setMaxDefense(double maxDefense) {
        this.maxDefense = maxDefense;
    }

    public double getMinDefense() {
        return minDefense;
    }

    public void setMinDefense(double minDefense) {
        this.minDefense = minDefense;
    }

    public double getCriticalStrikeRate() {
        return criticalStrikeRate;
    }

    public void setCriticalStrikeRate(double criticalStrikeRate) {
        this.criticalStrikeRate = criticalStrikeRate;
    }

    public double getCriticalStrikeDamage() {
        return criticalStrikeDamage;
    }

    public void setCriticalStrikeDamage(double criticalStrikeDamage) {
        this.criticalStrikeDamage = criticalStrikeDamage;
    }

    public double getProficients() {
        return proficients;
    }

    public void setProficients(double proficients) {
        this.proficients = proficients;
    }

    public double getChargingRate() {
        return chargingRate;
    }

    public void setChargingRate(double chargingRate) {
        this.chargingRate = chargingRate;
    }

    public RelicsAttributes() {
    }

    public RelicsAttributes(AppendProp appendProp, double mainValue) {
        this.appendProp = appendProp;
        this.mainValue = mainValue;
    }

    /**
     * 构建圣遗物的收益率
     */
    public RelicsAttributes(double maxHealth, double maxAttack, double maxDefense,
        double criticalStrikeRate, double criticalStrikeDamage, double proficients, double chargingRate) {
        this.maxHealth = maxHealth;
        this.maxAttack = maxAttack;
        this.maxDefense = maxDefense;
        this.criticalStrikeRate = criticalStrikeRate;
        this.criticalStrikeDamage = criticalStrikeDamage;
        this.proficients = proficients;
        this.chargingRate = chargingRate;
    }
}