package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class ResultDTO {
    private int dbId;
    private String nextChangeId; // pagination code
    private ArrayList<PublicStashChangeDTO> stashes;
}