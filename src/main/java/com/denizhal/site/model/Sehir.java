package com.denizhal.site.model;

public class Sehir {
    private Integer id;
    private String IlAdi;

    public Sehir(Integer id, String ilAdi) {
        this.id = id;
        IlAdi = ilAdi;
    }
    public Sehir(){};

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
