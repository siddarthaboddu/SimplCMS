package com.example.cms.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {


//    @PreAuthorize("hasAnyRole('')")
    @GetMapping({ "/admin/**", "/admin", "/admin/" })
    public String welcome(Model model, final HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth instanceof AnonymousAuthenticationToken) {
            return "redirect:/admin/login";
        }

        for(int i=0;i<5;i++) System.out.println(request.getRequestURI()  +"    -   "+request.getRequestURI());
        String requestURI = request.getRequestURI();
        if(requestURI.charAt(0) == '/'){
            requestURI = requestURI.replaceFirst("/","");
        }
        for(int i=0;i<5;i++) System.out.println(request.getRequestURI()  +"    -   "+requestURI);
        if(requestURI.equals("/admin/") || requestURI.equals("admin") || requestURI.equals("admin/")){
            return "admin/homepage";
        }
        else{
            return "redirect:/"+requestURI;
        }
    }


}
