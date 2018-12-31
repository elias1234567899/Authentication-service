/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elias.Authenticationservice.web;

import lombok.Data;

/**
 *
 * @author abbasturki.elias
 */
@Data
public class RegisterForm {
    
    private String username;
    private String password;
    private String repassword;

}
