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
 * TimeEvent generated by hbm2java
 */
@Entity
@Table(name="time_event"
    ,catalog="ashrm"
)
public class TimeEvent  implements java.io.Serializable {


     private TimeEventId id;
     private Timesheet timesheet;
     private Employee employee;
     private Project project;
     private ProjectActivity projectActivity;
     private Date startTime;
     private Date endTime;
     private Date reportedDate;
     private Integer duration;
     private String description;

    public TimeEvent() {
    }

	
    public TimeEvent(TimeEventId id, Timesheet timesheet, Employee employee, Project project, ProjectActivity projectActivity) {
        this.id = id;
        this.timesheet = timesheet;
        this.employee = employee;
        this.project = project;
        this.projectActivity = projectActivity;
    }
    public TimeEvent(TimeEventId id, Timesheet timesheet, Employee employee, Project project, ProjectActivity projectActivity, Date startTime, Date endTime, Date reportedDate, Integer duration, String description) {
       this.id = id;
       this.timesheet = timesheet;
       this.employee = employee;
       this.project = project;
       this.projectActivity = projectActivity;
       this.startTime = startTime;
       this.endTime = endTime;
       this.reportedDate = reportedDate;
       this.duration = duration;
       this.description = description;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="timeEventId", column=@Column(name="time_event_id", nullable=false) ), 
        @AttributeOverride(name="projectId", column=@Column(name="project_id", nullable=false) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="employee_id", nullable=false) ), 
        @AttributeOverride(name="timesheetId", column=@Column(name="timesheet_id", nullable=false) ) } )
    public TimeEventId getId() {
        return this.id;
    }
    
    public void setId(TimeEventId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="timesheet_id", nullable=false, insertable=false, updatable=false)
    public Timesheet getTimesheet() {
        return this.timesheet;
    }
    
    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id", nullable=false, insertable=false, updatable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id", nullable=false, insertable=false, updatable=false)
    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="activity_id", nullable=false)
    public ProjectActivity getProjectActivity() {
        return this.projectActivity;
    }
    
    public void setProjectActivity(ProjectActivity projectActivity) {
        this.projectActivity = projectActivity;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_time", length=19)
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_time", length=19)
    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="reported_date", length=19)
    public Date getReportedDate() {
        return this.reportedDate;
    }
    
    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }
    
    @Column(name="duration")
    public Integer getDuration() {
        return this.duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    @Column(name="description", length=250)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


