/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository;

import com.ducnd.pojo.User;
import java.util.List;

/**
 *
 * @author DucND
 */
public interface UserRepository {
    List<User> getUsers(String username);
    boolean addUser(User user);
    int getUserIdLast();
    User getUserByUsername(String username);
    List<User> getAllUsers();
    User getUserById(int id);
    boolean upDateActiveUser(int id);
    boolean unlockUser(int id);
    
}
