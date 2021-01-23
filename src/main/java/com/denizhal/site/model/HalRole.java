package com.denizhal.site.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="halroles")
public class HalRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, unique = true)
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "halRole",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<HalUser> halUsers;

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

    public List<HalUser> getHalUsers() {
        return halUsers;
    }

    public void setHalUsers(List<HalUser> halUsers) {
        this.halUsers = halUsers;
    }
}
