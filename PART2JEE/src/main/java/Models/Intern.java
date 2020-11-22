/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Quentin
 */
@Entity
@Table(name = "intern",catalog = "st2eedb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Intern.findAll", query = "SELECT i FROM Intern i"),
    @NamedQuery(name = "Intern.findById", query = "SELECT i FROM Intern i WHERE i.id = :id"),
    @NamedQuery(name = "Intern.findByMissionId", query = "SELECT i FROM Intern i WHERE i.mission = :mission"),
    @NamedQuery(name = "Intern.findByInfoInternId", query = "SELECT i FROM Intern i WHERE i.info_intern = :info_intern"),
    @NamedQuery(name = "Intern.findByTeacherId", query = "SELECT i FROM Intern i WHERE i.teacher = :teacher")})
public class Intern implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "mission_id", insertable = true, updatable = true)
    private Mission mission;
    
    @OneToOne
    @JoinColumn(name = "info_id", insertable = true, updatable = true)
    private InfoIntern info_intern;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id", insertable = true, updatable = true)
    private Teacher teacher;

    public Intern() {
    }

    public Intern(Integer id) {
        this.id = id;
    }

    public Intern(Integer id, Mission mission, InfoIntern info_intern, Teacher teacher) {
        this.id = id;
        this.mission = mission;
        this.info_intern = info_intern;
        this.teacher = teacher;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public InfoIntern getInfo_intern() {
        return info_intern;
    }

    public void setInfo_intern(InfoIntern info_intern) {
        this.info_intern = info_intern;
    }

   

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
        if (!(object instanceof Intern)) {
            return false;
        }
        Intern other = (Intern) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Intern[ id=" + id + " ]";
    }
    
}
