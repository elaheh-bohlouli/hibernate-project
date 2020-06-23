package com.ela.hibernateproject.service;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.Email;

import java.util.List;

public interface EmailService {

    List<Email> findAll();

    void save(Email email);

    Email findById(int id) throws ItemNotFoundException;

    void deleteById(int id);
}
