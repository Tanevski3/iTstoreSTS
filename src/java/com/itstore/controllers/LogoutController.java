package com.itstore.controllers;

import com.itstore.services.LoginService;
import com.itstore.services.SessionService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tanevski
 */

 @Controller
public class LogoutController {
   

    @RequestMapping( value = "/logout")
    public String doLogout(SessionService sessionService, HttpServletRequest request, 
                           LoginService loginService) {
        sessionService.init(request);
        loginService.setService(sessionService);
        if (loginService.isLoggedIn()) {

            sessionService.closeSession();
            return "redirect:home";
        }
        return "redirect:home";
    }
}