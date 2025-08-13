package com.PhamKornbluhGroup.DTO;

public class FactionDTO {
    private int dbId;
    private int logbookModsId;
    private FactionId factionId; // Called "faction" in Dev Docs - Faction1, Faction2, Faction3, or Faction4
    private String factionName;  // Called "name" in Dev Docs

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public int getLogbookModsId() {
        return logbookModsId;
    }

    public void setLogbookModsId(int logbookModsId) {
        this.logbookModsId = logbookModsId;
    }

    public FactionId getFactionId() {
        return factionId;
    }

    public void setFactionId(FactionId factionId) {
        this.factionId = factionId;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }
}