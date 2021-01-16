package com.denizhal.site.model;

public class Ilce {
    private Integer id;
    private String IlceAdi;

    public Ilce(Integer id, String ilAdi) {
        this.id = id;
        IlceAdi = ilAdi;
    }
    public Ilce(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIlceAdi() {
        return IlceAdi;
    }

    public void setIlceAdi(String ilceAdi) {
        IlceAdi = ilceAdi;
    }
}
