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
}