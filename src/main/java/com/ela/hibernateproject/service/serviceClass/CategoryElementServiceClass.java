package com.ela.hibernateproject.service.serviceClass;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.CategoryElement;
import com.ela.hibernateproject.repository.CategoryElementRepository;
import com.ela.hibernateproject.service.CategoryElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CategoryElementServiceClass implements CategoryElementService {

    @Autowired
    private CategoryElementRepository categoryElementRepository;

    @Override
    @Transactional
    public List<CategoryElement> findAll() {
        return categoryElementRepository.findAll();
    }

    @Override
    @Transactional
    public void save(CategoryElement categoryElement) {
        categoryElement.setLastModifiedDataTime(new Date());
        categoryElement.setActive(true);
        categoryElement.setCreateDataTime(new Date());
        categoryElement.setManualId("category_MId " + categoryElement.getId());
        categoryElementRepository.save(categoryElement);
    }

    @Override
    @Transactional
    public CategoryElement findById(int id) throws ItemNotFoundException {
        return categoryElementRepository.findById(id).orElseThrow(
                ItemNotFoundException::new);
    }

    @Override
    public CategoryElement update(CategoryElement categoryElement) {
        categoryElement.setLastModifiedDataTime(new Date());
        return categoryElementRepository.save(categoryElement);
    }

    @Override
    @Transactional
    public void delete(int id) {
        categoryElementRepository.deleteById(id);
    }

}