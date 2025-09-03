package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class PublicStashChangeDTO {
    private int dbId;
    private int resultId;
    private String id;           // a unique 64 digit hexadecimal string
    private boolean isPublic;    // Called "public" in Dev Docs           //p if false then optional properties will be null
    private String accountName;                                               //p Optional
    private String stash;        // The name of the stash                     //p Optional
    private String stashType;
    private String league;       // the league's name                         //p Optional
    private ArrayList<ItemDTO> items;     // array of Item

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getStash() {
        return stash;
    }

    public void setStash(String stash) {
        this.stash = stash;
    }

    public String getStashType() {
        return stashType;
    }

    public void setStashType(String stashType) {
        this.stashType = stashType;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public ArrayList<ItemDTO> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemDTO> items) {
        this.items = items;
    }
}