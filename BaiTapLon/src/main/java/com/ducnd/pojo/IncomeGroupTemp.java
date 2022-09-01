/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.pojo;

/**
 *
 * @author DucND
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DucND
 */
@Entity
@Table(name = "income_group_temp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncomeGroupTemp.findAll", query = "SELECT i FROM IncomeGroupTemp i"),
    @NamedQuery(name = "IncomeGroupTemp.findById", query = "SELECT i FROM IncomeGroupTemp i WHERE i.id = :id"),
    @NamedQuery(name = "IncomeGroupTemp.findByUserId", query = "SELECT i FROM IncomeGroupTemp i WHERE i.userId = :userId"),
    @NamedQuery(name = "IncomeGroupTemp.findByGroupId", query = "SELECT i FROM IncomeGroupTemp i WHERE i.groupId = :groupId"),
    @NamedQuery(name = "IncomeGroupTemp.findByTime", query = "SELECT i FROM IncomeGroupTemp i WHERE i.time = :time"),
    @NamedQuery(name = "IncomeGroupTemp.findByPurpose", query = "SELECT i FROM IncomeGroupTemp i WHERE i.purpose = :purpose"),
    @NamedQuery(name = "IncomeGroupTemp.findByMoney", query = "SELECT i FROM IncomeGroupTemp i WHERE i.money = :money")})
public class IncomeGroupTemp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "time")
//    @Temporal(TemporalType.TIMESTAMP)
    private java.sql.Date time;
    @Size(min = 5, max = 155, message = "Purpose phai lon hon 5 nho hon 155 ky tu")
    @Column(name = "purpose")
    private String purpose;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "money")
    @Min(value = 1000, message = "{income.minErr}")
    private Double money;

    public IncomeGroupTemp() {
    }

    public IncomeGroupTemp(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Integer getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(Integer groupId) {
//        this.groupId = groupId;
//    }

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
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
        if (!(object instanceof IncomeGroupTemp)) {
            return false;
        }
        IncomeGroupTemp other = (IncomeGroupTemp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.IncomeGroupTemp[ id=" + id + " ]";
    }

    /**
     * @return the userId
     */
    

    /**
     * @param time the time to set
     */
    public void setTime(java.sql.Date time) {
        this.time = time;
    }

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the groupId
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    
}
