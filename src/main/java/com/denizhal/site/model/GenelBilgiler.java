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
    private Float kesintiOranı;

    @Column
    private boolean bagkurKesenegi;

    //fiş komis.oranı ve 2.komisyon oranı alanları iptal edilmiştir
    @Column
    private Float komisyonOranı;

    @OneToOne(mappedBy = "genelBilgiler")
    private HalUser halUser;



}
