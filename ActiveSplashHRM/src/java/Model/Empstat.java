package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Empstat generated by hbm2java
 */
@Entity
@Table(name="empstat"
    ,catalog="ashrm"
)
public class Empstat  implements java.io.Serializable {


     private String estatCode;
     private String estatName;
     private Set<Employee> employees = new HashSet<Employee>(0);
     private Set<JobTitle> jobTitles = new HashSet<JobTitle>(0);

    public Empstat() {
    }

	
    public Empstat(String estatCode) {
        this.estatCode = estatCode;
    }
    public Empstat(String estatCode, String estatName, Set<Employee> employees, Set<JobTitle> jobTitles) {
       this.estatCode = estatCode;
       this.estatName = estatName;
       this.employees = employees;
       this.jobTitles = jobTitles;
    }
   
     @Id 
    
    @Column(name="estat_code", unique=true, nullable=false, length=13)
    public String getEstatCode() {
        return this.estatCode;
    }
    
    public void setEstatCode(String estatCode) {
        this.estatCode = estatCode;
    }
    
    @Column(name="estat_name", length=50)
    public String getEstatName() {
        return this.estatName;
    }
    
    public void setEstatName(String estatName) {
        this.estatName = estatName;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empstat")
    public Set<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="empstats")
    public Set<JobTitle> getJobTitles() {
        return this.jobTitles;
    }
    
    public void setJobTitles(Set<JobTitle> jobTitles) {
        this.jobTitles = jobTitles;
    }




}

