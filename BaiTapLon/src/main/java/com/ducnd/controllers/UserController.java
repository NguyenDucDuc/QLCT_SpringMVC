/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ducnd.pojo.User;
import com.ducnd.service.UserService;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DucND
 */
@Controller
@ControllerAdvice
public class UserController {

    @Autowired
    private UserService userDetailsService;
    @Autowired
    private Cloudinary cloudinary;

    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session) {
//        Authentication authentication
//                = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("currentUser", this.userDetailsService.getUserByUsername(authentication.getName()));

           model.addAttribute("currentUser", session.getAttribute("currentUser"));
        

    }
    

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult result) throws IOException {
//        String err = "";
//        Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//        user.setAvatar((String) r.get("secure_url"));
//        if (!user.getPassword().isEmpty() || user.getPassword().equals(user.getConfirm())) {
//            if (this.userDetailsService.addUser(user) == true) {
//                return "redirect:/login";
//            } else {
//                err = "Dang ky that bai!";
//            }
//        } else {
//            err = "Mat khau khong khop";
//        }
//
//        model.addAttribute("err", err);
//        return "register";
          String err="";
          if(!result.hasErrors()){
              if(user.getFile()!=null && !user.getFile().isEmpty()){
                Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar((String) r.get("secure_url"));
              }
              if (!user.getPassword().isEmpty() || user.getPassword().equals(user.getConfirm())) {
                  user.setActive(1);
                  if (this.userDetailsService.addUser(user) == true) {
                      return "redirect:/login";
                  } else {
                      return "register";
                  }
              } else {
                  err = "Mat khau khong khop";
                  model.addAttribute("err", err);
              }
          }
          
          return "register";
    }
}
