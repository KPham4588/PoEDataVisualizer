package com.PhamKornbluhGroup.DTO;

public class RewardsCollectionDTO {
    private int dbId;
    private int rewardsId;
    private String rewardsType;
    private int rewardsAmount;

    public RewardsCollectionDTO() {
    }

    public int getRewardsAmount() {
        return rewardsAmount;
    }

    public void setRewardsAmount(int rewardsAmount) {
        this.rewardsAmount = rewardsAmount;
    }

    public String getRewardsType() {
        return rewardsType;
    }

    public void setRewardsType(String rewardsType) {
        this.rewardsType = rewardsType;
    }

    public int getRewardsId() {
        return rewardsId;
    }

    public void setRewardsId(int rewardsId) {
        this.rewardsId = rewardsId;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
}