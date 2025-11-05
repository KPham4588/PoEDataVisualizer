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

    private final String frameType;

    FrameType(String frameType) {
        this.frameType = frameType;
    }

    @Override
    public String toString() {
        return frameType;
    }

    public static FrameType fromFrameType(String frameType){
        for (FrameType v : FrameType.values()){
            if (v.toString().equals(frameType)){
                return v;
            }
        }
        return null;
    }
}