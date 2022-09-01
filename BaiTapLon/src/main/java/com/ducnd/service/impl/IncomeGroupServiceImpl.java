/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.service.impl;

import com.ducnd.pojo.IncomeGroupTemp;
import com.ducnd.pojo.UserIncomeGroup;
import com.ducnd.repository.GroupRepository;
import com.ducnd.repository.IncomeGroupRepository;
import com.ducnd.repository.UserRepository;
import com.ducnd.service.IncomeGroupService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DucND
 */
@Service
public class IncomeGroupServiceImpl implements IncomeGroupService{
    @Autowired
    private IncomeGroupRepository incomeGroupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public boolean addIncomeGroup(UserIncomeGroup incomeGroup) {
        
        return this.incomeGroupRepository.addIncomeGroup(incomeGroup);
    }


    @Override
    public boolean addIncomeGroupFromTemp(int userId, int groupId, Date time, double money, String purpose) {
        return this.incomeGroupRepository.addIncomeGroupFromTemp(userId, groupId, time, money, purpose);
    }
    
}
