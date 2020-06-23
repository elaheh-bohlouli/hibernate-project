package com.ela.hibernateproject.controller;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.Category;
import com.ela.hibernateproject.model.CategoryElement;
import com.ela.hibernateproject.service.CategoryElementService;
import com.ela.hibernateproject.service.CategoryService;
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
public class CategoryElementController {

    @Autowired
    private CategoryElementService categoryElementService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categoryElementList")
    public ModelAndView listCategoryElement(ModelAndView model) {
        List<CategoryElement> listCategoryElement = categoryElementService.findAll();
        model.setViewName("categoryElement/CategoryElementList");
        model.addObject("listCategoryElement", listCategoryElement);
        return model;
    }

    /*    @RequestMapping(value = "/saveCategoryElement", method = RequestMethod.POST)
        public ModelAndView saveCategoryElement(@ModelAttribute("categoryElement") CategoryElement categoryElement) {
            int id = categoryElement.getCategory().getId();
            categoryElementService.save(categoryElement);
            return new ModelAndView("redirect:categoryElement/categoryElementList");
        }
            @RequestMapping(value = "/newCategoryElement", method = RequestMethod.GET)
        public ModelAndView addCategoryElement(ModelAndView model, HttpServletRequest request) throws ItemNotFoundException {
            CategoryElement categoryElement = new CategoryElement();
            //int categoryId = Integer.parseInt(request.getParameter("id"));
            //List<Category> categoryList = categoryService.findAll();
            model.addObject("categoryElement", categoryElement);
            //model.addObject("categoryList", categoryList);
            model.setViewName("categoryElement/CategoryElementForm");
            return model;}
            */
    @RequestMapping(value = "/saveCategoryElement", method = RequestMethod.POST)
    public ModelAndView saveCategoryElement(@ModelAttribute("categoryElement") CategoryElement categoryElement,
                                            BindingResult result) {

        categoryElementService.save(categoryElement);
        return new ModelAndView("redirect:/categoryElementList");
    }

    @RequestMapping(value = "/newCategoryElement", method = RequestMethod.GET)
    public ModelAndView newCategoryElement(@ModelAttribute("categoryElement") CategoryElement categoryElement,
                                           BindingResult result) {
        //int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = null;
        if (categoryService.findAll() == null) {
            return new ModelAndView("redirect:/categoryElementList");

        } else if (categoryService.findAll() != null)
            for (Category cate : categoryService.findAll()) {
                category = new Category();
                category.setId(cate.getId());
                category.setName(cate.getName());
                category.setManualId(cate.getManualId());
                category.setCreateDataTime(cate.getCreateDataTime());
                category.setLastModifiedDataTime(cate.getLastModifiedDataTime());
                category.setActive(cate.getActive());
                categoryElement.setCategory(category);
            }
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("categoryElementList", categoryElementService.findAll());
        model.put("categoryList", categoryService.findAll());
        return new ModelAndView("categoryElement/CategoryElementForm", model);

    }

    @RequestMapping(value = "/deleteCategoryElement", method = {RequestMethod.GET})
    public ModelAndView deleteCategoryElement(HttpServletRequest request) {
        int categoryElementId = Integer.parseInt(request.getParameter("id"));
        categoryElementService.delete(categoryElementId);
        return new ModelAndView("redirect:/categoryElementList");
    }

    @RequestMapping(value = "/editCategoryElement", method = {RequestMethod.GET})
    public ModelAndView editCategoryElement(HttpServletRequest request) throws ItemNotFoundException {
        int categoryElementId = Integer.parseInt(request.getParameter("id"));
        CategoryElement categoryElement = categoryElementService.findById(categoryElementId);
        categoryElementService.update(categoryElement);
        ModelAndView model = new ModelAndView("categoryElement/CategoryElementForm");
        model.addObject("categoryElement", categoryElement);
        return model;
    }
}

