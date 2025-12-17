package com.PhamKornbluhGroup.controllers;

import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class Error implements ErrorController {
    @RequestMapping("/error")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String handleError() {
        return "STOP THIS SHIT PLEASE";
    }
}
