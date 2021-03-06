package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EmpWorkExperience generated by hbm2java
 */
@Entity
@Table(name="emp_work_experience"
    ,catalog="ashrm"
)
public class EmpWorkExperience  implements java.io.Serializable {


     private EmpWorkExperienceId id;
     private Employee employee;
     private String eexpEmployer;
     private String eexpJobtit;
     private Date eexpFromDate;
     private Date eexpToDate;
     private String eexpComments;
     private Integer eexpInternal;

    public EmpWorkExperience() {
    }

	
    public EmpWorkExperience(EmpWorkExperienceId id, Employee employee) {
        this.id = id;
        this.employee = employee;
    }
    public EmpWorkExperience(EmpWorkExperienceId id, Employee employee, String eexpEmployer, String eexpJobtit, Date eexpFromDate, Date eexpToDate, String eexpComments, Integer eexpInternal) {
       this.id = id;
       this.employee = employee;
       this.eexpEmployer = eexpEmployer;
       this.eexpJobtit = eexpJobtit;
       this.eexpFromDate = eexpFromDate;
       this.eexpToDate = eexpToDate;
       this.eexpComments = eexpComments;
       this.eexpInternal = eexpInternal;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="empNumber", column=@Column(name="emp_number", nullable=false) ), 
        @AttributeOverride(name="eexpSeqno", column=@Column(name="eexp_seqno", nullable=false, precision=10, scale=0) ) } )
    public EmpWorkExperienceId getId() {
        return this.id;
    }
    
    public void setId(EmpWorkExperienceId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emp_number", nullable=false, insertable=false, updatable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    @Column(name="eexp_employer", length=100)
    public String getEexpEmployer() {
        return this.eexpEmployer;
    }
    
    public void setEexpEmployer(String eexpEmployer) {
        this.eexpEmployer = eexpEmployer;
    }
    
    @Column(name="eexp_jobtit", length=120)
    public String getEexpJobtit() {
        return this.eexpJobtit;
    }
    
    public void setEexpJobtit(String eexpJobtit) {
        this.eexpJobtit = eexpJobtit;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="eexp_from_date", length=19)
    public Date getEexpFromDate() {
        return this.eexpFromDate;
    }
    
    public void setEexpFromDate(Date eexpFromDate) {
        this.eexpFromDate = eexpFromDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="eexp_to_date", length=19)
    public Date getEexpToDate() {
        return this.eexpToDate;
    }
    
    public void setEexpToDate(Date eexpToDate) {
        this.eexpToDate = eexpToDate;
    }
    
    @Column(name="eexp_comments", length=200)
    public String getEexpComments() {
        return this.eexpComments;
    }
    
    public void setEexpComments(String eexpComments) {
        this.eexpComments = eexpComments;
    }
    
    @Column(name="eexp_internal")
    public Integer getEexpInternal() {
        return this.eexpInternal;
    }
    
    public void setEexpInternal(Integer eexpInternal) {
        this.eexpInternal = eexpInternal;
    }




}


