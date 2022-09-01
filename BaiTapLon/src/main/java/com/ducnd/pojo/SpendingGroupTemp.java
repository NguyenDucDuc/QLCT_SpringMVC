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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DucND
 */
@Entity
@Table(name = "spending_group_temp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpendingGroupTemp.findAll", query = "SELECT s FROM SpendingGroupTemp s"),
    @NamedQuery(name = "SpendingGroupTemp.findById", query = "SELECT s FROM SpendingGroupTemp s WHERE s.id = :id"),
    @NamedQuery(name = "SpendingGroupTemp.findByUserId", query = "SELECT s FROM SpendingGroupTemp s WHERE s.userId = :userId"),
    @NamedQuery(name = "SpendingGroupTemp.findByGroupId", query = "SELECT s FROM SpendingGroupTemp s WHERE s.groupId = :groupId"),
    @NamedQuery(name = "SpendingGroupTemp.findByTime", query = "SELECT s FROM SpendingGroupTemp s WHERE s.time = :time"),
    @NamedQuery(name = "SpendingGroupTemp.findByPurpose", query = "SELECT s FROM SpendingGroupTemp s WHERE s.purpose = :purpose"),
    @NamedQuery(name = "SpendingGroupTemp.findByMoney", query = "SELECT s FROM SpendingGroupTemp s WHERE s.money = :money")})
public class SpendingGroupTemp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private User userId;
    @Column(name = "group_id")
    private Gr groupId;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Size(max = 155)
    @Column(name = "purpose")
    private String purpose;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "money")
    private Double money;

    public SpendingGroupTemp() {
    }

    public SpendingGroupTemp(Integer id) {
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

    public void setTime(Date time) {
        this.time = time;
    }

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
        if (!(object instanceof SpendingGroupTemp)) {
            return false;
        }
        SpendingGroupTemp other = (SpendingGroupTemp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.SpendingGroupTemp[ id=" + id + " ]";
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }

    /**
     * @return the groupId
     */
    public Gr getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(Gr groupId) {
        this.groupId = groupId;
    }
    
}