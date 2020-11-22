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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

/**
 *
 * @author Quentin
 */
@Entity
@Table(name = "visit_sheet", catalog = "st2eedb", schema = "")
@NamedQueries({
    @NamedQuery(name = "VisitSheet.findAll", query = "SELECT v FROM VisitSheet v"),
    @NamedQuery(name = "VisitSheet.findById", query = "SELECT v FROM VisitSheet v WHERE v.id = :id"),
    @NamedQuery(name = "VisitSheet.findByVisitPlanned", query = "SELECT v FROM VisitSheet v WHERE v.visitPlanned = :visitPlanned"),
    @NamedQuery(name = "VisitSheet.findByVisitDone", query = "SELECT v FROM VisitSheet v WHERE v.visitDone = :visitDone")})
public class VisitSheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Column(name = "visit_planned")
    private Boolean visitPlanned;
    @Column(name = "visit_done")
    private Boolean visitDone;
    @OneToOne(mappedBy="visit_sheet", cascade=CascadeType.ALL)
   // @JoinColumn(name = "visit_sheet_id")   
    private Mission mission;

    public VisitSheet() {
    }

    public VisitSheet(Integer id) {
        this.id = id;
    }

    public VisitSheet(Integer id, Boolean visitPlanned, Boolean visitDone, Mission mission) {
        this.id = id;
        this.visitPlanned = visitPlanned;
        this.visitDone = visitDone;
        this.mission = mission;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getVisitPlanned() {
        return visitPlanned;
    }

    public void setVisitPlanned(Boolean visitPlanned) {
        this.visitPlanned = visitPlanned;
    }

    public Boolean getVisitDone() {
        return visitDone;
    }

    public void setVisitDone(Boolean visitDone) {
        this.visitDone = visitDone;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
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
        if (!(object instanceof VisitSheet)) {
            return false;
        }
        VisitSheet other = (VisitSheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.VisitSheet[ id=" + id + " ]";
    }
    
}
