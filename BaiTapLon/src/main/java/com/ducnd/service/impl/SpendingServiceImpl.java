/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.service.impl;

import com.ducnd.pojo.Spending;
import com.ducnd.pojo.User;
import com.ducnd.repository.SpendingRepository;
import com.ducnd.repository.UserRepository;
import com.ducnd.service.SpendingService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DucND
 */

@Service
public class SpendingServiceImpl implements SpendingService{
    
    @Autowired
    private SpendingRepository spendingRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addSpending(Spending spending) {
        Authentication authentication
                = SecurityContextHolder.getContext().getAuthentication();
        
        spending.setUserId(this.userRepository.getUserByUsername(authentication.getName()));
//        spending.setId(this.spendingRepository.getPendingIdLast()+1);
        
        return this.spendingRepository.addSpending(spending);
    }

    @Override
    public List<Spending> loadSpendings(int userId, Map<String, String> params, int page, int pageSize) {
        return this.spendingRepository.loadSpendings(userId, params, page, pageSize);
    }

    @Override
    public int countIncome(User user) {
        return this.spendingRepository.countIncome(user);
    }

    @Override
    public boolean deleteSpending(int id) {
        return this.spendingRepository.deleteSpending(id);
    }
    
}
