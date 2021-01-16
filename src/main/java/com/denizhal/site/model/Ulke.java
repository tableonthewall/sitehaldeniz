package com.denizhal.site.model;

import javax.persistence.*;

@Entity
@Table(name = "ulke")
public class Ulke {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String UlkeAdi;

    @OneToOne(mappedBy = "ulkeKodu")
    private GenelBilgiler genelBilgiler;


    public GenelBilgiler getGenelBilgiler() {
        return genelBilgiler;
    }

    public void setGenelBilgiler(GenelBilgiler genelBilgiler) {
        this.genelBilgiler = genelBilgiler;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUlkeAdi() {
        return UlkeAdi;
    }

    public void setUlkeAdi(String ulkeAdi) {
        UlkeAdi = ulkeAdi;
    }
}
