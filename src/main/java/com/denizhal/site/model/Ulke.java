package com.denizhal.site.model;

public class Ulke {
    private Integer id;
    private String UlkeAdi;

    public Ulke(Integer id, String ulkeAdi) {
        this.id = id;
        UlkeAdi = ulkeAdi;
    }

    public Ulke(){}

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
