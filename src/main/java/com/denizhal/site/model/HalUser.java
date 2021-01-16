package com.denizhal.site.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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
    @NotEmpty
    private int musteriKodu;

    @Column(nullable = false)
    @NotEmpty
    private String adi;

    @Column(nullable = false)
    @NotEmpty
    private String soyadi;

    @Column
    private String tcKimlikNo;

    @Column
    private String vergiNo;

    @Column
    private String vergiDairesi;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="genelBilgiler_id",referencedColumnName = "id")
    private GenelBilgiler genelBilgiler;

    //Bu kısım programı kullanan halci ile (mustahsil ve müşterileri birbirine bağladığımız kısım.
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private User user;


    //Burası hal kullanıcısına rol eklediğimiz bölüm bir hal kullan
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="halRole_id",nullable = false)
    private HalRole halRole;


}
