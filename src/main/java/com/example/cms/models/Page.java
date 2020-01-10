package com.example.cms.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// template page snippet

@Data
@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String route;

//    @JsonIgnore
    private String content;

    public Page(Long id,String name,String route,String description){
        this.id = id;
        this.name = name;
        this.route = route;
        this.description = description;
    }

    public Page(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public Page(String name, String route, String content) {
        this.name = name;
        this.route = route;
        this.content = content;
    }

    public Page() {
    }
}
