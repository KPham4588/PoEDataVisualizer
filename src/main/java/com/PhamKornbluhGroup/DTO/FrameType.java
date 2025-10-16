package com.PhamKornbluhGroup.DTO;

public enum FrameType {
    ZERO("Normal frame"),
    ONE("Magic frame"),
    TWO("Rare frame"),
    THREE("Unique frame"),
    FOUR("Gem frame"),
    FIVE("Currency frame"),
    SIX("Divination Card frame"),
    SEVEN("Quest frame"),
    EIGHT("Prophecy frame (legacy)"),
    NINE("Foil frame"),
    TEN("Supporter Foil frame"),
    ELEVEN("Necropolis frame");

    private final String information;

    FrameType(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    @Override
    public String toString() {
        return "FrameType{" +
                ", information='" + information + '\'' +
                '}';
    }
}