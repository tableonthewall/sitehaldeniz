package com.denizhal.site.service;

import com.denizhal.site.model.News;
import com.denizhal.site.repositories.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Transactional ekledim
@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getNews(){
        List<News> haberler=newsRepository.findAll(Sort.by(Sort.Direction.DESC,"savedate"));
        //haberin ilk 30 karakterini details olarak gönderdim.
        for(News haber:haberler){
            if(haber.getDetails().length()>30){
                haber.setDetails(haber.getDetails().substring(0,30));
            }

            System.out.println("tarih: "+haber.getSavedate()+" format: "+haber.getSavedate().getClass());
        }
        return haberler;
    }

    @Override
    public Page<News> searchNews(String keyword, Pageable pageable) {
        if(keyword.equals("")){
            return newsRepository.findAll(pageable);
        }

        return newsRepository.findAllByTitle(keyword,pageable);
    }



    @Override
    public Page<News> findPaginated(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public List<News> shortNews(List<News> news) {
        for(News haber:news){
            if(haber.getDetails().length()>100){
                haber.setDetails(haber.getDetails().substring(0,100));
            }
        }
        return news;
    }

    public List<News> getTopList(){
        List<News> topNews=newsRepository.findAll();
        List<News> sendTopNews=new ArrayList<>();
        int sayac=0;
        Collections.sort(topNews);
        Collections.reverse(topNews);
        for(News haber:topNews){
            if(sayac>=5){
                break;
            }
            sayac++;
            sendTopNews.add(haber);
        }
        return sendTopNews;
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    public void ziyaretciArttir(Integer id){
        News news=newsRepository.findById(id).get();
        news.setZiyaret(news.getZiyaret()+1);
        this.save(news);
    }

    @Override
    public News getNew(Integer id) {
        News news=newsRepository.findById(id).get();
          /* Bir string ifadenin içinde bir \n ifadesini <br> ile değiştiren metot
        StringBuffer text=new StringBuffer(news.getDetails());
        int say=(new String(text)).indexOf('\n');
        System.out.println("satır sayısı:"+say);
        while(say>0){
            text.replace(say,say+1,"+'<br>'+");
            say=(new String(text)).indexOf('\n');
        }
        news.setDetails(new String(text));
         */
        return news;
    }



    @Override
    public void delete(Integer id) {
        newsRepository.deleteById(id);
    }

    @Override
    public News getNew(String title) {
        return newsRepository.findByTitle(title);
    }
}
