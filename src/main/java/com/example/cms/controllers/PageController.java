package com.example.cms.controllers;

import com.example.cms.models.Page;
import com.example.cms.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @Autowired
    PageService pageService;

    @GetMapping("/admin/pages/new")
    public String newPage(){
        return "admin/pages/new";
    }

    @PostMapping("/admin/pages/new")
    public ResponseEntity addPage(@RequestBody Map<Object, Object> payload){
        System.out.println(payload);
        try {
            pageService.createPage(payload);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/admin/pages")
    public ModelAndView allPages(){
        List<Page> pages = pageService.allPages();

        ModelAndView modelAndView = new ModelAndView("admin/pages/all");
        modelAndView.addObject("pages",pages);

        return modelAndView;
    }

    @GetMapping("/admin/pages/{id}")
    public ModelAndView viewPage(@PathVariable("id") long id){
        Page page = pageService.getPageById(id);

        ModelAndView modelAndView = new ModelAndView("/admin/pages/edit");
        modelAndView.addObject("page",page);

        return modelAndView;
    }

    @PutMapping("/admin/pages/{id}")
    public ResponseEntity editPage(@RequestBody Map<Object, Object> payload){
//        pageService.removePageById(Long.parseLong((String)payload.get("id")));
        try {
            pageService.createPage(payload);
        }catch (Exception e){
            for(int i=0;i<100;i++){
                System.out.println(e);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
