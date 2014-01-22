/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itstore.controllers;

import com.itstore.models.Item;
import com.itstore.models.User;
import com.itstore.services.ItemService;
import com.itstore.services.LoginService;
import com.itstore.services.SessionService;
import com.itstore.services.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author user
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(ModelMap model) {

        return "login";
    }

    @RequestMapping(value = "/item")
    public String doLogin(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("username") String username, @RequestParam("password") String password,
            UserService userService, ModelMap model, ItemService itemService, SessionService sessionService, LoginService loginService) //  BindingResult result,
    {
        User loggedUser;
        loggedUser = userService.findUser(username, userService.getMD5(password));
        if (loggedUser == null) {

            model.addAttribute("validationLabel", "Logging failed. Try again!");
            return "login";

        } else {
            List<Item> allItems = itemService.getAllItems();
            model.addAttribute("allItems", allItems);
            sessionService.init(request);
            loginService.setService(sessionService);
            if (loginService.isLoggedIn()) {
                model.addAttribute("allItems", allItems);
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "item";
            }
            sessionService.setAttribute("user", loggedUser);
            model.addAttribute("allItems", allItems);
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            return "item";

        }
    }
}
