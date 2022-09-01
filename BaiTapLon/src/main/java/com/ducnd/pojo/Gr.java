/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.pojo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DucND
 */
@Entity
@Table(name = "gr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gr.findAll", query = "SELECT g FROM Gr g"),
    @NamedQuery(name = "Gr.findById", query = "SELECT g FROM Gr g WHERE g.id = :id"),
    @NamedQuery(name = "Gr.findByGroupname", query = "SELECT g FROM Gr g WHERE g.groupname = :groupname"),
    @NamedQuery(name = "Gr.findByPurpose", query = "SELECT g FROM Gr g WHERE g.purpose = :purpose")})
public class Gr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @Size(max = 45)
    @Column(name = "groupname")
//    @NotNull(message = "{group.notNullErr}")
    @Size(min = 5, max = 45, message = "{group.sizeErr}")
    private String groupname;
//    @Size(max = 100)
    @Column(name = "purpose")
//    @NotNull(message = "{group.purposeErr}")
    @Size(min = 5, max = 100, message = "{group.purpose.sizeErr}")
    private String purpose;
    @OneToMany(mappedBy = "gr")
    private Collection<UserSpendingGroup> userSpendingGroupCollection;
    @OneToMany(mappedBy = "groupId")
    private Collection<BelongTo> belongToCollection;
    @OneToMany(mappedBy = "groupId")
    private Collection<UserIncomeGroup> userIncomeGroupCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    @OneToMany(mappedBy = "groupId")
    private Collection<Message> messageCollection;

    public Gr() {
    }

    public Gr(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @XmlTransient
    public Collection<UserSpendingGroup> getUserSpendingGroupCollection() {
        return userSpendingGroupCollection;
    }

    public void setUserSpendingGroupCollection(Collection<UserSpendingGroup> userSpendingGroupCollection) {
        this.userSpendingGroupCollection = userSpendingGroupCollection;
    }

    @XmlTransient
    public Collection<BelongTo> getBelongToCollection() {
        return belongToCollection;
    }

    public void setBelongToCollection(Collection<BelongTo> belongToCollection) {
        this.belongToCollection = belongToCollection;
    }

    @XmlTransient
    public Collection<UserIncomeGroup> getUserIncomeGroupCollection() {
        return userIncomeGroupCollection;
    }

    public void setUserIncomeGroupCollection(Collection<UserIncomeGroup> userIncomeGroupCollection) {
        this.userIncomeGroupCollection = userIncomeGroupCollection;
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
        if (!(object instanceof Gr)) {
            return false;
        }
        Gr other = (Gr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ducnd.pojo.Gr[ id=" + id + " ]";
    }

    /**
     * @return the messageCollection
     */
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    /**
     * @param messageCollection the messageCollection to set
     */
    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }
    
}
