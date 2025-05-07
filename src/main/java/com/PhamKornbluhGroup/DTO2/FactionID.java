package com.PhamKornbluhGroup.DTO2;

public enum FactionID {
    FACTION1("Faction1"),
    FACTION2("Faction2"),
    FACTION3("Faction3"),
    FACTION4("Faction4");

    private final String factionID;

    FactionID(String factionID) {
        this.factionID = factionID;
    }
    
    public String getFactionID() {
        return factionID;
    }
}
