package com.example.cms.services;

import com.example.cms.models.Page;
import com.example.cms.repositories.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    public Page getPage(String route) {
        Page page = pageRepository.findByRoute(route);
//        Page page = pageRepository.findById(1l).get();
        return page;
    }

    public Page createPage( Map<Object, Object> payload) {
        Page page = new Page();
        if(payload.containsKey("id")) page.setId(Long.parseLong((String)payload.get("id")));
        page.setName((String) payload.get("name"));
        page.setDescription((String) payload.get("description"));
        page.setRoute((String) payload.get("route"));
        page.setContent((String) payload.get("content"));
        pageRepository.save(page);
        return page;
    }

    public List<Page> allPages(){
        return pageRepository.findAllPagesWithoutContent();
    }

    public Page getPageById(long id){
        Optional<Page> page = pageRepository.findById(id);
        if(page.isPresent()){
            return page.get();
        }
        return null;
    }

    public void removePageById(long id){
        pageRepository.deleteById(id);
    }
}
