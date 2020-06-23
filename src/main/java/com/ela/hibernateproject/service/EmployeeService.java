package com.ela.hibernateproject.service;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id) throws ItemNotFoundException;

    Employee update(Employee employee);

    void delete(int id);
}

