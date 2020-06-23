package com.ela.hibernateproject.service.serviceClass;

import com.ela.hibernateproject.exceptions.DoNotMatchThisAskDayOffWithThisHeadException;
import com.ela.hibernateproject.exceptions.EmployeeIsNotHeadException;
import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.AskDayOff;
import com.ela.hibernateproject.model.CategoryElement;
import com.ela.hibernateproject.model.Employee;
import com.ela.hibernateproject.repository.AskDayOffRepository;
import com.ela.hibernateproject.repository.CategoryElementRepository;
import com.ela.hibernateproject.service.AskDayOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AskDayOffServiceClass implements AskDayOffService {

    @Autowired
    private AskDayOffRepository askDayOffRepository;
    @Autowired
    private CategoryElementRepository categoryElementRepository;

    @Override
    @Transactional
    public List<AskDayOff> findAll() {
        return askDayOffRepository.findAll();
    }

    @Override
    @Transactional
    public void save(AskDayOff askDayOff) {
        askDayOff.setLastModifiedDataTime(new Date());
        askDayOff.setActive(true);
        askDayOff.setCreateDataTime(new Date());
        askDayOff.setManualId("askDayOff_MId " + askDayOff.getId());
        askDayOffRepository.save(askDayOff);
    }

    @Override
    @Transactional
    public AskDayOff findById(int id) throws ItemNotFoundException {
        return askDayOffRepository.findById(id).orElseThrow(
                ItemNotFoundException::new);
    }

    @Override
    public AskDayOff update(AskDayOff askDayOff) {
        askDayOff.setLastModifiedDataTime(new Date());
        return askDayOffRepository.save(askDayOff);    }

    @Override
    @Transactional
    public void delete(int id) {
        askDayOffRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<AskDayOff> findAllAskDayOffOneHead(Employee head) throws EmployeeIsNotHeadException {
        List<AskDayOff> askDayOffList = new ArrayList();
        if (!head.getCategoryElement().getRole().equals("head")) {
            throw new EmployeeIsNotHeadException();
        } else {
            for (AskDayOff askDayOff : askDayOffList) {
                if (askDayOff.getEmployee().getHead().equals("head")) {
                    askDayOffList.add(askDayOff);
                }
            }
        }
        return askDayOffList;
    }

/*            Stream<AskDayOff> askDayOffStream = askDayOffRepository.findAll().stream()
                    .filter(askDayOff -> askDayOff.getEmployee().getHead().equals(head));
            askDayOffList.addAll((Collection<? extends AskDayOff>) askDayOffStream);
        }
        return askDayOffList;
        }
 */

    @Override
    @Transactional
    public void acceptAskDayOff(int id, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        for (AskDayOff askDayOff : findAllAskDayOffOneHead(head)) {
            if (askDayOff.getId() != id) {
                throw new DoNotMatchThisAskDayOffWithThisHeadException();
            } else {
                CategoryElement accepted = (CategoryElement) categoryElementRepository.findAll().stream()
                        .filter(categoryElements -> categoryElements.getRole().equals("accepted"));
                askDayOff.setStatus(accepted);
            }
        }
        ;
    }

    @Override
    @Transactional
    public void rejectAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        for (AskDayOff askDayOff : findAllAskDayOffOneHead(head)) {
            if (askDayOff.getId() != askDayOffId) {
                throw new DoNotMatchThisAskDayOffWithThisHeadException();
            } else {
                CategoryElement accepted = (CategoryElement) categoryElementRepository.findAll().stream()
                        .filter(categoryElements -> categoryElements.getRole().equals("rejected"));
                askDayOff.setStatus(accepted);
            }
        }
        ;
    }
}