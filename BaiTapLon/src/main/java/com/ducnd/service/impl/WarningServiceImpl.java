/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.service.impl;

import com.ducnd.pojo.User;
import com.ducnd.pojo.Warning;
import com.ducnd.repository.WarningRepository;
import com.ducnd.service.WarningService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DucND
 */

@Service
public class WarningServiceImpl implements WarningService {

    @Autowired
    private WarningRepository warningRepository;
    @Override
    public boolean addWarning(Warning warning) {
        return this.warningRepository.addWarning(warning);
    }

    @Override
    public List<Warning> getWarnings(User user) {
        return this.warningRepository.getWarnings(user);
    }

    @Override
    public boolean deleteWarning(String content, User user) {
        return this.warningRepository.deleteWarning(content, user);
    }
    
}
