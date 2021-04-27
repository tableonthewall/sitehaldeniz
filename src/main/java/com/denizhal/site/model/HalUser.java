package com.denizhal.site.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "haluser")
public class HalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty
    private String ticariUnvan;

    @Column(nullable = false)
    @NotNull(message= "müşteri kod boş olamaz")
    @Range(min = 1)
    private int musteriKodu;

    @Column(nullable = false)
    @NotEmpty
    private String adi;

    @Column(nullable = false)
    @NotEmpty
    private String soyadi;

    @Column(nullable=false, unique=true)
    @NotEmpty
    private String tcKimlikNo;

    @Column
    private String vergiNo;

    @Column
    private String vergiDairesi;

    //OnetoOne relation genelBilgiler sınıfına ait id'yi kullanıyoruz.
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="genelBilgiler_id",referencedColumnName = "id")
    private GenelBilgiler genelBilgiler;

    //Bu kısım programı kullanan halci ile (mustahsil ve müşterileri) birbirine bağladığımız kısım.
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private User user;


    //Burası hal kullanıcısına rol eklediğimiz bölüm bir hal kullan
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="halRole_id",nullable = false)
    private HalRole halRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicariUnvan() {
        return ticariUnvan;
    }

    public void setTicariUnvan(String ticariUnvan) {
        this.ticariUnvan = ticariUnvan;
    }

    public int getMusteriKodu() {
        return musteriKodu;
    }

    public void setMusteriKodu(int musteriKodu) {
        this.musteriKodu = musteriKodu;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public String getVergiNo() {
        return vergiNo;
    }

    public void setVergiNo(String vergiNo) {
        this.vergiNo = vergiNo;
    }

    public String getVergiDairesi() {
        return vergiDairesi;
    }

    public void setVergiDairesi(String vergiDairesi) {
        this.vergiDairesi = vergiDairesi;
    }

    public GenelBilgiler getGenelBilgiler() {
        return genelBilgiler;
    }

    public void setGenelBilgiler(GenelBilgiler genelBilgiler) {
        this.genelBilgiler = genelBilgiler;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HalRole getHalRole() {
        return halRole;
    }

    public void setHalRole(HalRole halRole) {
        this.halRole = halRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HalUser halUser = (HalUser) o;
        return musteriKodu == halUser.musteriKodu &&
                id.equals(halUser.id) &&
                ticariUnvan.equals(halUser.ticariUnvan) &&
                adi.equals(halUser.adi) &&
                soyadi.equals(halUser.soyadi) &&
                tcKimlikNo.equals(halUser.tcKimlikNo) &&
                vergiNo.equals(halUser.vergiNo) &&
                vergiDairesi.equals(halUser.vergiDairesi) &&
                Objects.equals(genelBilgiler, halUser.genelBilgiler) &&
                Objects.equals(user, halUser.user) &&
                Objects.equals(halRole, halUser.halRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticariUnvan, musteriKodu, adi, soyadi, tcKimlikNo, vergiNo, vergiDairesi, genelBilgiler, user, halRole);
    }
}
