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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Quentin
 */
@Entity
@Table(name = "eval_sheet", catalog = "st2eedb", schema = "")
@NamedQueries({
    @NamedQuery(name = "EvalSheet.findAll", query = "SELECT e FROM EvalSheet e"),
    @NamedQuery(name = "EvalSheet.findById", query = "SELECT e FROM EvalSheet e WHERE e.id = :id"),
    @NamedQuery(name = "EvalSheet.findByGradeTech", query = "SELECT e FROM EvalSheet e WHERE e.gradeTech = :gradeTech"),
    @NamedQuery(name = "EvalSheet.findByGradeCom", query = "SELECT e FROM EvalSheet e WHERE e.gradeCom = :gradeCom"),
    @NamedQuery(name = "EvalSheet.findByEvalSheetDone", query = "SELECT e FROM EvalSheet e WHERE e.evalSheetDone = :evalSheetDone")})
public class EvalSheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "comments_of_supervisor")
    private String commentsOfSupervisor;
    @Column(name = "grade_tech")
    private Integer gradeTech;
    @Column(name = "grade_com")
    private Integer gradeCom;
    @Column(name = "eval_sheet_done")
    private Boolean evalSheetDone;
    
    @OneToOne(mappedBy="eval_sheet", cascade=CascadeType.ALL)
    //@JoinColumn(name = "eval_sheet_id")   
    private Mission mission;
    
    public EvalSheet() {
    }

    public EvalSheet(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentsOfSupervisor() {
        return commentsOfSupervisor;
    }

    public void setCommentsOfSupervisor(String commentsOfSupervisor) {
        this.commentsOfSupervisor = commentsOfSupervisor;
    }

    public Integer getGradeTech() {
        return gradeTech;
    }

    public void setGradeTech(Integer gradeTech) {
        this.gradeTech = gradeTech;
    }

    public Integer getGradeCom() {
        return gradeCom;
    }

    public void setGradeCom(Integer gradeCom) {
        this.gradeCom = gradeCom;
    }

    public Boolean getEvalSheetDone() {
        return evalSheetDone;
    }

    public void setEvalSheetDone(Boolean evalSheetDone) {
        this.evalSheetDone = evalSheetDone;
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
        if (!(object instanceof EvalSheet)) {
            return false;
        }
        EvalSheet other = (EvalSheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.EvalSheet[ id=" + id + " ]";
    }
    
}
