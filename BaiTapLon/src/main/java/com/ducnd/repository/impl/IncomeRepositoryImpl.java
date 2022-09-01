/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.Income;
import com.ducnd.pojo.User;
import com.ducnd.repository.IncomeRepository;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class IncomeRepositoryImpl implements IncomeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addInCome(Income income) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        try {

            s.save(income);
            return true;
        } catch (Exception ex) {
            ex.getMessage();
            s.clear();
        }
        return false;
    }

    @Override
    public int getIncomeIdLast() {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Query q = session.createQuery("from Income as i order by i.id desc");
//        
//        List<Income> incomes = q.getResultList();
//        Income income = incomes.get(0);
//        
//        return income.getId();

        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("from Income as i order by i.id desc");

        List<Income> incomes = q.getResultList();
        Income income = incomes.get(0);

        return income.getId();
    }

    @Override
    public List<Income> loadIncomes(int userId, Map<String, String> params, int page, int pageSize) {

        Session session = this.sessionFactory.getObject().getCurrentSession();

//        List<Predicate> predicates = new ArrayList<>();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Income> q = b.createQuery(Income.class);
        Root root = q.from(Income.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        if (params != null) {

            String incomeName = params.get("incomeName");

            if (incomeName != null && !incomeName.isEmpty()) {
                Predicate p = b.like(root.get("purpose").as(String.class), String.format("%%%s%%", incomeName));
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

            int size = 2;
            int start = (page - 1) * pageSize;
            query.setFirstResult(start);
            query.setMaxResults(pageSize);

        }

        return query.getResultList();
    }

    @Override
    public int countIncome(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("select count(*) from Income as i where i.userId=:user");
        query.setParameter("user", user);

        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public boolean deleteIncome(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        Query query = session.createQuery("delete from Income where id=:id");
        query.setParameter("id", id);
        if(query.executeUpdate()!=0)
            return true;
        return false;
    }

    
    

}
