/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.repository;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.Income;
import com.ducnd.pojo.MoneyPaid;
import com.ducnd.pojo.MustReturn;
import com.ducnd.pojo.User;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DucND
 */
public interface StatsRepository {
    List<Object[]> incomeStatsForDay(int userId, Date fromDate, Date toDate);
    List<Object[]> spendingStatsForDay(int userId, Date fromDate, Date toDate);
    BigDecimal totalIncomeMonth(int month, User user);
    BigDecimal totalSpendingMonth(int month, User user);
    int countUserIncomeGroup(Gr groupId);
    BigDecimal totalMoneyGroup(Gr groupId);
    int coutMember(Gr groupId);
    BigDecimal totalMoneyUserIncomeGroup(User userId, Gr groupId);
    List<MustReturn> moneyUserPay(Gr groupId);
    List<MoneyPaid> moneyUserPaid(Gr groupId);
    
}
