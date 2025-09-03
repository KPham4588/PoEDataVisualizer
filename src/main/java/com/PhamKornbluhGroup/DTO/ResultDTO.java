package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class ResultDTO {
    private int dbId;
    private String nextChangeId; // pagination code
    private ArrayList<PublicStashChangeDTO> stashes;

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
}