package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EmpUsTax generated by hbm2java
 */
@Entity
@Table(name="emp_us_tax"
    ,catalog="ashrm"
)
public class EmpUsTax  implements java.io.Serializable {


     private int empNumber;
     private Employee employee;
     private String taxFederalStatus;
     private Integer taxFederalExceptions;
     private String taxState;
     private String taxStateStatus;
     private Integer taxStateExceptions;
     private String taxUnempState;
     private String taxWorkState;

    public EmpUsTax() {
    }

	
    public EmpUsTax(int empNumber, Employee employee) {
        this.empNumber = empNumber;
        this.employee = employee;
    }
    public EmpUsTax(int empNumber, Employee employee, String taxFederalStatus, Integer taxFederalExceptions, String taxState, String taxStateStatus, Integer taxStateExceptions, String taxUnempState, String taxWorkState) {
       this.empNumber = empNumber;
       this.employee = employee;
       this.taxFederalStatus = taxFederalStatus;
       this.taxFederalExceptions = taxFederalExceptions;
       this.taxState = taxState;
       this.taxStateStatus = taxStateStatus;
       this.taxStateExceptions = taxStateExceptions;
       this.taxUnempState = taxUnempState;
       this.taxWorkState = taxWorkState;
    }
   
     @Id 
    
    @Column(name="emp_number", unique=true, nullable=false)
    public int getEmpNumber() {
        return this.empNumber;
    }
    
    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emp_number", unique=true, nullable=false, insertable=false, updatable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    @Column(name="tax_federal_status", length=13)
    public String getTaxFederalStatus() {
        return this.taxFederalStatus;
    }
    
    public void setTaxFederalStatus(String taxFederalStatus) {
        this.taxFederalStatus = taxFederalStatus;
    }
    
    @Column(name="tax_federal_exceptions")
    public Integer getTaxFederalExceptions() {
        return this.taxFederalExceptions;
    }
    
    public void setTaxFederalExceptions(Integer taxFederalExceptions) {
        this.taxFederalExceptions = taxFederalExceptions;
    }
    
    @Column(name="tax_state", length=13)
    public String getTaxState() {
        return this.taxState;
    }
    
    public void setTaxState(String taxState) {
        this.taxState = taxState;
    }
    
    @Column(name="tax_state_status", length=13)
    public String getTaxStateStatus() {
        return this.taxStateStatus;
    }
    
    public void setTaxStateStatus(String taxStateStatus) {
        this.taxStateStatus = taxStateStatus;
    }
    
    @Column(name="tax_state_exceptions")
    public Integer getTaxStateExceptions() {
        return this.taxStateExceptions;
    }
    
    public void setTaxStateExceptions(Integer taxStateExceptions) {
        this.taxStateExceptions = taxStateExceptions;
    }
    
    @Column(name="tax_unemp_state", length=13)
    public String getTaxUnempState() {
        return this.taxUnempState;
    }
    
    public void setTaxUnempState(String taxUnempState) {
        this.taxUnempState = taxUnempState;
    }
    
    @Column(name="tax_work_state", length=13)
    public String getTaxWorkState() {
        return this.taxWorkState;
    }
    
    public void setTaxWorkState(String taxWorkState) {
        this.taxWorkState = taxWorkState;
    }




}

