/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.User;
import com.ducnd.repository.GroupRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class GroupRepositoryImpl implements GroupRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addGroup(Gr group) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try{
            
            session.save(group);
            
            return true;
        }catch(Exception ex){
            ex.getMessage();
            session.clear();
            session.save(group);
            session.flush();
        }
        return false;
    }

    @Override
    public List<Gr> getGroups() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

//        List<Predicate> predicates = new ArrayList<>();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Gr> q = b.createQuery(Gr.class);
        Root root = q.from(Gr.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Gr> getGroupByUserId(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from Gr as g where g.userId=:user");
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    public Gr getGroupById(int groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from Gr as g where g.id=:groupId");
        query.setParameter("groupId",groupId );
        
        return (Gr) query.getResultList().get(0);
    }
    
}
