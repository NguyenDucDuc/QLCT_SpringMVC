/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.service;

import com.ducnd.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author DucND
 */
public interface UserService extends UserDetailsService {

    List<User> getUsers(String username);

    boolean addUser(User user);
    
    User getUserByUsername(String username);
    
    List<User> getAllUsers();
    
    User getUserById(int id);
    
    boolean updateActiveUser(int id);
    
    boolean unlockUser(int id);
    
    
}
