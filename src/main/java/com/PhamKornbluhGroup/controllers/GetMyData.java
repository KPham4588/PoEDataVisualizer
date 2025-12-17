package com.PhamKornbluhGroup.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.*;

// TODO: RENAME THIS PLEASE
@RestController
@RequestMapping("/yes")
public class GetMyData {
    private List<String> WhyMakeMoreWorkForYourselfToRenameLater = new ArrayList<>();

    // GET TEST, HOPE THIS WORKS
    @GetMapping(path = "/account")
    public String GetTheStringDotCom() {
        WhyMakeMoreWorkForYourselfToRenameLater.add("THIS WORKS YEAHOO BEACHES");

        return "THIS WORKS YEAHOO BEACHES";
    }

    @GetMapping(path = "/profile")
    public List<String> GetTheProfileDotCom() {
        if (!WhyMakeMoreWorkForYourselfToRenameLater.isEmpty()) {
            WhyMakeMoreWorkForYourselfToRenameLater.clear();
        }

        WhyMakeMoreWorkForYourselfToRenameLater.add("THIS WORKS YEAHOO MOUNTAINS");

        return WhyMakeMoreWorkForYourselfToRenameLater;
    }
}
