/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.BelongTo;
import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import com.ducnd.repository.BelongRepository;
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
public class BelongRepositoryImpl implements BelongRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addBelongTo(BelongTo belongTo) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            
            session.save(belongTo);
            
            return true;
        }catch(Exception ex){
            ex.getMessage();
            session.clear();
            session.flush();
        }
        return false;
        
    }

    @Override
    public List<BelongTo> getBelongToByUserId(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from BelongTo as b where b.userId=:user");
        query.setParameter("user", user);
        
        return query.getResultList();
    }

    @Override
    public List<BelongTo> getUserInGroup(Gr groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from BelongTo as b where b.groupId=:groupId");
        query.setParameter("groupId", groupId);
        
        return  query.getResultList();
    }

    @Override
    public List<BelongTo> loadGroups(User userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from BelongTo as b where b.userId=:userId");
        query.setParameter("userId", userId);
        
        return  query.getResultList();
    }
    
}
