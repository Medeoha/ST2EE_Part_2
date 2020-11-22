/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author narut
 */
@Entity
@Table(name = "info_intern", catalog = "st2eedb", schema = "")
@NamedQueries({
    @NamedQuery(name = "InfoIntern.findAll", query = "SELECT i FROM InfoIntern i"),
    @NamedQuery(name = "InfoIntern.findById", query = "SELECT i FROM InfoIntern i WHERE i.id = :id"),
    @NamedQuery(name = "InfoIntern.findByFirstname", query = "SELECT i FROM InfoIntern i WHERE i.firstname = :firstname"),
    @NamedQuery(name = "InfoIntern.findByLastname", query = "SELECT i FROM InfoIntern i WHERE i.lastname = :lastname"),
    @NamedQuery(name = "InfoIntern.findByAddress", query = "SELECT i FROM InfoIntern i WHERE i.address = :address"),
    @NamedQuery(name = "InfoIntern.findByInternGroup", query = "SELECT i FROM InfoIntern i WHERE i.internGroup = :internGroup"),
    @NamedQuery(name = "InfoIntern.findByBirthday", query = "SELECT i FROM InfoIntern i WHERE i.birthday = :birthday")})
public class InfoIntern implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 255)
    private String firstname;
    @Size(max = 255)
    private String lastname;
    @Size(max = 255)
    private String address;
    @Lob
    @Size(max = 65535)
    private String skills;
    @Lob
    @Size(max = 65535)
    private String linkedin;
    @Size(max = 255)
    @Column(name = "intern_group")
    private String internGroup;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    @OneToOne(mappedBy = "info_intern")
    @JoinColumn(name = "info_intern_id")
    private Intern intern;

    public InfoIntern() {
    }

    public InfoIntern(Integer id) {
        this.id = id;
    }

    public InfoIntern(Integer id, String firstname, String lastname, String address, String skills, String linkedin, String internGroup, Date birthday, Intern intern) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.skills = skills;
        this.linkedin = linkedin;
        this.internGroup = internGroup;
        this.birthday = birthday;
        this.intern = intern;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInternGroup() {
        return internGroup;
    }

    public void setInternGroup(String internGroup) {
        this.internGroup = internGroup;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
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
        if (!(object instanceof InfoIntern)) {
            return false;
        }
        InfoIntern other = (InfoIntern) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.InfoIntern[ id=" + id + " ]";
    }
    
}
