/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.repository;

import com.ducnd.pojo.Spending;
import com.ducnd.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DucND
 */
public interface SpendingRepository {
    boolean addSpending(Spending spending);
    int getPendingIdLast();
    List<Spending> loadSpendings(int userId, Map<String, String> params, int page, int pageSize);
    int countIncome(User user);
    boolean deleteSpending(int id);
}
