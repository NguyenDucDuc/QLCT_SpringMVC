/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.repository;

import com.ducnd.pojo.IncomeGroupTemp;
import com.ducnd.pojo.UserIncomeGroup;

/**
 *
 * @author DucND
 */
public interface IncomeGroupRepository {
    boolean addIncomeGroup(UserIncomeGroup incomeGroup);
    boolean addIncomeGroupFromTemp(int userId, int groupId, java.sql.Date time, double money, String purpose);
}
