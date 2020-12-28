package com.denizhal.site.service;

import com.denizhal.site.model.Contact;

import java.util.List;

public interface ContactService {
    void save(Contact contact);
    List<Contact> getContacts();
    void delete(Integer id);
}
