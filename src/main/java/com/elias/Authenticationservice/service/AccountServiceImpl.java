/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elias.Authenticationservice.service;

import com.elias.Authenticationservice.dao.RoleRepository;
import com.elias.Authenticationservice.dao.UserRepository;
import com.elias.Authenticationservice.model.AppRole;
import com.elias.Authenticationservice.model.AppUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abbasturki.elias
 */

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public AppUser saveUser(String username,String password,String confirmedPassword) {
        AppUser user=userRepository.findByUsername(username);
        if(user != null) throw  new RuntimeException("Nom d'utilisateur existe déjà");
        if(!password.equals(confirmedPassword))throw  new RuntimeException("Veuillez confirmer votre mot de passe");
        AppUser appUser= new AppUser();
        appUser.setUsername(username);
        String hashPW = bCryptPasswordEncoder.encode(password);
        appUser.setPassword(hashPW);
        appUser.setActived(false);
        userRepository.save(appUser);
        addRoleToUser(username, "USER");
       return appUser;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName);
        AppUser user = userRepository.findByUsername(username);
        user.getRoles().add(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
}
