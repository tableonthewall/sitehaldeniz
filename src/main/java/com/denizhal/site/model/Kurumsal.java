package com.denizhal.site.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name="kurumsal")
public class Kurumsal {
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
    private String foto_url_1;

    @Column(nullable=false)
    @NotEmpty()
    private String title2;

    @Column(nullable = false ,columnDefinition = "TEXT")
    @NotEmpty
    private String details2;

    @Column(nullable = false)
    @NotEmpty
    private String foto_url_2;

    @Column(nullable=false)
    @NotEmpty()
    private String title3;

    @Column(nullable = false ,columnDefinition = "TEXT")
    @NotEmpty
    private String details3;

    @Column(nullable = false)
    @NotEmpty
    private String foto_url_3;

    @Column(nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate savedate;

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

    public String getFoto_url_1() {
        return foto_url_1;
    }

    public void setFoto_url_1(String foto_url_1) {
        this.foto_url_1 = foto_url_1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getDetails2() {
        return details2;
    }

    public void setDetails2(String details2) {
        this.details2 = details2;
    }

    public String getFoto_url_2() {
        return foto_url_2;
    }

    public void setFoto_url_2(String foto_url_2) {
        this.foto_url_2 = foto_url_2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getDetails3() {
        return details3;
    }

    public void setDetails3(String details3) {
        this.details3 = details3;
    }

    public String getFoto_url_3() {
        return foto_url_3;
    }

    public void setFoto_url_3(String foto_url_3) {
        this.foto_url_3 = foto_url_3;
    }

    public LocalDate getSavedate() {
        return savedate;
    }

    public void setSavedate(LocalDate savedate) {
        this.savedate = savedate;
    }
}
