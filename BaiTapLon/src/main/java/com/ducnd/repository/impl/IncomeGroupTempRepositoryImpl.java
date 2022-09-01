/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.IncomeGroupTemp;
import com.ducnd.repository.IncomeGroupTempRepository;
import java.util.List;
import javax.persistence.Query;
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
public class IncomeGroupTempRepositoryImpl implements IncomeGroupTempRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addIncomeGroupTemp(IncomeGroupTemp incomeGroupTemp) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try{
            
            session.save(incomeGroupTemp);
            
            return true;
        }catch(Exception ex){
            ex.getMessage();
            session.clear();
        }
        return false;
    }

    @Override
    public List<IncomeGroupTemp> getIncomeGroupTemps(int groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from IncomeGroupTemp as i where i.groupId=:groupId");
        query.setParameter("groupId", groupId);
        
        return query.getResultList();
    }

    @Override
    public boolean deleteIncomGroupTemp(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("delete from IncomeGroupTemp where id=:id");
        query.setParameter("id", id);
        if(query.executeUpdate()!=0)
            return true;
        return false;
    }
    
}
