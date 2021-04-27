package com.denizhal.site.model;

import javax.persistence.*;

@Entity
@Table(name = "genelbilgiler")
public class GenelBilgiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Sifati sifati;

    @Column
    private VergiTuru vergiTuru;

    @Column
    private VergiDurumu vergiDurumu;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ulke_id",referencedColumnName = "id")
    private Ulke ulkeKodu;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="il_id",referencedColumnName = "id")
    private Sehir sehir;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ilce_id",referencedColumnName = "id")
    private Ilce ilce;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="belde_id",referencedColumnName = "id")
    private Belde belde;

    @Column
    private String gsmNo;

    @Column
    private String telNo;

    @Column
    private String plaka;

    @Column
    private String faturaAdresi;

    @Column
    private CalismaSekli calismaSekli;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="grup_id",referencedColumnName = "id")
    private Grup grup;

    @Column
    private Float kesintiOrani;

    @Column
    private boolean bagkurKesenegi;

    //fiş komis.oranı ve 2.komisyon oranı alanları iptal edilmiştir
    @Column
    private Float komisyonOrani;

    @OneToOne(mappedBy = "genelBilgiler")
    private HalUser halUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSifati(Sifati sifati) {
        this.sifati = sifati;
    }

    public void setVergiTuru(VergiTuru vergiTuru) {
        this.vergiTuru = vergiTuru;
    }

    public void setVergiDurumu(VergiDurumu vergiDurumu) {
        this.vergiDurumu = vergiDurumu;
    }

    public void setUlkeKodu(Ulke ulkeKodu) {
        this.ulkeKodu = ulkeKodu;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }

    public void setIlce(Ilce ilce) {
        this.ilce = ilce;
    }

    public void setBelde(Belde belde) {
        this.belde = belde;
    }

    public void setGsmNo(String gsmNo) {
        this.gsmNo = gsmNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public void setFaturaAdresi(String faturaAdresi) {
        this.faturaAdresi = faturaAdresi;
    }

    public void setCalismaSekli(CalismaSekli calismaSekli) {
        this.calismaSekli = calismaSekli;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    public void setKesintiOrani(Float kesintiOrani) {
        this.kesintiOrani = kesintiOrani;
    }

    public void setBagkurKesenegi(boolean bagkurKesenegi) {
        this.bagkurKesenegi = bagkurKesenegi;
    }

    public void setKomisyonOrani(Float komisyonOrani) {
        this.komisyonOrani = komisyonOrani;
    }

    public void setHalUser(HalUser halUser) {
        this.halUser = halUser;
    }

    public Sifati getSifati() {
        return sifati;
    }

    public VergiTuru getVergiTuru() {
        return vergiTuru;
    }

    public VergiDurumu getVergiDurumu() {
        return vergiDurumu;
    }

    public Ulke getUlkeKodu() {
        return ulkeKodu;
    }

    public Sehir getSehir() {
        return sehir;
    }

    public Ilce getIlce() {
        return ilce;
    }

    public Belde getBelde() {
        return belde;
    }

    public String getGsmNo() {
        return gsmNo;
    }

    public String getTelNo() {
        return telNo;
    }

    public String getPlaka() {
        return plaka;
    }

    public String getFaturaAdresi() {
        return faturaAdresi;
    }

    public CalismaSekli getCalismaSekli() {
        return calismaSekli;
    }

    public Grup getGrup() {
        return grup;
    }

    public Float getKesintiOrani() {
        return kesintiOrani;
    }

    public boolean isBagkurKesenegi() {
        return bagkurKesenegi;
    }

    public Float getKomisyonOrani() {
        return komisyonOrani;
    }

    public HalUser getHalUser() {
        return halUser;
    }
}
