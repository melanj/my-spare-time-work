package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EmpReportto generated by hbm2java
 */
@Entity
@Table(name="emp_reportto"
    ,catalog="ashrm"
)
public class EmpReportto  implements java.io.Serializable {


     private EmpReporttoId id;
     private Employee employeeByErepSubEmpNumber;
     private Employee employeeByErepSupEmpNumber;

    public EmpReportto() {
    }

    public EmpReportto(EmpReporttoId id, Employee employeeByErepSubEmpNumber, Employee employeeByErepSupEmpNumber) {
       this.id = id;
       this.employeeByErepSubEmpNumber = employeeByErepSubEmpNumber;
       this.employeeByErepSupEmpNumber = employeeByErepSupEmpNumber;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="erepSupEmpNumber", column=@Column(name="erep_sup_emp_number", nullable=false) ), 
        @AttributeOverride(name="erepSubEmpNumber", column=@Column(name="erep_sub_emp_number", nullable=false) ), 
        @AttributeOverride(name="erepReportingMode", column=@Column(name="erep_reporting_mode", nullable=false) ) } )
    public EmpReporttoId getId() {
        return this.id;
    }
    
    public void setId(EmpReporttoId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="erep_sub_emp_number", nullable=false, insertable=false, updatable=false)
    public Employee getEmployeeByErepSubEmpNumber() {
        return this.employeeByErepSubEmpNumber;
    }
    
    public void setEmployeeByErepSubEmpNumber(Employee employeeByErepSubEmpNumber) {
        this.employeeByErepSubEmpNumber = employeeByErepSubEmpNumber;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="erep_sup_emp_number", nullable=false, insertable=false, updatable=false)
    public Employee getEmployeeByErepSupEmpNumber() {
        return this.employeeByErepSupEmpNumber;
    }
    
    public void setEmployeeByErepSupEmpNumber(Employee employeeByErepSupEmpNumber) {
        this.employeeByErepSupEmpNumber = employeeByErepSupEmpNumber;
    }




}

