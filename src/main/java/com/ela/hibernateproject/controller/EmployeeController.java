package com.ela.hibernateproject.controller;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.CategoryElement;
import com.ela.hibernateproject.model.Employee;
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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CategoryElementService categoryElementService;

    @RequestMapping("/employeeList")
    public ModelAndView listEmployee(ModelAndView model) {
        List<Employee> listEmployee = employeeService.findAll();
        model.setViewName("employee/EmployeeList");
        model.addObject("employee/listEmployee", listEmployee);
        return model;
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee,
                                     BindingResult result) {

        employeeService.save(employee);
        return new ModelAndView("redirect:/employeeList");
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newEmployee(@ModelAttribute("employee") Employee employee,
                                    BindingResult result) {
        CategoryElement categoryElement = null;
        if (categoryElementService.findAll() == null) {
            return new ModelAndView("redirect:/employeeList");

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
                employee.setCategoryElement(categoryElement);
            }
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employeeList", employeeService.findAll());
        model.put("categoryElementList", categoryElementService.findAll());
        return new ModelAndView("employee/EmployeeForm", model);

    }

    @RequestMapping(value = "/deleteEmployee", method = {RequestMethod.GET})
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(employeeId);
        return new ModelAndView("redirect:/employeeList");
    }

    @RequestMapping(value = "/editEmployee", method = {RequestMethod.GET})
    public ModelAndView editEmployee(HttpServletRequest request) throws ItemNotFoundException {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(employeeId);
        employeeService.update(employee);
        ModelAndView model = new ModelAndView("employee/EmployeeForm");
        model.addObject("employee", employee);
        return model;
    }
}


/* @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employeeList = employeeService.findAll();
        modelAndView.addObject("employeeList", employeeList);
        modelAndView.addObject("roleList", new ArrayList<>());
        modelAndView.setViewName("employee/new");
        return modelAndView;
    }

    @RequestMapping("/new-employee")
    public ModelAndView insertEmployee(@ModelAttribute("employee") EmployeeDto employeeDto) throws EmpityBoxException {
        employeeService.create(employeeDto);
        List<Employee> employeeList = employeeService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employeeList", employeeList);
        modelAndView.setViewName("employee/list");
        return modelAndView;
    }*/