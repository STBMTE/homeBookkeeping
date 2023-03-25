package com.example.homebookkeeping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controler {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/update")
    public String update(){
        return "update";
    }
}
