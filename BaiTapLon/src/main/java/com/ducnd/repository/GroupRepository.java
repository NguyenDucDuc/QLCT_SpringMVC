/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.repository;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import java.util.List;

/**
 *
 * @author DucND
 */
public interface GroupRepository {
    boolean addGroup(Gr group);
    List<Gr> getGroups();
    List<Gr> getGroupByUserId(User user);
    Gr getGroupById(int groupId);
}
