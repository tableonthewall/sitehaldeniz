package com.denizhal.site.service;

import com.denizhal.site.model.News;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface NewsService {
    List<News> getNews();
    Page<News> searchNews(String keyword,Pageable pageable);
    Page<News> findPaginated(Pageable pageable);
    List<News> shortNews(List<News> news);
    void save(News news);
    News getNew(Integer id);
    void delete(Integer id);
    News getNew(String title);
}
