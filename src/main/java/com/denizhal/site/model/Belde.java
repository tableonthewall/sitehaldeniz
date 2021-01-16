package com.denizhal.site.model;

public class Belde {
    private Integer id;
    private String BeldeAdi;

    public Belde(Integer id, String ilAdi) {
        this.id = id;
        BeldeAdi = ilAdi;
    }
    public Belde(){};

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
}
