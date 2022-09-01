/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.service.impl;

import com.ducnd.pojo.IncomeGroupTemp;
import com.ducnd.repository.IncomeGroupTempRepository;
import com.ducnd.service.IncomeGroupTempService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DucND
 */
@Service
public class IncomeGroupTempServiceImpl implements IncomeGroupTempService {
    @Autowired
    private IncomeGroupTempRepository incomeGroupTempRepository;

    @Override
    public boolean addIncomeGroupTemp(IncomeGroupTemp incomeGroupTemp) {
        return this.incomeGroupTempRepository.addIncomeGroupTemp(incomeGroupTemp);
    }

    @Override
    public List<IncomeGroupTemp> getIncomeGroupTemps(int groupId) {
        return this.incomeGroupTempRepository.getIncomeGroupTemps(groupId);
    }

    @Override
    public boolean deleteIncomeGroupTemp(int id) {
        return this.incomeGroupTempRepository.deleteIncomGroupTemp(id);
    }
    
}
