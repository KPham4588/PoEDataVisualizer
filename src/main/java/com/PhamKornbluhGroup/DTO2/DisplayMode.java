package com.PhamKornbluhGroup.DTO2;

public enum DisplayMode {
    ZERO(0L, "Name should be followed by values"),   // Name should be followed by values
    ONE(1L, "Values should be followed by name"),
    TWO(2L, "Progress bar"),
    THREE(3L, "Values should be inserted into the string by index"),
    FOUR(4L, "Separator");

    private final long displayCode;
    private final String information;

    DisplayMode(long displayCode, String information) {
        this.displayCode = displayCode;
        this.information = information;
    }

    public long getDisplayCode() {
        return displayCode;
    }

    public String getInformation() {
        return information;
    }
}
