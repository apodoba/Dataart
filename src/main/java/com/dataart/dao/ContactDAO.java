package com.dataart.dao;

import java.util.List;

import com.dataart.domain.Contact;

public interface ContactDAO {

    public void addContact(Contact contact);

    public List<Contact> listContact();

    public void removeContact(Integer id);
}