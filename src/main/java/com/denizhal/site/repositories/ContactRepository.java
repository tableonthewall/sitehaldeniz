package com.denizhal.site.repositories;

import com.denizhal.site.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
