package com.example.cms.repositories;

import com.example.cms.models.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends CrudRepository<Page, Long> {
    public Page findByRoute(String route);

    @Query("select new Page(p.id, p.name, p.route, p.description) from Page p")
    public List<Page> findAllPagesWithoutContent();
}
