package com.PhamKornbluhGroup.DTO;

public class IncubatedItemDTO {
    private int dbId;
    private int itemId;
    private String incubatedItemName; // Called "name" in Dev Docs
    private long incubatedItemLevel;  // Called "level" in Dev Docs   // monster level required to progress
    private long progress;
    private long total;

    public IncubatedItemDTO() {
    }
    public IncubatedItemDTO(int dbId, int itemId, String incubatedItemName, long incubatedItemLevel, long progress, long total) {
        this.dbId = dbId;
        this.itemId = itemId;
        this.incubatedItemName = incubatedItemName;
        this.incubatedItemLevel = incubatedItemLevel;
        this.progress = progress;
        this.total = total;
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
    public String getIncubatedItemName() {
        return incubatedItemName;
    }
    public void setIncubatedItemName(String incubatedItemName) {
        this.incubatedItemName = incubatedItemName;
    }
    public long getIncubatedItemLevel() {
        return incubatedItemLevel;
    }
    public void setIncubatedItemLevel(long incubatedItemLevel) {
        this.incubatedItemLevel = incubatedItemLevel;
    }
    public long getProgress() {
        return progress;
    }
    public void setProgress(long progress) {
        this.progress = progress;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "IncubatedItemDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", incubatedItemName='" + incubatedItemName + '\'' +
                ", incubatedItemLevel=" + incubatedItemLevel +
                ", progress=" + progress +
                ", total=" + total +
                '}';
    }
}