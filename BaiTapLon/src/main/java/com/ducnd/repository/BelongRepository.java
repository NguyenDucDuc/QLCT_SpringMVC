/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.repository;

import com.ducnd.pojo.BelongTo;
import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import java.util.List;

/**
 *
 * @author DucND
 */
public interface BelongRepository {
    boolean addBelongTo(BelongTo belongTo);
    List<BelongTo> getBelongToByUserId(User user);
    List<BelongTo> getUserInGroup(Gr groupId);
    List<BelongTo> loadGroups(User userId);
}
