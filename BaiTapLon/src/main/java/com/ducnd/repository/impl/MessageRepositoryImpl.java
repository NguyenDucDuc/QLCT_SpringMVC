/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.Message;
import com.ducnd.repository.MessageRepository;
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
public class MessageRepositoryImpl implements MessageRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addMessage(Message message) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        try {

            s.save(message);
            return true;
        } catch (Exception ex) {
            ex.getMessage();
            s.clear();
        }
        return false;
    }

    @Override
    public List<Message> loadMessage(Gr groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from Message as m where m.groupId=:groupId");
        query.setParameter("groupId", groupId);
        return query.getResultList();
    }
    
}
