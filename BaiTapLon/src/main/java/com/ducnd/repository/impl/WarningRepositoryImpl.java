/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.User;
import com.ducnd.pojo.Warning;
import com.ducnd.repository.WarningRepository;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.TemporalType;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class WarningRepositoryImpl implements WarningRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addWarning(Warning warning) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        try {

            s.save(warning);
            return true;
        } catch (Exception ex) {
            ex.getMessage();
            s.clear();
        }
        return false;
    }

    @Override
    public List<Warning> getWarnings(User user) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query query = s.createQuery("from Warning as w where w.userId=:user");
        query.setParameter("user",user);
        return query.getResultList();
    }

    @Override
    public boolean deleteWarning(String content, User user) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query query = s.createQuery("delete from Warning where userId=:user AND content=:content");
        query.setParameter("user", user);
        query.setParameter("content", content);
        
        int row = query.executeUpdate();
        if(row != 0){
            return true;
        }
        
        return false;
    }
    
}
