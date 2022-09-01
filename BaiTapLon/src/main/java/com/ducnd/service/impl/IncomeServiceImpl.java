/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.service.impl;

import com.ducnd.pojo.Income;
import com.ducnd.pojo.User;
import com.ducnd.repository.IncomeRepository;
import com.ducnd.repository.UserRepository;
import com.ducnd.service.IncomeService;
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
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addInCome(Income income) {
        Authentication authentication
                = SecurityContextHolder.getContext().getAuthentication();
//        if(this.incomeRepository.getIncomeIdLast() > 0 )
//            income.setId(this.incomeRepository.getIncomeIdLast()+1);
//        else 
//            income.setId(1);

        income.setUserId(this.userRepository.getUserByUsername(authentication.getName()));

//        income.setId(this.incomeRepository.getIncomeIdLast()+1);
        
        return this.incomeRepository.addInCome(income);
    }

    @Override
    public List<Income> loadIncomes(int userId, Map<String, String> params, int page, int pageSize) {
        return this.incomeRepository.loadIncomes(userId, params, page, pageSize);
    }

    @Override
    public int countIncome(User user) {
        return this.incomeRepository.countIncome(user);
    }

    @Override
    public boolean deleteIncome(int id) {
        return this.incomeRepository.deleteIncome(id);
    }

}
