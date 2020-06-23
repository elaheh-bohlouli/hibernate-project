package com.ela.hibernateproject.service;

import com.ela.hibernateproject.exceptions.DoNotMatchThisAskDayOffWithThisHeadException;
import com.ela.hibernateproject.exceptions.EmployeeIsNotHeadException;
import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.AskDayOff;
import com.ela.hibernateproject.model.Employee;

import java.util.List;

public interface AskDayOffService {

    List<AskDayOff> findAllAskDayOffOneHead(Employee head) throws EmployeeIsNotHeadException;

    List<AskDayOff> findAll();

    void save(AskDayOff askDayOff);

    AskDayOff findById(int id) throws ItemNotFoundException;

    AskDayOff update(AskDayOff askDayOff);

    void delete(int theId);

    void acceptAskDayOff(int id, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException;

    void rejectAskDayOff(int id, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException;

}
