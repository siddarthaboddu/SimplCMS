package com.example.cms.repositories;

import com.example.cms.models.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends CrudRepository<Page, Long> {
    public Page findByRoute(String route);
}
