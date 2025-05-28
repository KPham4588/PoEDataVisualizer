package com.PhamKornbluhGroup.DTO;

public class ResultDTO {
    private int dbId;
    private String nextChangeId; // pagination code
    private PublicStashChangeDTO[] stashes;
}