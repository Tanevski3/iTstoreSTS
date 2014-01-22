package com.itstore.controllers;

import com.itstore.models.Item;
import com.itstore.services.CategoryService;
import com.itstore.services.ItemService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tanevski
 */
@Controller
public class DetailsController {

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(HttpServletRequest request, ModelMap model, CategoryService categoryService,
            ItemService itemService) {
        if (request.getParameterNames().hasMoreElements()) {
            Integer itemId = 0;
            try {
                itemId = Integer.parseInt(request.getParameter("itemId"));
            } catch (Exception ex) {
                itemId = 1;
            }
            if (itemId == 0) {
                itemId = 1;
            }
            Item detailItem = itemService.getItemById(itemId);
            if (detailItem != null) {
                model.addAttribute("itemTitle", detailItem.getTitle());
                model.addAttribute("itemSpecification", detailItem.getSpecification());
                model.addAttribute("itemDescription", detailItem.getDescription());
                model.addAttribute("itemImageSource", detailItem.getImageSource());
                model.addAttribute("itemPrice", detailItem.getPrice());
                model.addAttribute("itemCategory", detailItem.getCategory().getName());
                model.addAttribute("allCategories", categoryService.getAllCategories());
                List<Item> simularItems = itemService.getAllItemsForCategory(detailItem.getCategory().getId());
                if (simularItems.size() > 2) {
                    model.addAttribute("simularItems", simularItems);
                } else {
                    //TODO
                }
                model.addAttribute("recommendedItems", itemService.getRecommendedItems());
                model.addAttribute("newestItem", itemService.getNewestItem());
                model.addAttribute("specialItem", itemService.getSpecialItem());
                model.addAttribute("allCategories", categoryService.getAllCategories());
                return "details";
            } else {
                model.addAttribute("recommendedItems", itemService.getRecommendedItems());
                model.addAttribute("newestItem", itemService.getNewestItem());
                model.addAttribute("specialItem", itemService.getSpecialItem());
                model.addAttribute("allItems", itemService.getAllItems());
                model.addAttribute("allCategories", categoryService.getAllCategories());
                return "home";
            }
        } else {
            model.addAttribute("recommendedItems", itemService.getRecommendedItems());
            model.addAttribute("newestItem", itemService.getNewestItem());
            model.addAttribute("specialItem", itemService.getSpecialItem());
            model.addAttribute("allItems", itemService.getAllItems());
            model.addAttribute("allCategories", categoryService.getAllCategories());
            return "home";
        }
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public String doDetails(ModelMap model, CategoryService categoryService, ItemService itemService) {
        /*List<User> allUsers = userService.getAllUsers();
         List<Category> allCategories=categoryService.getAllCategories();,Item
         List<Item> allItems=itemService.getAllItems();
         model.addAttribute("allItems",allItems);
         model.addAttribute("allUsers", allUsers);*/
        model.addAttribute("allCategories", categoryService.getAllCategories());
        model.addAttribute("recommendedItems", itemService.getRecommendedItems());
        model.addAttribute("newestItem", itemService.getNewestItem());
        model.addAttribute("specialItem", itemService.getSpecialItem());
        return "details";
    }
}
