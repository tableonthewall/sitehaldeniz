package com.denizhal.site.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

    @Column(nullable = false)
    @NotEmpty
    private String version;

    @Column(nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate savedate;

    @Column
    private String demo_link;

    @Column
    private String app_link;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Propose> proposes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDate getSavedate() {
        return savedate;
    }

    public void setSavedate(LocalDate savedate) {
        this.savedate = savedate;
    }


    public String getDemo_link() {
        return demo_link;
    }

    public void setDemo_link(String demo_link) {
        this.demo_link = demo_link;
    }

    public String getApp_link() {
        return app_link;
    }

    public void setApp_link(String app_link) {
        this.app_link = app_link;
    }

    public List<Propose> getProposes() {
        return proposes;
    }

    public void setProposes(List<Propose> proposes) {
        this.proposes = proposes;
    }
}
