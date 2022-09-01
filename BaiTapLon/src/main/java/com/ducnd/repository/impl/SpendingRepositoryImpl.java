/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.Income;
import com.ducnd.pojo.Spending;
import com.ducnd.pojo.User;
import com.ducnd.repository.SpendingRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class SpendingRepositoryImpl implements SpendingRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addSpending(Spending spending) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        try {

            s.save(spending);
            return true;
        } catch (Exception ex) {
            ex.getMessage();
        }
        return false;
    }

    @Override
    public int getPendingIdLast() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("from Spending as s order by s.id desc");

        List<Spending> spendings = q.getResultList();
        Spending spending = spendings.get(0);

        return spending.getId();
    }

    @Override
    public List<Spending> loadSpendings(int userId, Map<String, String> params, int page, int pageSize) {

        Session session = this.sessionFactory.getObject().getCurrentSession();

//        List<Predicate> predicates = new ArrayList<>();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Spending> q = b.createQuery(Spending.class);
        Root root = q.from(Spending.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        if (params != null) {

            String spendingName = params.get("spendingName");

            if (spendingName != null && !spendingName.isEmpty()) {
                Predicate p = b.like(root.get("purpose").as(String.class), String.format("%%%s%%", spendingName));
                predicates.add(p);

            }
        }

        Predicate p = b.equal(root.get("userId"), userId);
        predicates.add(p);

        q.where(predicates.toArray(Predicate[]::new));

        Query query = session.createQuery(q);
//        Query q = session.createQuery("from Income");

        if (page > 0) {
//            int size = 2;
//            int start = (page - 1) * size;
//            query.setFirstResult(start);
//            query.setMaxResults(size);

            
            int start = (page - 1) * pageSize;
            query.setFirstResult(start);
            query.setMaxResults(pageSize);

        }

        return query.getResultList();
    }

    @Override
    public int countIncome(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("select count(*) from Spending as s where s.userId=:user");
        query.setParameter("user", user);

        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public boolean deleteSpending(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("DELETE FROM Spending where id=:id");
        query.setParameter("id", id);
        if(query.executeUpdate() > 0)
            return true;
        return false;
    }

}
