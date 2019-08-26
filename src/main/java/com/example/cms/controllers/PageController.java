package com.example.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/admin/pages/new")
    public String newPage(){
        return "admin/pages/new";
    }

}
