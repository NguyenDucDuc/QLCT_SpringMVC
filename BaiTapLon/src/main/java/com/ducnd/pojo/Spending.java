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
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DucND
 */
@Entity
@Table(name = "spending")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spending.findAll", query = "SELECT s FROM Spending s"),
    @NamedQuery(name = "Spending.findById", query = "SELECT s FROM Spending s WHERE s.id = :id"),
    @NamedQuery(name = "Spending.findByMoney", query = "SELECT s FROM Spending s WHERE s.money = :money"),
    @NamedQuery(name = "Spending.findByTime", query = "SELECT s FROM Spending s WHERE s.time = :time"),
    @NamedQuery(name = "Spending.findByPurpose", query = "SELECT s FROM Spending s WHERE s.purpose = :purpose")})
public class Spending implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "money")
    @Min(value = 1000, message = "{spending.minErr}")
    private Double money;
    @Column(name = "time")
//    @Temporal(TemporalType.TIMESTAMP)
    private java.sql.Date time;
    
    @Column(name = "purpose")
    @Size(min = 5, max = 100, message = "{spending.sizeErr}")
    private String purpose;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Spending() {
    }

    public Spending(Integer id) {
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
        if (!(object instanceof Spending)) {
            return false;
        }
        Spending other = (Spending) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ducnd.pojo.Spending[ id=" + id + " ]";
    }

    /**
     * @param time the time to set
     */
    public void setTime(java.sql.Date time) {
        this.time = time;
    }
    
}
