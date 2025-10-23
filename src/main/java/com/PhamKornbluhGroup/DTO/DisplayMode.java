package com.PhamKornbluhGroup.DTO;

public enum DisplayMode {
    UNO("Name should be followed by values"), // Name should be followed by values
    DOS("Values should be followed by name"),
    TRES("Progress bar"),
    FOURSPANISH("Values should be inserted into the string by index"),
    FIVESPANISH("Separator");

    private final String information;

    DisplayMode(String information) {
        this.information = information;
    }
    public String getInformation() {
        return information;
    }

    @Override
    public String toString() {
        return information;
    }
}