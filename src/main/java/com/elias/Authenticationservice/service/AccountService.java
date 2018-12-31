/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elias.Authenticationservice.service;

import com.elias.Authenticationservice.model.AppRole;
import com.elias.Authenticationservice.model.AppUser;

/**
 *
 * @author abbasturki.elias
 */
public interface AccountService {
    
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(String username,String roleName);
    public AppUser findUserByUsername(String username);
    
}
