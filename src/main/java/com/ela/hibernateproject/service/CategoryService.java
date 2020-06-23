package com.ela.hibernateproject.service;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void save(Category category);

    Category findById(int id) throws ItemNotFoundException;

    Category update(Category category);

    void delete(int id);
}
