package com.PhamKornbluhGroup.DTO;

public enum FrameType {
    ZERO(0L, "Normal frame"),
    ONE(1L, "Magic frame"),
    TWO(2L, "Rare frame"),
    THREE(3L, "Unique frame"),
    FOUR(4L, "Gem frame"),
    FIVE(5L, "Currency frame"),
    SIX(6L, "Divination Card frame"),
    SEVEN(7L, "Quest frame"),
    EIGHT(8L, "Prophecy frame (legacy)"),
    NINE(9L, "Foil frame"),
    TEN(10L, "Supporter Foil frame"),
    ELEVEN(11L, "Necropolis frame");

    private final long value;
    private final String information;

    FrameType(long value, String information) {
        this.value = value;
        this.information = information;
    }
    public long getValue() {
        return value;
    }
    public String getInformation() {
        return information;
    }
}