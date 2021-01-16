package com.denizhal.site.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grup")
public class Grup {
    private Integer id;
    private String grupAdi;
    private String aciklama;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrupAdi() {
        return grupAdi;
    }

    public void setGrupAdi(String grupAdi) {
        this.grupAdi = grupAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
