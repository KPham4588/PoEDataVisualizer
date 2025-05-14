package com.PhamKornbluhGroup.DTO;

public class ResultDTO {
    private int dbID;
    private String nextChangeId; // pagination code
    private PublicStashChangeDTO[] stashes;
}