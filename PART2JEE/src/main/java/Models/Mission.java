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
import javax.persistence.*;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author quentin
 */
@Entity
@Table(name = "mission",catalog = "st2eedb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Mission.findAll", query = "SELECT m FROM Mission m"),
    @NamedQuery(name = "Mission.findById", query = "SELECT m FROM Mission m WHERE m.id = :id"),
    @NamedQuery(name = "Mission.findByYear", query = "SELECT m FROM Mission m WHERE m.year = :year"),
    @NamedQuery(name = "Mission.findByStartMission", query = "SELECT m FROM Mission m WHERE m.startMission = :startMission"),
    @NamedQuery(name = "Mission.findByEndMission", query = "SELECT m FROM Mission m WHERE m.endMission = :endMission"),
    @NamedQuery(name = "Mission.findByReportTitle", query = "SELECT m FROM Mission m WHERE m.reportTitle = :reportTitle"),
    @NamedQuery(name = "Mission.findBySoutenance", query = "SELECT m FROM Mission m WHERE m.soutenance = :soutenance"),
    @NamedQuery(name = "Mission.findByEvalSheetId", query = "SELECT m FROM Mission m WHERE m.eval_sheet = :eval_sheet"),
    @NamedQuery(name = "Mission.findByVisitSheetId", query = "SELECT m FROM Mission m WHERE m.visit_sheet = :visit_sheet")})
public class Mission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Integer year;
    @Column(name = "start_mission")
    @Temporal(TemporalType.DATE)
    private Date startMission;
    @Column(name = "end_mission")
    @Temporal(TemporalType.DATE)
    private Date endMission;
    @Size(max = 255)
    @Column(name = "report_title")
    private String reportTitle;
    @Lob
    @Size(max = 65535)
    @Column(name = "comments_of_the_intern")
    private String commentsOfTheIntern;
    @Lob
    @Size(max = 65535)
    @Column(name = "mid_internship_meeting_info")
    private String midInternshipMeetingInfo;
    private Boolean soutenance;
    @Lob
    @Size(max = 65535)
    @Column(name = "key_word")
    private String keyWord;

    @OneToOne
    @JoinColumn(name = "mission_id")
    private Intern intern;
    
    @OneToOne//(fetch = FetchType.LAZY , mappedBy = "eval_sheet_id")
    @JoinColumn(name = "eval_sheet_id")
    private EvalSheet eval_sheet;
    
    @OneToOne
    @JoinColumn(name = "visit_sheet_id")
    private VisitSheet visit_sheet;
    public Mission() {
    }

    public Mission(Integer id) {
        this.id = id;
    }

    public Mission(Integer id, Integer year, Date startMission, Date endMission, String reportTitle, String commentsOfTheIntern, String midInternshipMeetingInfo, Boolean soutenance, String keyWord, Intern intern, EvalSheet eval_sheet, VisitSheet visit_sheet) {
        this.id = id;
        this.year = year;
        this.startMission = startMission;
        this.endMission = endMission;
        this.reportTitle = reportTitle;
        this.commentsOfTheIntern = commentsOfTheIntern;
        this.midInternshipMeetingInfo = midInternshipMeetingInfo;
        this.soutenance = soutenance;
        this.keyWord = keyWord;
        this.intern = intern;
        this.eval_sheet = eval_sheet;
        this.visit_sheet = visit_sheet;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getStartMission() {
        return startMission;
    }

    public void setStartMission(Date startMission) {
        this.startMission = startMission;
    }

    public Date getEndMission() {
        return endMission;
    }

    public void setEndMission(Date endMission) {
        this.endMission = endMission;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getCommentsOfTheIntern() {
        return commentsOfTheIntern;
    }

    public void setCommentsOfTheIntern(String commentsOfTheIntern) {
        this.commentsOfTheIntern = commentsOfTheIntern;
    }

    public String getMidInternshipMeetingInfo() {
        return midInternshipMeetingInfo;
    }

    public void setMidInternshipMeetingInfo(String midInternshipMeetingInfo) {
        this.midInternshipMeetingInfo = midInternshipMeetingInfo;
    }

    public Boolean getSoutenance() {
        return soutenance;
    }

    public void setSoutenance(Boolean soutenance) {
        this.soutenance = soutenance;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    public EvalSheet getEval_sheet() {
        return eval_sheet;
    }

    public void setEval_sheet(EvalSheet eval_sheet) {
        this.eval_sheet = eval_sheet;
    }

    public VisitSheet getVisit_sheet() {
        return visit_sheet;
    }

    public void setVisit_sheet(VisitSheet visit_sheet) {
        this.visit_sheet = visit_sheet;
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
        if (!(object instanceof Mission)) {
            return false;
        }
        Mission other = (Mission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Mission[ id=" + id + " ]";
    }
    
}
