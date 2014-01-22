/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itstore.controllers;

import com.itstore.models.About;
import com.itstore.models.User;
import com.itstore.services.AboutService;
import com.itstore.services.CategoryService;
import com.itstore.services.ItemService;
import com.itstore.services.LoginService;
import com.itstore.services.SessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tanevski
 */
@Controller
public class AboutController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(ModelMap model, CategoryService categoryService, AboutService aboutService, ItemService itemService) {
        /*List<User> allUsers = userService.getAllUsers();
         List<Category> allCategories=categoryService.getAllCategories();
         List<Item> allItems=itemService.getAllItems();
         model.addAttribute("allItems",allItems);
         model.addAttribute("allUsers", allUsers);
         model.addAttribute("allCategories",allCategories);*/
        model.addAttribute("allCategories", categoryService.getAllCategories());
        List<About> abouts = aboutService.getAbout();
        if (abouts != null || !abouts.isEmpty()) {
            model.addAttribute("abouts", abouts);
        }
        model.addAttribute("newestItem", itemService.getNewestItem());
        model.addAttribute("specialItem", itemService.getSpecialItem());
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "about";
    }

    @RequestMapping(value = "/about", method = RequestMethod.POST)
    public String doAbout() {
        /*List<User> allUsers = userService.getAllUsers();
         List<Category> allCategories=categoryService.getAllCategories();
         List<Item> allItems=itemService.getAllItems();
         model.addAttribute("allItems",allItems);
         model.addAttribute("allUsers", allUsers);
         model.addAttribute("allCategories",allCategories);*/
        return "about";
    }

    @RequestMapping(value = "/aboutmanagement", method = RequestMethod.GET)
    public String AboutusAdminPanel(HttpServletRequest request, ModelMap model, SessionService sessionService, LoginService loginService, AboutService aboutService) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");
            About about = aboutService.getAboutById(1);
            if (about != null) {
                model.addAttribute("currentAddress", about.getAddress());
                model.addAttribute("currentEmail", about.getEmail());
                model.addAttribute("currentPhone", about.getPhone());
                model.addAttribute("currentFax", about.getFax());
                model.addAttribute("currentDescription", about.getDescription());
            }
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            return "aboutmanagement";
        }
        return "login";
    }

    @RequestMapping(value = "/aboutmanagement", method = RequestMethod.POST)
    public String showUpdateAbout(HttpServletRequest request, ModelMap model,
            SessionService sessionService, LoginService loginService, AboutService aboutService,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "address", required = false) String city,
            @RequestParam(value = "fax", required = false) String fax,
            @RequestParam(value = "email", required = false) String email) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            sessionService.setAttribute("user", loggedUser);

            About about = aboutService.getAboutById(1);
            about.setDescription(description);
            about.setAddress(city);
            about.setPhone(phone);
            about.setFax(fax);
            about.setEmail(email);

            aboutService.updateAbout(about);

            return "aboutmanagement";
        } else {

            return "login";
        }
    }
}
