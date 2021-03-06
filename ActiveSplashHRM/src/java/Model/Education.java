package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Education generated by hbm2java
 */
@Entity
@Table(name="education"
    ,catalog="ashrm"
)
public class Education  implements java.io.Serializable {


     private String eduCode;
     private String eduUni;
     private String eduDeg;
     private Set<EmpEducation> empEducations = new HashSet<EmpEducation>(0);

    public Education() {
    }

	
    public Education(String eduCode) {
        this.eduCode = eduCode;
    }
    public Education(String eduCode, String eduUni, String eduDeg, Set<EmpEducation> empEducations) {
       this.eduCode = eduCode;
       this.eduUni = eduUni;
       this.eduDeg = eduDeg;
       this.empEducations = empEducations;
    }
   
     @Id 
    
    @Column(name="edu_code", unique=true, nullable=false, length=13)
    public String getEduCode() {
        return this.eduCode;
    }
    
    public void setEduCode(String eduCode) {
        this.eduCode = eduCode;
    }
    
    @Column(name="edu_uni", length=100)
    public String getEduUni() {
        return this.eduUni;
    }
    
    public void setEduUni(String eduUni) {
        this.eduUni = eduUni;
    }
    
    @Column(name="edu_deg", length=100)
    public String getEduDeg() {
        return this.eduDeg;
    }
    
    public void setEduDeg(String eduDeg) {
        this.eduDeg = eduDeg;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="education")
    public Set<EmpEducation> getEmpEducations() {
        return this.empEducations;
    }
    
    public void setEmpEducations(Set<EmpEducation> empEducations) {
        this.empEducations = empEducations;
    }




}


