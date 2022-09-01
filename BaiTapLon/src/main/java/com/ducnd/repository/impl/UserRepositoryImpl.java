/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.User;
import com.ducnd.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<User> getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        if (!username.isEmpty()) {
            Predicate p = b.equal(root.get("username").as(String.class), username.trim());
            q.where(p);
        }

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public int getUserIdLast() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("from User as u order by u.id desc");

        List<User> users = q.getResultList();
        User user = users.get(0);

        return user.getId();
    }

    @Override
    public User getUserByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

            Query q = session.createQuery("from User as u where u.username=:un ");
            q.setParameter("un", username);
            
            return (User) q.getSingleResult();

    }

    @Override
    public List<User> getAllUsers() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from User as u where u.id=:id");
        
        query.setParameter("id", id);
        
        return (User) query.getResultList().get(0);
    }

    @Override
    public boolean upDateActiveUser(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("UPDATE User set role='ROLE_BLOCK', active=0 where id=:id");
        query.setParameter("id", id);
        if(query.executeUpdate() > 0)
            return true;
        
        return false;
    }

    @Override
    public boolean unlockUser(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("UPDATE User set role='ROLE_USER', active=1 where id=:id");
        query.setParameter("id", id);
        if(query.executeUpdate() > 0)
            return true;
        
        return false;
    }

}
