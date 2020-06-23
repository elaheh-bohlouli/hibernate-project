package com.ela.hibernateproject.controller;

import com.ela.hibernateproject.exceptions.DoNotMatchThisAskDayOffWithThisHeadException;
import com.ela.hibernateproject.exceptions.EmployeeIsNotHeadException;
import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.AskDayOff;
import com.ela.hibernateproject.model.CategoryElement;
import com.ela.hibernateproject.model.Employee;
import com.ela.hibernateproject.service.AskDayOffService;
import com.ela.hibernateproject.service.CategoryElementService;
import com.ela.hibernateproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/AskDayOff")
public class AskDayOffController {
    @Autowired
    private AskDayOffService askDayOffService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CategoryElementService categoryElementService;

    @RequestMapping("/askDayOffList")
    public ModelAndView listAskDayOff(ModelAndView model) {
        List<AskDayOff> listAskDayOff = askDayOffService.findAll();
        model.setViewName("askDayOff/AskDayOffList");
        model.addObject("askDayOff/listAskDayOff", listAskDayOff);
        return model;
    }

    @RequestMapping(value = "/saveAskDayOff", method = RequestMethod.POST)
    public ModelAndView saveAskDayOff(@ModelAttribute("askDayOff") AskDayOff askDayOff,
                                      BindingResult result) {

        askDayOffService.save(askDayOff);
        return new ModelAndView("redirect:/askDayOffList");
    }

    @RequestMapping(value = "/newAskDayOff", method = RequestMethod.GET)
    public ModelAndView newAskDayOff(@ModelAttribute("askDayOff") AskDayOff askDayOff,
                                     BindingResult result) {
        Employee employee = null;
        if (employeeService.findAll() == null) {
            return new ModelAndView("redirect:/askDayOffList");

        } else if (employeeService.findAll() != null)
            for (Employee emp : employeeService.findAll()) {
                employee = new Employee();
                employee.setId(emp.getId());
                employee.setName(emp.getName());
                employee.setHead(emp.getHead());
                employee.setCategoryElement(emp.getCategoryElement());
                employee.setManualId(emp.getManualId());
                employee.setCreateDataTime(emp.getCreateDataTime());
                employee.setLastModifiedDataTime(emp.getLastModifiedDataTime());
                employee.setActive(emp.getActive());
                askDayOff.setEmployee(employee);
            }
        CategoryElement categoryElement = null;
        if (categoryElementService.findAll() == null) {
            return new ModelAndView("redirect:/emailList");

        } else if (categoryElementService.findAll() != null)
            for (CategoryElement cate : categoryElementService.findAll()) {
                categoryElement = new CategoryElement();
                categoryElement.setId(cate.getId());
                categoryElement.setName(cate.getName());
                categoryElement.setRole(cate.getRole());
                categoryElement.setCategory(cate.getCategory());
                categoryElement.setManualId(cate.getManualId());
                categoryElement.setCreateDataTime(cate.getCreateDataTime());
                categoryElement.setLastModifiedDataTime(cate.getLastModifiedDataTime());
                categoryElement.setActive(cate.getActive());
                askDayOff.setStatus(categoryElement);
            }
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("askDayOffList", askDayOffService.findAll());
        model.put("employeeList", employeeService.findAll());
        model.put("categoryElementList", categoryElementService.findAll());
        return new ModelAndView("askDayOff/AskDayOffForm", model);

    }

    @RequestMapping(value = "/deleteAskDayOff", method = {RequestMethod.GET})
    public ModelAndView deleteAskDayOff(HttpServletRequest request) {
        int askDayOffId = Integer.parseInt(request.getParameter("id"));
        askDayOffService.delete(askDayOffId);
        return new ModelAndView("redirect:/askDayOffList");
    }

    @RequestMapping(value = "/editAskDayOff", method = {RequestMethod.GET})
    public ModelAndView editAskDayOff(HttpServletRequest request) throws ItemNotFoundException {
        int askDayOffId = Integer.parseInt(request.getParameter("id"));
        AskDayOff askDayOff = askDayOffService.findById(askDayOffId);
        askDayOffService.update(askDayOff);
        ModelAndView model = new ModelAndView("askDayOff/AskDayOffForm");
        model.addObject("askDayOff", askDayOff);
        return model;
    }


    @RequestMapping("/listForOneHead")
    public String findAllAskDayOffOneHead(@ModelAttribute("employee") Employee head) throws EmployeeIsNotHeadException {
        List<AskDayOff> allAskDayOffOneHeadList = askDayOffService.findAllAskDayOffOneHead(head);
        return "allAskDayOffOneHeadList";
    }

    @RequestMapping("/accept")
    public String acceptAskDayOff(@ModelAttribute("askDayOffId") int askDayOffId, @ModelAttribute("head") Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        askDayOffService.acceptAskDayOff(askDayOffId, head);
        return "redirect:askDayOffList";
    }

    @RequestMapping("/reject")
    public String rejectAskDayOff(@ModelAttribute("askDayOffId") int askDayOffId, @ModelAttribute("head") Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        askDayOffService.rejectAskDayOff(askDayOffId, head);
        return "redirect:askDayOffList";
    }
}
