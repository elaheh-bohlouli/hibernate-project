package com.ela.hibernateproject.service.serviceClass;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.Category;
import com.ela.hibernateproject.repository.CategoryRepository;
import com.ela.hibernateproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceClass implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Category category) {
        category.setLastModifiedDataTime(new Date());
        category.setActive(true);
        category.setCreateDataTime(new Date());
        category.setManualId("category_MId " + category.getId());
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category findById(int id) throws ItemNotFoundException {
        return categoryRepository.findById(id).orElseThrow(
                ItemNotFoundException::new);
    }

    @Override
    public Category update(Category category) {
        category.setLastModifiedDataTime(new Date());
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }


}