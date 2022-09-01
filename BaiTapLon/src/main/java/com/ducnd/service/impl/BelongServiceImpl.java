/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.service.impl;

import com.ducnd.pojo.BelongTo;
import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import com.ducnd.repository.BelongRepository;
import com.ducnd.service.BelongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DucND
 */

@Service
public class BelongServiceImpl implements BelongService {
    
    @Autowired
    private BelongRepository belongRepository;

    @Override
    public boolean addBelongTo(BelongTo belongTo) {
        return this.belongRepository.addBelongTo(belongTo);
    }

    @Override
    public List<BelongTo> getBelongToByUserId(User user) {
        return this.belongRepository.getBelongToByUserId(user);
    }

    @Override
    public List<BelongTo> getUserInGroup(Gr groupId) {
        return this.belongRepository.getUserInGroup(groupId);
    }

    @Override
    public List<BelongTo> loadGroups(User userId) {
        return this.belongRepository.loadGroups(userId);
    }
    
    
}
