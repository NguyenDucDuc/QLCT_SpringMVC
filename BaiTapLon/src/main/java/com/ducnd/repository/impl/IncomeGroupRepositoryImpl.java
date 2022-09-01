/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.IncomeGroupTemp;
import com.ducnd.pojo.UserIncomeGroup;
import com.ducnd.repository.GroupRepository;
import com.ducnd.repository.IncomeGroupRepository;
import com.ducnd.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DucND
 */

@Repository
@Transactional
public class IncomeGroupRepositoryImpl implements IncomeGroupRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;


    @Override
    public boolean addIncomeGroup(UserIncomeGroup incomeGroup) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(incomeGroup);
            return true;
        }catch(Exception ex){
            ex.getMessage();
            session.clear();
        }
        
        return false;
    }

    @Override
    public boolean addIncomeGroupFromTemp(int userId, int groupId, java.sql.Date time, double money, String purpose) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            UserIncomeGroup incomeGroup = new UserIncomeGroup();
            incomeGroup.setUserId(this.userRepository.getUserById(userId));
            incomeGroup.setGroupId(this.groupRepository.getGroupById(groupId));
            incomeGroup.setTime(time);
            incomeGroup.setPurpose(purpose);
            incomeGroup.setMoney(money);
            
            session.save(incomeGroup);
            return true;
        }catch(Exception ex){
            ex.getMessage();
            session.clear();
        }
        
        return false;
    }
    
}
