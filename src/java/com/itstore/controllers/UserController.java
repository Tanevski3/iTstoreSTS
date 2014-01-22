package com.itstore.controllers;

import com.itstore.models.Item;
import com.itstore.models.User;
import com.itstore.services.ItemService;
import com.itstore.services.LoginService;
import com.itstore.services.SessionService;
import com.itstore.services.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tanevski
 */
@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(UserService userService, ModelMap model, LoginService loginService,
            SessionService sessionService, ItemService itemService, HttpServletRequest request) {
        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            List<User> allUsers = userService.getAllUsers();
            model.addAttribute("allUsers", allUsers);
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            return "user";
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.GET)
    public String showUpdateUserForm(HttpServletRequest request, ModelMap model,
            UserService userService, LoginService loginService,
            SessionService sessionService, ItemService itemService) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            if (request.getParameterNames().hasMoreElements()) {

                User user = new User();
                String theid = request.getParameter("userId");
                user.setId(Integer.parseInt(theid));
                model.addAttribute("updateUserForm", user);
                User currentUser = userService.getUserById(Integer.parseInt(theid));
                model.addAttribute("currentId", currentUser.getId());
                model.addAttribute("currentFirstName", currentUser.getFirstName());
                model.addAttribute("currentLastName", currentUser.getLastName());
                model.addAttribute("currentUsername", currentUser.getUsername());
                model.addAttribute("currentPassword", currentUser.getPassword());
                if (currentUser.getIsActive()) {
                    model.addAttribute("currentIsActive", "checked");
                } else {
                    model.addAttribute("currentIsActive", "");
                }
                model.addAttribute("currentEmail", currentUser.getEmail());
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "updateuser";
            } else {
                User user = new User();
                model.addAttribute("updateUserForm", user);
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "updateuser";
            }
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String updateuser(@ModelAttribute(value = "updateUserForm") User user,
            UserService userService, SessionService sessionService, LoginService loginService,
            @RequestParam(value = "firstName", required = false) String first_name,
            @RequestParam(value = "lastName", required = false) String last_name,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "isActive", required = false) String is_active,
            @RequestParam(value = "email", required = false) String email,
            ModelMap model, HttpServletRequest request) {
        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {


            user.setFirstName(first_name);
            user.setLastName(last_name);
            user.setUsername(username);
            user.setPassword(userService.getMD5(password));
            user.setEmail(email);
            user.setIsActive(Boolean.parseBoolean(is_active));

            if (!userService.updateUser(user)) {
                model.addAttribute("validationLabel", "User update failed!");

                List<User> allUsers = userService.getAllUsers();
                model.addAttribute("allUsers", allUsers);
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "user";
            }

            model.addAttribute("allUsers", userService.getAllUsers());
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            return "user";
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(value = "/createuser", method = RequestMethod.GET)
    public String showCreateUserForm(HttpServletRequest request, ModelMap model,
            SessionService sessionService, LoginService loginService, ItemService itemService) {

        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");

            User user = new User();
            model.addAttribute("createUserForm", user);
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            return "createuser";
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createuser")
    public String processCreateDonationForm(@ModelAttribute("createUserForm") User user,
            @RequestParam(value = "firstName", required = false) String first_name,
            @RequestParam(value = "lastName", required = false) String last_name,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "isActive", required = false) Boolean is_active,
            @RequestParam(value = "email", required = false) String email,
            ModelMap model, LoginService loginService, SessionService sessionService,
            HttpServletRequest request,
            UserService userService) {
        
        User loggedUser = null;
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {
            loggedUser = (User) sessionService.getAttribute("user");
            user.setFirstName(first_name);
            user.setLastName(last_name);
            user.setUsername(username);
            user.setPassword(userService.getMD5(password));
            user.setIsActive(is_active);
            user.setEmail(email);

            if (!userService.addUser(user)) {
                model.addAttribute("validationLabel", "User creation failed!");
                model.addAttribute("allUsers", userService.getAllUsers());
                model.addAttribute("loggedUserName", loggedUser.getFirstName());
                return "user";
            }
            model.addAttribute("allUsers", userService.getAllUsers());
            model.addAttribute("loggedUserName", loggedUser.getFirstName());
            return "user";
        } else {
            model.addAttribute("validationLabel", "Access restricted.");
            return "login";
        }
    }
}
