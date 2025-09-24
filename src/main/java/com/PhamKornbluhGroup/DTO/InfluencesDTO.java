package com.PhamKornbluhGroup.DTO;

public class InfluencesDTO {
    private int dbId;
    private int itemId;
    private boolean crusader;
    private boolean shaper;
    private boolean elder;
    private boolean hunter;
    private boolean redeemer;
    private boolean warlord;

    public InfluencesDTO() {
    }

    public InfluencesDTO(int dbId, int itemId, boolean shaper, boolean elder, boolean hunter, boolean crusader,
                         boolean redeemer, boolean warlord) {
        this.dbId = dbId;
        this.itemId = itemId;
        this.shaper = shaper;
        this.elder = elder;
        this.hunter = hunter;
        this.crusader = crusader;
        this.redeemer = redeemer;
        this.warlord = warlord;
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
    public boolean isShaper() {
        return shaper;
    }
    public void setShaper(boolean shaper) {
        this.shaper = shaper;
    }
    public boolean isElder() {
        return elder;
    }
    public void setElder(boolean elder) {
        this.elder = elder;
    }
    public boolean isHunter() {
        return hunter;
    }
    public void setHunter(boolean hunter) {
        this.hunter = hunter;
    }
    public boolean isCrusader() {
        return crusader;
    }
    public void setCrusader(boolean crusader) {
        this.crusader = crusader;
    }
    public boolean isRedeemer() {
        return redeemer;
    }
    public void setRedeemer(boolean redeemer) {
        this.redeemer = redeemer;
    }
    public boolean isWarlord() {
        return warlord;
    }
    public void setWarlord(boolean warlord) {
        this.warlord = warlord;
    }

    @Override
    public String toString() {
        return "InfluencesDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", shaper=" + shaper +
                ", elder=" + elder +
                ", hunter=" + hunter +
                ", crusader=" + crusader +
                ", redeemer=" + redeemer +
                ", warlord=" + warlord +
                '}';
    }
}
