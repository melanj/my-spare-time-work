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
 * Licenses generated by hbm2java
 */
@Entity
@Table(name="licenses"
    ,catalog="ashrm"
)
public class Licenses  implements java.io.Serializable {


     private String licensesCode;
     private String licensesDesc;
     private Set<EmpLicenses> empLicenseses = new HashSet<EmpLicenses>(0);

    public Licenses() {
    }

	
    public Licenses(String licensesCode) {
        this.licensesCode = licensesCode;
    }
    public Licenses(String licensesCode, String licensesDesc, Set<EmpLicenses> empLicenseses) {
       this.licensesCode = licensesCode;
       this.licensesDesc = licensesDesc;
       this.empLicenseses = empLicenseses;
    }
   
     @Id 
    
    @Column(name="licenses_code", unique=true, nullable=false, length=13)
    public String getLicensesCode() {
        return this.licensesCode;
    }
    
    public void setLicensesCode(String licensesCode) {
        this.licensesCode = licensesCode;
    }
    
    @Column(name="licenses_desc", length=50)
    public String getLicensesDesc() {
        return this.licensesDesc;
    }
    
    public void setLicensesDesc(String licensesDesc) {
        this.licensesDesc = licensesDesc;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="licenses")
    public Set<EmpLicenses> getEmpLicenseses() {
        return this.empLicenseses;
    }
    
    public void setEmpLicenseses(Set<EmpLicenses> empLicenseses) {
        this.empLicenseses = empLicenseses;
    }




}

