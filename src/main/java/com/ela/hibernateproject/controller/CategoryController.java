package com.ela.hibernateproject.controller;

import com.ela.hibernateproject.exceptions.ItemNotFoundException;
import com.ela.hibernateproject.model.Category;
import com.ela.hibernateproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/categoryList")
    public ModelAndView listCategory(ModelAndView model) {
        List<Category> listCategory = categoryService.findAll();
        model.setViewName("category/CategoryList");
        model.addObject("listCategory", listCategory);
        return model;
    }

    @RequestMapping(value = "/newCategory", method = RequestMethod.GET)
    public ModelAndView addCategory(ModelAndView model) {
        Category category = new Category();
        model.addObject("category", category);
        model.setViewName("category/CategoryForm");
        return model;
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return new ModelAndView("redirect:/categoryList");
    }

    @RequestMapping(value = "/deleteCategory", method = {RequestMethod.GET})
    public ModelAndView deleteCategory(HttpServletRequest request) {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        categoryService.delete(categoryId);
        return new ModelAndView("redirect:/categoryList");
    }

    @RequestMapping(value = "/editCategory", method = {RequestMethod.GET})
    public ModelAndView editCategory(HttpServletRequest request) throws ItemNotFoundException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(categoryId);
        categoryService.update(category);
        ModelAndView model = new ModelAndView("category/CategoryForm");
        model.addObject("category", category);
        return model;
    }
}

