package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TimeEventId generated by hbm2java
 */
@Embeddable
public class TimeEventId  implements java.io.Serializable {


     private int timeEventId;
     private int projectId;
     private int employeeId;
     private int timesheetId;

    public TimeEventId() {
    }

    public TimeEventId(int timeEventId, int projectId, int employeeId, int timesheetId) {
       this.timeEventId = timeEventId;
       this.projectId = projectId;
       this.employeeId = employeeId;
       this.timesheetId = timesheetId;
    }
   

    @Column(name="time_event_id", nullable=false)
    public int getTimeEventId() {
        return this.timeEventId;
    }
    
    public void setTimeEventId(int timeEventId) {
        this.timeEventId = timeEventId;
    }

    @Column(name="project_id", nullable=false)
    public int getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Column(name="employee_id", nullable=false)
    public int getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name="timesheet_id", nullable=false)
    public int getTimesheetId() {
        return this.timesheetId;
    }
    
    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TimeEventId) ) return false;
		 TimeEventId castOther = ( TimeEventId ) other; 
         
		 return (this.getTimeEventId()==castOther.getTimeEventId())
 && (this.getProjectId()==castOther.getProjectId())
 && (this.getEmployeeId()==castOther.getEmployeeId())
 && (this.getTimesheetId()==castOther.getTimesheetId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getTimeEventId();
         result = 37 * result + this.getProjectId();
         result = 37 * result + this.getEmployeeId();
         result = 37 * result + this.getTimesheetId();
         return result;
   }   


}


