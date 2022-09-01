/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.repository.impl;

import com.ducnd.pojo.Gr;
import com.ducnd.pojo.Income;
import com.ducnd.pojo.MoneyPaid;
import com.ducnd.pojo.MustReturn;
import com.ducnd.pojo.Spending;
import com.ducnd.pojo.User;
import com.ducnd.repository.BelongRepository;
import com.ducnd.repository.GroupRepository;
import com.ducnd.repository.StatsRepository;
import com.ducnd.service.StatsService;
import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private BelongRepository belongRepository;
    @Autowired
    private StatsService statsService;

    @Override
    public List<Object[]> incomeStatsForDay(int userId, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootI = q.from(Income.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootI.get("userId"), userId));

        if (fromDate != null) {
            java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
            predicates.add(b.greaterThanOrEqualTo(rootI.get("time"), sqlFromDate));
        }

        if (toDate != null) {
            java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
            predicates.add(b.lessThanOrEqualTo(rootI.get("time"), sqlToDate));
        }

        q.multiselect(rootI.get("time"), b.sum(rootI.get("money")).as(BigDecimal.class));

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rootI.get("time"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> spendingStatsForDay(int userId, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootS = q.from(Spending.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootS.get("userId"), userId));

        if (fromDate != null) {
            java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
            predicates.add(b.greaterThanOrEqualTo(rootS.get("time"), sqlFromDate));
        }

        if (toDate != null) {
            java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
            predicates.add(b.lessThanOrEqualTo(rootS.get("time"), sqlToDate));
        }

        q.multiselect(rootS.get("time"), b.sum(rootS.get("money")).as(BigDecimal.class));

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rootS.get("time"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public BigDecimal totalIncomeMonth(int month, User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Income> q = b.createQuery(Income.class);

        Root rootI = q.from(Income.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootI.get("userId"), user.getId()));

        predicates.add(b.equal(b.function("month", Integer.class, rootI.get("time")), month));

        q.select(b.sum(rootI.get("money").as(BigDecimal.class)));
        q.where(predicates.toArray(new Predicate[]{}));

        Query query = session.createQuery(q);
        if (query.getResultList().get(0) != null) {
            return (BigDecimal) query.getResultList().get(0);
        }
        return BigDecimal.valueOf(0.0);

    }

    @Override
    public BigDecimal totalSpendingMonth(int month, User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Spending> q = b.createQuery(Spending.class);

        Root rootS = q.from(Spending.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootS.get("userId"), user.getId()));

        predicates.add(b.equal(b.function("month", Integer.class, rootS.get("time")), month));

        q.select(b.sum(rootS.get("money").as(BigDecimal.class)));
        q.where(predicates.toArray(new Predicate[]{}));

        Query query = session.createQuery(q);
        if (query.getResultList().get(0) != null) {
            return (BigDecimal) query.getResultList().get(0);
        }

        return BigDecimal.valueOf(0.0);
    }

    @Override
    public int countUserIncomeGroup(Gr groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(distinct u.userId) From UserIncomeGroup as u where u.groupId=:groupId");
        query.setParameter("groupId", groupId);

        return Math.toIntExact((long) query.getSingleResult());
    }

    @Override
    public BigDecimal totalMoneyGroup(Gr groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT SUM(u.money) FROM UserIncomeGroup as u WHERE u.groupId=:groupId");
        query.setParameter("groupId", groupId);

        Double total = (Double) query.getSingleResult();
        BigDecimal total2 = BigDecimal.valueOf(total);

        if (total2 != null) {
            return total2;
        }

        return BigDecimal.valueOf(0.0);
    }

    @Override
    public int coutMember(Gr groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(b.userId) From BelongTo as b where b.groupId=:groupId");
        query.setParameter("groupId", groupId);
        
        return Math.toIntExact((long) query.getSingleResult());
    }

    @Override
    public BigDecimal totalMoneyUserIncomeGroup(User userId, Gr groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT SUM(u.money) FROM UserIncomeGroup as u where u.userId=:userId and u.groupId=:groupId");
        query.setParameter("userId", userId);
        query.setParameter("groupId", groupId);
        try {
            Double total = (Double) query.getSingleResult();
            BigDecimal total2 = BigDecimal.valueOf(total);

            if(total2 != null){
                return total2;
            }
        }catch(Exception ex){
            return BigDecimal.valueOf(0.0);
        }
        
        return BigDecimal.valueOf(0.0);
        
    }

    @Override
    public List<MustReturn> moneyUserPay(Gr groupId) {
        BigDecimal totalMoneyIncomeGroup = this.totalMoneyGroup(groupId);
        List<MustReturn> mustReturns = new ArrayList<>();
        this.belongRepository.getUserInGroup(groupId).forEach(userBelong -> {
            mustReturns.add(new MustReturn(userBelong.getUserId().getUsername(),this.totalMoneyGroup(groupId).divide(BigDecimal.valueOf(this.coutMember(groupId))).subtract( this.totalMoneyUserIncomeGroup(userBelong.getUserId(), groupId)))  );
        });
        
        return mustReturns;
    }

    @Override
    public List<MoneyPaid> moneyUserPaid(Gr groupId) {
        List<MoneyPaid> moneyPaids = new ArrayList<>();
        this.belongRepository.getUserInGroup(groupId).forEach(userBelong -> {
            moneyPaids.add(new MoneyPaid(userBelong.getUserId().getUsername(),this.statsService.totalMoneyUserIncomeGroup(userBelong.getUserId(), groupId)));
           
        });
        
        return moneyPaids;
    }



}
