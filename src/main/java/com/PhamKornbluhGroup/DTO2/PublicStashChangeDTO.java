package com.PhamKornbluhGroup.DTO2;

public class PublicStashChangeDTO {
    private String id;              // a unique 64 digit hexadecimal string
    private boolean isPublic;       // if false then optional properties will be null
    private String accountName;                                                         // Nullable
    private String stash;           // The name of the stash                            // Nullable
    private String stashType;
    private String league;          // the league's name                                // Nullable
    private ItemDTO[] items;        // array of Item
}
