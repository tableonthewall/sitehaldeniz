package com.denizhal.site.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "proposes")
public class Propose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String sirketAdi;

    @Column(nullable = false)
    @NotBlank
    private String adSoyad;

    @Column(nullable = false)
    @NotBlank
    private String tel;

    @Column
    private String email;

    @Column
    private String il;

    @Column
    private String ilce;

    @Column(nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate savedate;



    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="product_id",nullable = false)
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSirketAdi() {
        return sirketAdi;
    }

    public void setSirketAdi(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public LocalDate getSavedate() {
        return savedate;
    }

    public void setSavedate(LocalDate savedate) {
        this.savedate = savedate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
