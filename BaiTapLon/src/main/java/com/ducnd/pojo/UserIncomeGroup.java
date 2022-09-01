/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DucND
 */
@Entity
@Table(name = "user_income_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserIncomeGroup.findAll", query = "SELECT u FROM UserIncomeGroup u"),
    @NamedQuery(name = "UserIncomeGroup.findById", query = "SELECT u FROM UserIncomeGroup u WHERE u.id = :id"),
    @NamedQuery(name = "UserIncomeGroup.findByMoney", query = "SELECT u FROM UserIncomeGroup u WHERE u.money = :money"),
    @NamedQuery(name = "UserIncomeGroup.findByTime", query = "SELECT u FROM UserIncomeGroup u WHERE u.time = :time"),
    @NamedQuery(name = "UserIncomeGroup.findByPurpose", query = "SELECT u FROM UserIncomeGroup u WHERE u.purpose = :purpose")})
public class UserIncomeGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "money")
    private Double money;
    @Column(name = "time")
//    @Temporal(TemporalType.TIMESTAMP)
    private java.sql.Date time;
    @Size(max = 45)
    @Column(name = "purpose")
    private String purpose;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne
    private Gr groupId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public UserIncomeGroup() {
    }

    public UserIncomeGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

//    public void setTime(Date time) {
//        this.time = time;
//    }
    

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Gr getGroupId() {
        return groupId;
    }

    public void setGroupId(Gr groupId) {
        this.groupId = groupId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserIncomeGroup)) {
            return false;
        }
        UserIncomeGroup other = (UserIncomeGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ducnd.pojo.UserIncomeGroup[ id=" + id + " ]";
    }

    /**
     * @param time the time to set
     */
    public void setTime(java.sql.Date time) {
        this.time = time;
    }
    
}
