package com.ela.hibernateproject.service.serviceClass;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.Email;
import com.ela.hibernateproject.repository.EmailRepository;
import com.ela.hibernateproject.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmailServiceClass implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Override
    @Transactional
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Email email) {
        emailRepository.save(email);
    }

    @Override
    @Transactional
    public Email findById(int id) throws ItemNotFoundException {
        return emailRepository.findById(id).orElseThrow(
                ItemNotFoundException::new);
    }

    @Override
    @Transactional
    public void deleteById(int id){
        emailRepository.deleteById(id);
    }
}

