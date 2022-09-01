/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.repository;

import com.ducnd.pojo.Income;
import com.ducnd.pojo.User;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DucND
 */
public interface IncomeRepository {
    boolean addInCome(Income income);
    int getIncomeIdLast();
    List<Income> loadIncomes(int userId, Map<String, String> params, int page, int pageSize);
    int countIncome(User user);
    boolean deleteIncome(int id);
}
