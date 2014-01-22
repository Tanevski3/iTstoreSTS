/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itstore.services;

/**
 *
 * @author user
 */
public class LoginService {

    SessionService service;

    public LoginService() {
       
    }

    
    public boolean isLoggedIn() {
        if (service.getAttribute("user") != null) {
            return true;
        }
        return false;
    }

    public SessionService getService() {
        return service;
    }

    public void setService(SessionService service) {
        this.service = service;
    }
}
