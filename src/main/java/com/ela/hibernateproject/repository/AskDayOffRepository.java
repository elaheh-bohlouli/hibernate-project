package com.ela.hibernateproject.repository;

import com.ela.hibernateproject.model.AskDayOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskDayOffRepository extends JpaRepository<AskDayOff, Integer> {
}
