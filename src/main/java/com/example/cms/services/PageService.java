package com.example.cms.services;

import com.example.cms.models.Page;
import com.example.cms.repositories.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    public Page getPage(String route) {
        Page page = pageRepository.findByRoute(route);
//        Page page = pageRepository.findById(1l).get();
        return page;
    }
}
