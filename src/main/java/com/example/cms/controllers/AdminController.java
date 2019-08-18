package com.example.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping({"/admin", "/admin/welcome"})
    public String welcome(Model model) {
        return "admin/homepage";
    }


}
