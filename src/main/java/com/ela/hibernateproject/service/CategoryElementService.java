package com.ela.hibernateproject.service;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.CategoryElement;

import java.util.List;

public interface CategoryElementService {

    List<CategoryElement> findAll();

    void save(CategoryElement categoryElement);

    CategoryElement findById(int id) throws ItemNotFoundException;

    CategoryElement update(CategoryElement categoryElement);

    void delete(int id);
}
