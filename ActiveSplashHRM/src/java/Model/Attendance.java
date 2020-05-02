package Model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="attendance")
public class Attendance  implements java.io.Serializable {


     private int attendanceId;
     private int employeeId;
     private Date punchinTime;
     private Date punchoutTime;
     private String inNote;
     private String outNote;
     private int timestampDiff;
     private String status;

    public Attendance() {
    }

	
    public Attendance(int attendanceId, int employeeId, int timestampDiff) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.timestampDiff = timestampDiff;
    }
    public Attendance(int attendanceId, int employeeId, Date punchinTime, Date punchoutTime, String inNote, String outNote, int timestampDiff, String status) {
       this.attendanceId = attendanceId;
       this.employeeId = employeeId;
       this.punchinTime = punchinTime;
       this.punchoutTime = punchoutTime;
       this.inNote = inNote;
       this.outNote = outNote;
       this.timestampDiff = timestampDiff;
       this.status = status;
    }
   
     @Id 
    
    @Column(name="attendanceId", unique=true, nullable=false)
    public int getAttendanceId() {
        return this.attendanceId;
    }
    
    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }
    
    @Column(name="employeeId", nullable=false)
    public int getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="punchinTime", length=19)
    public Date getPunchinTime() {
        return this.punchinTime;
    }
    
    public void setPunchinTime(Date punchinTime) {
        this.punchinTime = punchinTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="punchoutTime", length=19)
    public Date getPunchoutTime() {
        return this.punchoutTime;
    }
    
    public void setPunchoutTime(Date punchoutTime) {
        this.punchoutTime = punchoutTime;
    }
    
    @Column(name="inNote", length=250)
    public String getInNote() {
        return this.inNote;
    }
    
    public void setInNote(String inNote) {
        this.inNote = inNote;
    }
    
    @Column(name="outNote", length=250)
    public String getOutNote() {
        return this.outNote;
    }
    
    public void setOutNote(String outNote) {
        this.outNote = outNote;
    }
    
    @Column(name="timestampDiff", nullable=false)
    public int getTimestampDiff() {
        return this.timestampDiff;
    }
    
    public void setTimestampDiff(int timestampDiff) {
        this.timestampDiff = timestampDiff;
    }
    
    @Column(name="status", length=2)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


