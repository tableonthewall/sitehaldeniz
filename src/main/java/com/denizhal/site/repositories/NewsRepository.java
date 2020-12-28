package com.denizhal.site.repositories;

import com.denizhal.site.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {
    News findByTitle(String title);
    List<News> findByOrderBySavedateAsc();

    //@Query("SELECT p FROM news WHERE p.title LIKE %?1%")
    Page<News> findAllByTitle(String keyword, Pageable pageable);



}
