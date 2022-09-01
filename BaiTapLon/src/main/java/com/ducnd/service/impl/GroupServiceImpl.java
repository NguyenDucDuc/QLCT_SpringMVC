/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.service.impl;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import com.ducnd.repository.GroupRepository;
import com.ducnd.service.GroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DucND
 */

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public boolean addGroup(Gr group) {
        return this.groupRepository.addGroup(group);
    }

    @Override
    public List<Gr> getGroups() {
        return this.groupRepository.getGroups();
    }

    @Override
    public List<Gr> getGroupByUserId(User user) {
        return this.groupRepository.getGroupByUserId(user);
    }

    @Override
    public Gr getGroupById(int groupId) {
        return this.groupRepository.getGroupById(groupId);
    }
    
}
