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
 * Leavetype generated by hbm2java
 */
@Entity
@Table(name="leavetype"
    ,catalog="ashrm"
)
public class Leavetype  implements java.io.Serializable {


     private String leaveTypeId;
     private String leaveTypeName;
     private Short availableFlag;
     private Set<LeaveRequests> leaveRequestses = new HashSet<LeaveRequests>(0);
     private Set<EmployeeLeaveQuota> employeeLeaveQuotas = new HashSet<EmployeeLeaveQuota>(0);

    public Leavetype() {
    }

	
    public Leavetype(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }
    public Leavetype(String leaveTypeId, String leaveTypeName, Short availableFlag, Set<LeaveRequests> leaveRequestses, Set<EmployeeLeaveQuota> employeeLeaveQuotas) {
       this.leaveTypeId = leaveTypeId;
       this.leaveTypeName = leaveTypeName;
       this.availableFlag = availableFlag;
       this.leaveRequestses = leaveRequestses;
       this.employeeLeaveQuotas = employeeLeaveQuotas;
    }
   
     @Id 
    
    @Column(name="leave_type_id", unique=true, nullable=false, length=13)
    public String getLeaveTypeId() {
        return this.leaveTypeId;
    }
    
    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }
    
    @Column(name="leave_type_name", length=20)
    public String getLeaveTypeName() {
        return this.leaveTypeName;
    }
    
    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }
    
    @Column(name="available_flag")
    public Short getAvailableFlag() {
        return this.availableFlag;
    }
    
    public void setAvailableFlag(Short availableFlag) {
        this.availableFlag = availableFlag;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="leavetype")
    public Set<LeaveRequests> getLeaveRequestses() {
        return this.leaveRequestses;
    }
    
    public void setLeaveRequestses(Set<LeaveRequests> leaveRequestses) {
        this.leaveRequestses = leaveRequestses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="leavetype")
    public Set<EmployeeLeaveQuota> getEmployeeLeaveQuotas() {
        return this.employeeLeaveQuotas;
    }
    
    public void setEmployeeLeaveQuotas(Set<EmployeeLeaveQuota> employeeLeaveQuotas) {
        this.employeeLeaveQuotas = employeeLeaveQuotas;
    }




}


