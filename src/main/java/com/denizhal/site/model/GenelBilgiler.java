package com.denizhal.site.model;

import javax.persistence.*;
import java.util.EnumMap;

@Entity
@Table(name = "genelbilgiler")
public class GenelBilgiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private EnumMap<Sifati,String> sifati=new EnumMap<Sifati, String>(Sifati.class);

    @Column
    private VergiTuru vergiTuru;

    @Column
    private VergiDurumu vergiDurumu;

    @Column
    private Ulke ulkeKodu;

    @Column
    private Sehir sehir;

    @Column
    private Ilce ilce;

    @Column
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

    @Column
    private Grup grup;

    @Column
    private Float kesintiOranı;

    @Column
    private boolean bagkurKesenegi;

    //fiş komis.oranı ve 2.komisyon oranı alanları iptal edilmiştir
    @Column
    private Float komisyonOranı;

    @OneToOne(mappedBy = "genelBilgiler")
    private HalUser halUser;



}
