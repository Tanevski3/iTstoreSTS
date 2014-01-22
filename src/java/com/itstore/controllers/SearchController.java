package com.itstore.controllers;

import com.itstore.services.CategoryService;
import com.itstore.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tanevski
 */
@Controller
public class SearchController {

    @RequestMapping(value = "/advancedSearchQuery")
    public String doAdvancedSearchQuery(ModelMap model, ItemService itemService, CategoryService categoryService,
            @RequestParam(value = "categoryName", required = false) String categoryName,
            @RequestParam(value = "part", required = false) String part,
            @RequestParam(value = "stock", required = false) String stock,
            @RequestParam(value = "orderBy", required = false) String orderBy,
            @RequestParam(value = "ascDesc", required = false) String ascDesc) {

        model.addAttribute("recommendedItems", itemService.getRecommendedItems());
        model.addAttribute("allItems", itemService.getAllQueriedItems(categoryName, stock, part, orderBy.toLowerCase(), ascDesc.toLowerCase()));
        model.addAttribute("newestItem", itemService.getNewestItem());
        model.addAttribute("specialItem", itemService.getSpecialItem());
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "home";
    }

    @RequestMapping(value = "/search")
    public String doSearch(ModelMap model, ItemService itemService, CategoryService categoryService,
            @RequestParam(value = "search", required = false) String search) {
        
        model.addAttribute("recommendedItems", itemService.getRecommendedItems());
        model.addAttribute("allItems", itemService.getAllItemsOrderedBySearchTitle("desc", search));
        model.addAttribute("newestItem", itemService.getNewestItem());
        model.addAttribute("specialItem", itemService.getSpecialItem());
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "home";
    }
}
