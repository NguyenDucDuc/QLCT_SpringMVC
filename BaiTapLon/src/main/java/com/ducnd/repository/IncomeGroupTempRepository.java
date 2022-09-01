/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ducnd.repository;

import com.ducnd.pojo.Income;
import com.ducnd.pojo.IncomeGroupTemp;
import java.util.List;

/**
 *
 * @author DucND
 */
public interface IncomeGroupTempRepository {
    boolean addIncomeGroupTemp(IncomeGroupTemp incomeGroupTemp);
    List<IncomeGroupTemp> getIncomeGroupTemps(int groupId);
    boolean deleteIncomGroupTemp(int id);
}
