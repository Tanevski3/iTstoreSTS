package com.itstore.controllers;

import com.itstore.models.Category;
import com.itstore.models.Item;
import com.itstore.models.User;
import com.itstore.services.CategoryService;
import com.itstore.services.ItemService;
import com.itstore.services.LoginService;
import com.itstore.services.SessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tanevski
 */
@Controller
public class CategoryController {

    @RequestMapping(method = RequestMethod.GET, value = "/category")
    public String category(HttpServletRequest request, HttpServletResponse response,
            CategoryService categoryService, ModelMap model, SessionService sessionService,
            LoginService loginService, ItemService itemService) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        String theid = request.getParameter("categoryId");

        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");
            sessionService.setAttribute("user", loggedUser);

            if (request.getParameterNames().hasMoreElements()) {
                if (!categoryService.deleteCategoryById(Integer.parseInt(theid))) {
                    model.addAttribute("validationLabel", "Category deletion failed!");
                    List<Category> allCategories = categoryService.getAllCategories();
                    model.addAttribute("allCategories", allCategories);
                    model.addAttribute("loggedUserName", loggedUser.getFirstName());
                    return "category";
                }
                List<Category> allCategories = categoryService.getAllCategories();
                model.addAttribute("allCategories", allCategories);
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "category";
            } else {
                List<Category> allCategories = categoryService.getAllCategories();
                model.addAttribute("allCategories", allCategories);
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "category";
            }
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createcategory")
    public String createCategoryForm(HttpServletRequest request, HttpServletResponse response,
            ModelMap model, CategoryService categoryService,
            SessionService sessionService,
            LoginService loginService, ItemService itemService) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            Category category = new Category();
            model.addAttribute("createCategory", category);
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            return "createcategory";
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createcategory")
    public String processForm(@ModelAttribute(value = "createCategory") Category category,
            CategoryService categoryService, ModelMap model,
            @RequestParam(value = "name", required = false) String name,
            SessionService sessionService, LoginService loginService, HttpServletRequest request) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            category.setName(name);
            if (!categoryService.addCategory(category)) {
                model.addAttribute("validationLabel", "Category creation failed!");
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                model.addAttribute("allCategories", categoryService.getAllCategories());
                return "category";
            }
            List<Category> allCategories = categoryService.getAllCategories();
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            model.addAttribute("allCategories", allCategories);
            return "category";
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(value = "/updatecategory", method = RequestMethod.GET)
    public String showUpdateCategoryForm(HttpServletRequest request, ModelMap model,
            CategoryService categoryService, LoginService loginService,
            SessionService sessionService, ItemService itemService) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            if (request.getParameterNames().hasMoreElements()) {
                Category category = new Category();
                String theid = request.getParameter("categoryId");
                category.setId(Integer.parseInt(theid));
                model.addAttribute("updateCategoryForm", category);
                Category currentCategory = categoryService.findCategoryById(Integer.parseInt(theid));
                model.addAttribute("currentName", currentCategory.getName());
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "updatecategory";
            } else {
                Category category = new Category();
                model.addAttribute("updateCategoryForm", category);
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "updatecategory";
            }
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(value = "/updatecategory", method = RequestMethod.POST)
    public String processUpdateCategoryForm(HttpServletRequest request,
            @ModelAttribute(value = "updateCategoryForm") Category category,
            BindingResult result, CategoryService categoryService, ModelMap model,
            SessionService sessionService, LoginService loginService,
            @RequestParam(value = "name", required = false) String name) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            category.setName(name);
            if (!categoryService.updateCategory(category)) {
                model.addAttribute("Category update failed!");
                model.addAttribute("allCategories", categoryService.getAllCategories());
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "category";
            }
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            model.addAttribute("allCategories", categoryService.getAllCategories());
            return "category";
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }
}
