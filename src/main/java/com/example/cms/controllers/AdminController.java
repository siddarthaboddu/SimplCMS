package com.example.cms.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


//    @PreAuthorize("hasAnyRole('')")
    @GetMapping({"/admin", "/admin/welcome"})
    public String welcome(Model model) {
        return "admin/homepage";
    }


}
