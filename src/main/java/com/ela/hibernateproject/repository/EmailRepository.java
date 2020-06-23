package com.ela.hibernateproject.repository;

import com.ela.hibernateproject.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository  extends JpaRepository<Email, Integer> {
}
