package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PayPeriod generated by hbm2java
 */
@Entity
@Table(name="pay_period"
    ,catalog="ashrm"
)
public class PayPeriod  implements java.io.Serializable {


     private int id;
     private Date startDate;
     private Date endDate;
     private Date closeDate;
     private Date checkDate;
     private Date timesheetAprovalDueDate;

    public PayPeriod() {
    }

    public PayPeriod(int id, Date startDate, Date endDate, Date closeDate, Date checkDate, Date timesheetAprovalDueDate) {
       this.id = id;
       this.startDate = startDate;
       this.endDate = endDate;
       this.closeDate = closeDate;
       this.checkDate = checkDate;
       this.timesheetAprovalDueDate = timesheetAprovalDueDate;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="start_date", nullable=false, length=10)
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="end_date", nullable=false, length=10)
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="close_date", nullable=false, length=10)
    public Date getCloseDate() {
        return this.closeDate;
    }
    
    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="check_date", nullable=false, length=10)
    public Date getCheckDate() {
        return this.checkDate;
    }
    
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="timesheet_aproval_due_date", nullable=false, length=10)
    public Date getTimesheetAprovalDueDate() {
        return this.timesheetAprovalDueDate;
    }
    
    public void setTimesheetAprovalDueDate(Date timesheetAprovalDueDate) {
        this.timesheetAprovalDueDate = timesheetAprovalDueDate;
    }




}

