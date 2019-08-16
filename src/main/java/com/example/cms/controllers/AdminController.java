package com.example.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin/login";
    }

    @GetMapping("/admin")
    public String adminHomePage() {
        return "admin/homepage";
    }

}
