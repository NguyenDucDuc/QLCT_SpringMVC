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
import javax.persistence.JoinColumns;
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
@Table(name = "user_spending_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSpendingGroup.findAll", query = "SELECT u FROM UserSpendingGroup u"),
    @NamedQuery(name = "UserSpendingGroup.findById", query = "SELECT u FROM UserSpendingGroup u WHERE u.id = :id"),
    @NamedQuery(name = "UserSpendingGroup.findByTime", query = "SELECT u FROM UserSpendingGroup u WHERE u.time = :time"),
    @NamedQuery(name = "UserSpendingGroup.findByMoney", query = "SELECT u FROM UserSpendingGroup u WHERE u.money = :money"),
    @NamedQuery(name = "UserSpendingGroup.findByPurpose", query = "SELECT u FROM UserSpendingGroup u WHERE u.purpose = :purpose")})
public class UserSpendingGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "money")
    private Double money;
    @Size(max = 45)
    @Column(name = "purpose")
    private String purpose;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne
    private Gr gr;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public UserSpendingGroup() {
    }

    public UserSpendingGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Gr getGr() {
        return gr;
    }

    public void setGr(Gr gr) {
        this.gr = gr;
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
        if (!(object instanceof UserSpendingGroup)) {
            return false;
        }
        UserSpendingGroup other = (UserSpendingGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ducnd.pojo.UserSpendingGroup[ id=" + id + " ]";
    }
    
}
