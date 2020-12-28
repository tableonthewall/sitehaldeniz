package com.denizhal.site.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    @NotEmpty()
    private String adSoyad;

    @Column(nullable=false)
    @NotEmpty
    @Email(message="{errors.invalid_email}")
    private String email;

    @Column(nullable=false)
    @NotEmpty()
    private String title;

    @Column(nullable=false)
    @NotEmpty()
    private String message;

    @Column(nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate savedate;

    public LocalDate getSavedate() {
        return savedate;
    }

    public void setSavedate(LocalDate savedate) {
        this.savedate = savedate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
