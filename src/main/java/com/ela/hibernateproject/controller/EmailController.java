package com.ela.hibernateproject.controller;

import com.ela.hibernateproject.model.CategoryElement;
import com.ela.hibernateproject.model.Email;
import com.ela.hibernateproject.service.CategoryElementService;
import com.ela.hibernateproject.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CategoryElementService categoryElementService;

    @RequestMapping("/emailList")
    public ModelAndView listEmail(ModelAndView model) {
        List<Email> listEmail = emailService.findAll();
        model.setViewName("email/EmailList");
        model.addObject("email/listEmail", listEmail);
        return model;
    }

    @RequestMapping(value = "/saveEmail", method = RequestMethod.POST)
    public ModelAndView saveEmail(@ModelAttribute("email") Email email,
                                  BindingResult result) {

        emailService.save(email);
        return new ModelAndView("redirect:/emailList");
    }

    @RequestMapping(value = "/newEmail", method = RequestMethod.GET)
    public ModelAndView newEmail(@ModelAttribute("email") Email email,
                                 BindingResult result) {
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
                email.setCategoryElement(categoryElement);
            }
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("emailList", emailService.findAll());
        model.put("categoryElementList", categoryElementService.findAll());
        return new ModelAndView("email/EmailForm", model);

    }

    @RequestMapping(value = "/deleteEmail", method = {RequestMethod.GET})
    public ModelAndView deleteEmail(HttpServletRequest request) {
        int emailId = Integer.parseInt(request.getParameter("id"));
        emailService.deleteById(emailId);
        return new ModelAndView("redirect:/emailList");
    }
}

