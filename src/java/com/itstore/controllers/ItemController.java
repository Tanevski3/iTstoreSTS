package com.itstore.controllers;

import com.itstore.models.Category;
import com.itstore.models.Item;
import com.itstore.models.User;
import com.itstore.services.CategoryService;
import com.itstore.services.ItemService;
import com.itstore.services.LoginService;
import com.itstore.services.SessionService;
import com.itstore.services.UserService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @author Tanevski
 */
@Controller
public class ItemController {

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String getItem(ItemService itemService, ModelMap model, HttpServletRequest request, SessionService sessionService, LoginService loginService) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        String theid = request.getParameter("itemId");

        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");
            sessionService.setAttribute("user", loggedUser);
            if (request.getParameterNames().hasMoreElements()) {
                if (theid != null) {
                    if (!itemService.deleteItemById(Integer.parseInt(theid))) {
                        model.addAttribute("validationLabel", "User deletion failed!");
                        List<Item> allItems = itemService.getAllItems();
                        model.addAttribute("allItems", allItems);
                        model.addAttribute("loggedUserName", loggedUser.getFirstName());
                        return "item";
                    }
                }
                List<Item> allItems = itemService.getAllItems();
                model.addAttribute("allItems", allItems);
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "item";
            } else {
                List<Item> allItems = itemService.getAllItems();
                model.addAttribute("allItems", allItems);
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "item";
            }
        } else {
            List<Item> allItems = itemService.getAllItems();
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createitem")
    public String createItemForm(HttpServletRequest request, ModelMap model, CategoryService categoryService,
            SessionService sessionService, LoginService loginService, ItemService itemService) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            sessionService.setAttribute("user", loggedUser);
            List<Category> categories = categoryService.getAllCategories();
            Item item = new Item();
            model.addAttribute("allCategories", categories);
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            model.addAttribute("createItem", item);
            return "createitem";
        } else {
            List<Item> allItems = itemService.getAllItems();
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createitem")
    public String processCreateItemForm(@ModelAttribute("createItem") Item item,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "specification", required = false) String specification,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "imageSource", required = false) String imageSource,
            @RequestParam(value = "price", required = false) Integer price,
            @RequestParam(value = "stock", required = false) Integer stock,
            @RequestParam(value = "user.id", required = false) String userId,
            @RequestParam(value = "category.id", required = false) String categoryId,
            ModelMap model,
            HttpServletRequest request,
            ItemService itemService,
            UserService userService,
            SessionService sessionService,
            LoginService loginService) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        loggedUser = (User) sessionService.getAttribute("user");
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            item.setTitle(title);
            item.setDescription(description);
            item.setSpecification(specification);
            item.setImageSource(imageSource);
            item.setPrice(price);
            item.setStock(stock);
            item.setPostDate(new Date());
            Category currentCategory = item.getCategory();
            currentCategory.setId(Integer.parseInt(categoryId));
            User currentUser = item.getUser();
            currentUser.setId(loggedUser.getId());
            item.setUser(loggedUser);
            if (!itemService.addItem(item)) {
                model.addAttribute("validationLabel", "Item creation failed!");
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                model.addAttribute("allItems", itemService.getAllItems());
                return "item";
            }
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            model.addAttribute("allItems", itemService.getAllItems());
            return "item";
        } else {
            List<Item> allItems = itemService.getAllItems();
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(value = "/updateitem", method = RequestMethod.GET)
    public String showUpdateItemForm(HttpServletRequest request, ModelMap model,
            ItemService itemService, CategoryService categoryService,
            SessionService sessionService, LoginService loginService) {


        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            if (request.getParameterNames().hasMoreElements()) {
                Item item = new Item();
                String theid = request.getParameter("itemId");
                item.setId(Integer.parseInt(theid));
                Item currentItem = itemService.findItembyId(Integer.parseInt(theid));
                List<Category> categories = categoryService.getAllCategories();
                model.addAttribute("updateItemForm", item);
                model.addAttribute("allCategories", categories);
                model.addAttribute("currentTitle", currentItem.getTitle());
                model.addAttribute("currentSpecification", currentItem.getSpecification());
                model.addAttribute("currentDescription", currentItem.getDescription());
                model.addAttribute("currentImageSource", currentItem.getImageSource());
                model.addAttribute("currentPrice", currentItem.getPrice());
                model.addAttribute("currentStock", currentItem.getStock());
                model.addAttribute("currentUserId", currentItem.getUser().getId());
                model.addAttribute("currentCategoryId", currentItem.getCategory().getId());
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "updateitem";
            } else {
                Item item = new Item();
                List<Category> categories = categoryService.getAllCategories();
                model.addAttribute("allCategories", categories);
                model.addAttribute("updateItemForm", item);
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "updateitem";
            }
        } else {
            List<Item> allItems = itemService.getAllItems();
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(value = "/updateitem", method = RequestMethod.POST)
    public String processUpdateItemForm(HttpServletRequest request,
            @ModelAttribute(value = "updateItemForm") Item item, ItemService itemService,
            ModelMap model, SessionService sessionService, LoginService loginService,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "specification", required = false) String specification,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "imageSource", required = false) String imageSource,
            @RequestParam(value = "price", required = false) Integer price,
            @RequestParam(value = "stock", required = false) Integer stock,
            @RequestParam(value = "user.id", required = false) String userId,
            @RequestParam(value = "category.id", required = false) String categoryId) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            item.setTitle(title);
            item.setDescription(description);
            item.setSpecification(specification);
            item.setImageSource(imageSource);
            item.setPrice(price);
            item.setStock(stock);
            item.setPostDate(new Date());
            User currentUser = item.getUser();
            currentUser.setId(Integer.parseInt(userId));
            Category currentCategory = item.getCategory();
            currentCategory.setId(Integer.parseInt(categoryId));

            if (!itemService.updateItem(item)) {
                model.addAttribute("validationLabel", "User update failed!");
                model.addAttribute("allItems", itemService.getAllItems());
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "item";
            }

            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            model.addAttribute("allItems", itemService.getAllItems());
            return "item";
        } else {
            List<Item> allItems = itemService.getAllItems();
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }
}
