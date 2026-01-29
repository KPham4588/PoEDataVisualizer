package com.PhamKornbluhGroup.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScourgedDTO {
    private int dbId;
    private int itemId;
    @JsonProperty("tier")
    private long scourgedTier;     // Called "tier" in Dev Docs      // 1-3 for items, 1-10 for maps
    @JsonProperty("level")
    private long scourgedLevel;    // Called "level" in Dev Docs     // monster level required to progress  // Optional
    @JsonProperty("progress")
    private long scourgedProgress; // Called "progress" in Dev Docs                                         // Optional
    @JsonProperty("total")
    private long scourgedTotal;    // Called "total" in Dev Docs                                            // Optional

    public ScourgedDTO() {
    }

    public int getDbId() {
        return dbId;
    }
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public long getScourgedTier() {
        return scourgedTier;
    }
    public void setScourgedTier(long scourgedTier) {
        this.scourgedTier = scourgedTier;
    }
    public long getScourgedLevel() {
        return scourgedLevel;
    }
    public void setScourgedLevel(long scourgedLevel) {
        this.scourgedLevel = scourgedLevel;
    }
    public long getScourgedProgress() {
        return scourgedProgress;
    }
    public void setScourgedProgress(long scourgedProgress) {
        this.scourgedProgress = scourgedProgress;
    }
    public long getScourgedTotal() {
        return scourgedTotal;
    }
    public void setScourgedTotal(long scourgedTotal) {
        this.scourgedTotal = scourgedTotal;
    }

    @Override
    public String toString() {
        return "ScourgedDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", scourgedTier=" + scourgedTier +
                ", scourgedLevel=" + scourgedLevel +
                ", scourgedProgress=" + scourgedProgress +
                ", scourgedTotal=" + scourgedTotal +
                '}';
    }
}