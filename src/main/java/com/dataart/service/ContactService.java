package com.dataart.service;

import java.util.List;

import com.dataart.domain.Contact;

public interface ContactService {

    public void addContact(Contact contact);

    public List<Contact> listContact();

    public void removeContact(Integer id);
}