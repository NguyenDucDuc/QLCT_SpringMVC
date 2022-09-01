/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.repository;

import com.ducnd.pojo.User;
import com.ducnd.pojo.Warning;
import java.util.List;

/**
 *
 * @author DucND
 */
public interface WarningRepository {
    boolean addWarning(Warning warning);
    List<Warning> getWarnings(User user);
    boolean deleteWarning(String content, User user);
}
