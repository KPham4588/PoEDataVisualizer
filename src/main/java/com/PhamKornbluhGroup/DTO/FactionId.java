package com.PhamKornbluhGroup.DTO;

public enum FactionId {
    FACTION1("Faction1"),
    FACTION2("Faction2"),
    FACTION3("Faction3"),
    FACTION4("Faction4");

    private final String factionId;

    FactionId(String factionId) {
        this.factionId = factionId;
    }
    public String getFactionId() {
        return factionId;
    }

    @Override
    public String toString() {
        return "FactionId{" +
                "factionId='" + factionId + '\'' +
                '}';
    }
}
