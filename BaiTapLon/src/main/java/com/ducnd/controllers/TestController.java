/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.controllers;

import com.ducnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author DucND
 */

@Controller
public class TestController {
    @Autowired
    private UserService userService; 
    
    
    
    @GetMapping("/admin")
    public String admin(){
        return "homeAdmin";
    }
    
    @GetMapping("/admin/user")
    public String userManager(Model model){
        model.addAttribute("users", this.userService.getAllUsers());
        return "userManager";
    }
    
    @GetMapping("/forbidden")
    public String forbidden(Model model){
        return "forbidden";
    }
}
