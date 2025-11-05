package com.PhamKornbluhGroup.DTO;

public enum DisplayMode {
    ONE("Name should be followed by values"), // Name should be followed by values
    TWO("Values should be followed by name"),
    THREE("Progress bar"),
    FOUR("Values should be inserted into the string by index"),
    FIVE("Separator");

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

    public static DisplayMode fromDisplayMode(String displayMode){
        for (DisplayMode v : DisplayMode.values()){
            if (v.toString().equals(displayMode)){
                return v;
            }
        }
        return null;
    }
}