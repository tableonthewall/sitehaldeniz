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
}
