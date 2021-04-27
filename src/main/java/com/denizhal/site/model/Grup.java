package com.denizhal.site.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "grup")
public class Grup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty
    private String grupAdi;

    @Column
    @NotEmpty
    private String aciklama;

    @OneToOne(mappedBy = "grup")
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
