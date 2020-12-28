package com.denizhal.site.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="news")
public class News implements Comparable<News> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    @NotEmpty()
    private String title;

    @Column(nullable = false ,columnDefinition = "TEXT")
    @NotEmpty
    private String details;

    @Column(nullable = false)
    @NotEmpty
    private String foto_url;

    @Column
    private Integer ziyaret;



    //TODO buraya time validation gelecek
    @Column(nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate savedate;
    /*
    @ManyToMany(mappedBy = "news")
    private List<User> users;
     */

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFoto_url() {
        return foto_url;
    }

    public void setFoto_url(String foto_url) {
        this.foto_url = foto_url;
    }
    public LocalDate getSavedate() {
        return savedate;
    }

    public void setSavedate(LocalDate savedate) {
        this.savedate = savedate;
    }
    /*
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    */

    public Integer getZiyaret() {
        return ziyaret;
    }

    public void setZiyaret(Integer ziyaret) {
        this.ziyaret = ziyaret;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(News o) {
        if(getZiyaret()==null || o.getZiyaret()==null){
            return 0;
        }
        return getZiyaret().compareTo(o.getZiyaret());
    }
}
