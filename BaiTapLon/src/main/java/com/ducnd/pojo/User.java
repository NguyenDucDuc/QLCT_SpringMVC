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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DucND
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role"),
    @NamedQuery(name = "User.findByAvatar", query = "SELECT u FROM User u WHERE u.avatar = :avatar")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45, min = 1, message = "Username khong duoc bo trong. Do dai > 1 va < 45")
    @Column(name = "username")
    private String username;
    @Size(max = 155, min=1, message = "Password khong duoc bo trong. Do dai > 1 va < 155")
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Integer active;
    @Size(max = 10)
    @Column(name = "role")
    private String role;
    @Size(max=100, min = 1 , message = "Email khong duoc bo trong")
    @Column(name="email")
    @Email(message = "Dia chi email khong hop le")
    private String email;
    @Size(max = 155)
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(mappedBy = "userId")
    private Collection<Income> incomeCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Spending> spendingCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<UserSpendingGroup> userSpendingGroupCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<BelongTo> belongToCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<UserIncomeGroup> userIncomeGroupCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Warning> warningCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Gr> grCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Message> messageCollection;
    
    
    @Transient
    private MultipartFile file;
    
    @Transient
    @Size(min=1, max=155, message = "Confirm khong duoc bo trong. Do dai > 1 va  < 155 ")
    private String confirm;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Collection<Income> getIncomeCollection() {
        return incomeCollection;
    }

    public void setIncomeCollection(Collection<Income> incomeCollection) {
        this.incomeCollection = incomeCollection;
    }

    @XmlTransient
    public Collection<Spending> getSpendingCollection() {
        return spendingCollection;
    }

    public void setSpendingCollection(Collection<Spending> spendingCollection) {
        this.spendingCollection = spendingCollection;
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

    @XmlTransient
    public Collection<Warning> getWarningCollection() {
        return warningCollection;
    }

    public void setWarningCollection(Collection<Warning> warningCollection) {
        this.warningCollection = warningCollection;
    }

    @XmlTransient
    public Collection<Gr> getGrCollection() {
        return grCollection;
    }

    public void setGrCollection(Collection<Gr> grCollection) {
        this.grCollection = grCollection;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ducnd.pojo.User[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the confirm
     */
    public String getConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
