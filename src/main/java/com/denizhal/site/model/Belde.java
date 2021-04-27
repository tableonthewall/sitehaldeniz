package com.denizhal.site.model;

import javax.persistence.*;

@Entity
@Table(name = "belde")
public class Belde {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String BeldeAdi;

    @OneToOne(mappedBy = "belde")
    private GenelBilgiler genelBilgiler;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeldeAdi() {
        return BeldeAdi;
    }

    public void setBeldeAdi(String beldeAdi) {
        BeldeAdi = beldeAdi;
    }

    public GenelBilgiler getGenelBilgiler() {
        return genelBilgiler;
    }

    public void setGenelBilgiler(GenelBilgiler genelBilgiler) {
        this.genelBilgiler = genelBilgiler;
    }
}
