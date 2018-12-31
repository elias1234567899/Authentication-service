/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elias.Authenticationservice.web;

import com.elias.Authenticationservice.model.AppUser;
import com.elias.Authenticationservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbasturki.elias
 */
@RestController
public class AccountRestConroller {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm userForm) {
        if (!userForm.getPassword().equals(userForm.getRepassword())) {
            throw new RuntimeException("You must confirm you password");
        }
        AppUser user = accountService.findUserByUsername(userForm.getUsername());
        if (user != null) {
            throw new RuntimeException("This Username is already exists");
        }
        AppUser appUser = new AppUser();
        appUser.setUsername(userForm.getUsername());
        appUser.setPassword(userForm.getPassword());
        accountService.saveUser(appUser);
        accountService.addRoleToUser(userForm.getUsername(), "USER");
        return appUser;
    }
}
