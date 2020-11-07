package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TimesheetId generated by hbm2java
 */
@Embeddable
public class TimesheetId  implements java.io.Serializable {


     private int timesheetId;
     private int employeeId;
     private int timesheetPeriodId;

    public TimesheetId() {
    }

    public TimesheetId(int timesheetId, int employeeId, int timesheetPeriodId) {
       this.timesheetId = timesheetId;
       this.employeeId = employeeId;
       this.timesheetPeriodId = timesheetPeriodId;
    }
   

    @Column(name="timesheet_id", nullable=false)
    public int getTimesheetId() {
        return this.timesheetId;
    }
    
    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
    }

    @Column(name="employee_id", nullable=false)
    public int getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name="timesheet_period_id", nullable=false)
    public int getTimesheetPeriodId() {
        return this.timesheetPeriodId;
    }
    
    public void setTimesheetPeriodId(int timesheetPeriodId) {
        this.timesheetPeriodId = timesheetPeriodId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TimesheetId) ) return false;
		 TimesheetId castOther = ( TimesheetId ) other; 
         
		 return (this.getTimesheetId()==castOther.getTimesheetId())
 && (this.getEmployeeId()==castOther.getEmployeeId())
 && (this.getTimesheetPeriodId()==castOther.getTimesheetPeriodId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getTimesheetId();
         result = 37 * result + this.getEmployeeId();
         result = 37 * result + this.getTimesheetPeriodId();
         return result;
   }   


}

