package com.PhamKornbluhGroup.DTO;

import com.PhamKornbluhGroup.jsonParsing.RewardsCollectionDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

public class RewardsDTO {
    private int dbId;
    private int itemId;
    private String label;
    @JsonDeserialize(using = RewardsCollectionDeserializer.class)
    private ArrayList<RewardsCollectionDTO> rewards;

    public RewardsDTO() {
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
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public ArrayList<RewardsCollectionDTO> getRewards() {
        return rewards;
    }
    public void setRewards(ArrayList<RewardsCollectionDTO> rewards) {
        this.rewards = rewards;
    }
}