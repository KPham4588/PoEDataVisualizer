package com.PhamKornbluhGroup.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FactionId {
    @JsonProperty("Faction1")
    FACTION1("Faction1"),
    @JsonProperty("Faction2")
    FACTION2("Faction2"),
    @JsonProperty("Faction3")
    FACTION3("Faction3"),
    @JsonProperty("Faction4")
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
        return factionId;
    }
}
