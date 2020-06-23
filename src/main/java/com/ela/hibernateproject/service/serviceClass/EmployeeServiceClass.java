package com.ela.hibernateproject.service.serviceClass;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.Employee;
import com.ela.hibernateproject.repository.EmployeeRepository;
import com.ela.hibernateproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceClass implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employee.setLastModifiedDataTime(new Date());
        employee.setActive(true);
        employee.setCreateDataTime(new Date());
        employee.setManualId("category_MId " + employee.getId());
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee findById(int id) throws ItemNotFoundException {
        return employeeRepository.findById(id).orElseThrow(
                ItemNotFoundException::new);
    }

    @Override
    public Employee update(Employee employee) {
        employee.setLastModifiedDataTime(new Date());
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}