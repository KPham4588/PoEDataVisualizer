package com.PhamKornbluhGroup.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ResultDTO {
    private int dbId;
    @JsonProperty("next_change_id")
    private String nextChangeId; // pagination code
    private ArrayList<PublicStashChangeDTO> stashes;

    public ResultDTO() {
    }

    public int getDbId() {
        return dbId;
    }
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
    public String getNextChangeId() {
        return nextChangeId;
    }
    public void setNextChangeId(String nextChangeId) {
        this.nextChangeId = nextChangeId;
    }
    public ArrayList<PublicStashChangeDTO> getStashes() {
        return stashes;
    }
    public void setStashes(ArrayList<PublicStashChangeDTO> stashes) {
        this.stashes = stashes;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "dbId=" + dbId +
                ", nextChangeId='" + nextChangeId + '\'' +
                ", stashes=" + stashes +
                '}';
    }
}