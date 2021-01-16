package com.denizhal.site.model;

import javax.persistence.*;

@Entity
@Table(name = "sehir")
public class Sehir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String IlAdi;

    @OneToOne(mappedBy = "sehir")
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

    public String getIlAdi() {
        return IlAdi;
    }

    public void setIlAdi(String ilAdi) {
        IlAdi = ilAdi;
    }
}
