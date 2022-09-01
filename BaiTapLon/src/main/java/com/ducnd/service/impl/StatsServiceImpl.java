/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.service.impl;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.Income;
import com.ducnd.pojo.MoneyPaid;
import com.ducnd.pojo.MustReturn;
import com.ducnd.pojo.User;
import com.ducnd.repository.StatsRepository;
import com.ducnd.service.StatsService;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DucND
 */

@Service
public class StatsServiceImpl implements StatsService {
    
    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> incomeStatsForDay(int userId, Date fromDate, Date toDate) {
        return this.statsRepository.incomeStatsForDay(userId, fromDate, toDate);
    }

    @Override
    public List<Object[]> spendingStatsForDay(int userId, Date fromDate, Date toDate) {
        return this.statsRepository.spendingStatsForDay(userId, fromDate, toDate);
    }

    @Override
    public BigDecimal totalIncomeMonth(int month, User user) {
        return this.statsRepository.totalIncomeMonth(month, user);
    }

    @Override
    public BigDecimal totalSpendingMonth(int month, User user) {
        return this.statsRepository.totalSpendingMonth(month, user);
    }

    @Override
    public int countUserIncomeGroup(Gr groupId) {
        return this.statsRepository.countUserIncomeGroup(groupId);
    }

    @Override
    public BigDecimal totalMoneyGroup(Gr groupId) {
        return this.statsRepository.totalMoneyGroup(groupId);
    }

    @Override
    public int countMember(Gr groupId) {
        return this.statsRepository.coutMember(groupId);
    }

    @Override
    public BigDecimal totalMoneyUserIncomeGroup(User userId, Gr groupId) {
        return this.statsRepository.totalMoneyUserIncomeGroup(userId, groupId);
    }

    @Override
    public List<MustReturn> moneyUserPay(Gr groupId) {
        return this.statsRepository.moneyUserPay(groupId);
    }

    @Override
    public List<MoneyPaid> moneyUserPaid(Gr groupId) {
        return this.statsRepository.moneyUserPaid(groupId);
    }
    
}
