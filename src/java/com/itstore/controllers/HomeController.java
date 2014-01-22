package com.itstore.controllers;

import com.itstore.services.CategoryService;
import com.itstore.services.ItemService;
import com.itstore.services.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Goce
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/underconstruction", method = RequestMethod.GET)
    public String underConstruction() {
        return "underconstruction";
    }

    @RequestMapping(value = "/underconstruction", method = RequestMethod.POST)
    public String doUnderConstruction() {
        return "underconstruction";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String listAllUsers(HttpServletRequest request, ModelMap model,
            UserService userService, CategoryService categoryService,
            ItemService itemService, @RequestParam(value = "from", required = false) String from) {
        /*List<User> allUsers = userService.getAllUsers();
         List<Category> allCategories=categoryService.getAllCategories();
         List<Item> allItems=itemService.getAllItems();
         model.addAttribute("allUsers", allUsers);*/
        if (request.getParameterNames().hasMoreElements()) {
            Integer categoryId = 0;
            try {
                categoryId = Integer.parseInt(request.getParameter("categoryId"));
            } catch (Exception ex) {
                categoryId = 0;
            }

            Integer fromItem = 9;

            if (from == null || from.isEmpty()) {
                fromItem = 9;
            } else {
                try {
                    fromItem = Integer.parseInt(from);
                } catch (Exception ex) {
                    fromItem = 9;
                }
                if (fromItem < 9) {
                    fromItem = 9;
                }
            }
            model.addAttribute("from", from);
            model.addAttribute("recommendedItems", itemService.getRecommendedItems());
            model.addAttribute("specialItem", itemService.getSpecialItem());
            model.addAttribute("newestItem", itemService.getNewestItem());
            model.addAttribute("allItems", itemService.getAllItemsForCategory(categoryId));
            model.addAttribute("allCategories", categoryService.getAllCategories());
            return "home";
        } else {

            model.addAttribute("from", 9);
            model.addAttribute("recommendedItems", itemService.getRecommendedItems());
            model.addAttribute("specialItem", itemService.getSpecialItem());
            model.addAttribute("newestItem", itemService.getNewestItem());
            model.addAttribute("allItems", itemService.getAllItems());
            model.addAttribute("allCategories", categoryService.getAllCategories());
            return "home";
        }
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(ModelMap model, CategoryService categoryService, ItemService itemService) {
        /*List<User> allUsers = userService.getAllUsers();
         List<Item> allItems=itemService.getAllItems();
         List<Category> allCategories=categoryService.getAllCategories();
         model.addAttribute("allItems",allItems);
         model.addAttribute("allUsers", allUsers);
         List<Category> allCategories=categoryService.getAllCategories();*/
        model.addAttribute("newestItem", itemService.getNewestItem());
        model.addAttribute("specialItem", itemService.getSpecialItem());
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String doContact() {
        /*List<User> allUsers = userService.getAllUsers();
         List<Category> allCategories=categoryService.getAllCategories();
         List<Item> allItems=itemService.getAllItems();
         model.addAttribute("allItems",allItems);
         model.addAttribute("allUsers", allUsers);
         model.addAttribute("allCategories",allCategories);*/
        return "contact";
    }
}