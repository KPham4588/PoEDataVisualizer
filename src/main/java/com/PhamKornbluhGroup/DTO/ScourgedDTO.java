package com.PhamKornbluhGroup.DTO;

public class ScourgedDTO {
    private int dbId;
    private int itemId;
    private long scourgedTier;     // Called "tier" in Dev Docs      // 1-3 for items, 1-10 for maps
    private long scourgedLevel;    // Called "level" in Dev Docs     // monster level required to progress  // Optional
    private long scourgedProgress; // Called "progress" in Dev Docs                                         // Optional
    private long scourgedTotal;    // Called "total" in Dev Docs                                            // Optional

    public ScourgedDTO() {
    }
    public ScourgedDTO(int dbId, int itemId, long scourgedTier, long scourgedLevel, long scourgedProgress,
                       long scourgedTotal) {
        this.dbId = dbId;
        this.itemId = itemId;
        this.scourgedTier = scourgedTier;
        this.scourgedLevel = scourgedLevel;
        this.scourgedProgress = scourgedProgress;
        this.scourgedTotal = scourgedTotal;
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