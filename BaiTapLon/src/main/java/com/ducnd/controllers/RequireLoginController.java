/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author DucND
 */
@Controller
public class RequireLoginController {
    @GetMapping("/require-login")
    public String requireLogin(){
        return "requireLogin";
    }
    
    @GetMapping("/user-block")
    public String userBlock(){
        return "userBlock";
    }
}
