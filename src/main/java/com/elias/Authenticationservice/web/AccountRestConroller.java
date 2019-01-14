/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elias.Authenticationservice.web;

import com.elias.Authenticationservice.model.AppUser;
import com.elias.Authenticationservice.model.Task;
import com.elias.Authenticationservice.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        return accountService.saveUser(
                userForm.getUsername(), userForm.getPassword(), userForm.getRepassword());
    }
}
