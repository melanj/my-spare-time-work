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
 * EmpPicture generated by hbm2java
 */
@Entity
@Table(name="emp_picture"
    ,catalog="ashrm"
)
public class EmpPicture  implements java.io.Serializable {


     private int empNumber;
     private Employee employee;
     private byte[] epicPicture;
     private String epicFilename;
     private String epicType;
     private String epicFileSize;

    public EmpPicture() {
    }

	
    public EmpPicture(int empNumber, Employee employee) {
        this.empNumber = empNumber;
        this.employee = employee;
    }
    public EmpPicture(int empNumber, Employee employee, byte[] epicPicture, String epicFilename, String epicType, String epicFileSize) {
       this.empNumber = empNumber;
       this.employee = employee;
       this.epicPicture = epicPicture;
       this.epicFilename = epicFilename;
       this.epicType = epicType;
       this.epicFileSize = epicFileSize;
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
    
    @Column(name="epic_picture")
    public byte[] getEpicPicture() {
        return this.epicPicture;
    }
    
    public void setEpicPicture(byte[] epicPicture) {
        this.epicPicture = epicPicture;
    }
    
    @Column(name="epic_filename", length=100)
    public String getEpicFilename() {
        return this.epicFilename;
    }
    
    public void setEpicFilename(String epicFilename) {
        this.epicFilename = epicFilename;
    }
    
    @Column(name="epic_type", length=50)
    public String getEpicType() {
        return this.epicType;
    }
    
    public void setEpicType(String epicType) {
        this.epicType = epicType;
    }
    
    @Column(name="epic_file_size", length=20)
    public String getEpicFileSize() {
        return this.epicFileSize;
    }
    
    public void setEpicFileSize(String epicFileSize) {
        this.epicFileSize = epicFileSize;
    }




}

