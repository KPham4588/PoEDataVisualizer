package com.PhamKornbluhGroup.DTO;

public enum DisplayMode {
    ZERO("Name should be followed by values"), // Name should be followed by values
    ONE("Values should be followed by name"),
    TWO("Progress bar"),
    THREE("Values should be inserted into the string by index"),
    FOUR("Separator");

    private final String information;

    DisplayMode(String information) {
        this.information = information;
    }
    public String getInformation() {
        return information;
    }

    @Override
    public String toString() {
        return "DisplayMode{" +
                ", information='" + information + '\'' +
                '}';
    }
}