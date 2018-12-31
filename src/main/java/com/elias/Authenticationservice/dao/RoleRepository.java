/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elias.Authenticationservice.dao;

import com.elias.Authenticationservice.model.AppRole;
import com.elias.Authenticationservice.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author abbasturki.elias
 */
public interface RoleRepository extends JpaRepository<AppRole,Integer>{
    public AppRole findByRoleName(String roleName);
}
