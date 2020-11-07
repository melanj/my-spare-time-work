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
 * EmpAttachment generated by hbm2java
 */
@Entity
@Table(name="emp_attachment"
    ,catalog="ashrm"
)
public class EmpAttachment  implements java.io.Serializable {


     private EmpAttachmentId id;
     private Employee employee;
     private String eattachDesc;
     private String eattachFilename;
     private Integer eattachSize;
     private byte[] eattachAttachment;
     private String eattachType;

    public EmpAttachment() {
    }

	
    public EmpAttachment(EmpAttachmentId id, Employee employee) {
        this.id = id;
        this.employee = employee;
    }
    public EmpAttachment(EmpAttachmentId id, Employee employee, String eattachDesc, String eattachFilename, Integer eattachSize, byte[] eattachAttachment, String eattachType) {
       this.id = id;
       this.employee = employee;
       this.eattachDesc = eattachDesc;
       this.eattachFilename = eattachFilename;
       this.eattachSize = eattachSize;
       this.eattachAttachment = eattachAttachment;
       this.eattachType = eattachType;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="empNumber", column=@Column(name="emp_number", nullable=false) ), 
        @AttributeOverride(name="eattachId", column=@Column(name="eattach_id", nullable=false, precision=10, scale=0) ) } )
    public EmpAttachmentId getId() {
        return this.id;
    }
    
    public void setId(EmpAttachmentId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emp_number", nullable=false, insertable=false, updatable=false)
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    @Column(name="eattach_desc", length=200)
    public String getEattachDesc() {
        return this.eattachDesc;
    }
    
    public void setEattachDesc(String eattachDesc) {
        this.eattachDesc = eattachDesc;
    }
    
    @Column(name="eattach_filename", length=100)
    public String getEattachFilename() {
        return this.eattachFilename;
    }
    
    public void setEattachFilename(String eattachFilename) {
        this.eattachFilename = eattachFilename;
    }
    
    @Column(name="eattach_size")
    public Integer getEattachSize() {
        return this.eattachSize;
    }
    
    public void setEattachSize(Integer eattachSize) {
        this.eattachSize = eattachSize;
    }
    
    @Column(name="eattach_attachment")
    public byte[] getEattachAttachment() {
        return this.eattachAttachment;
    }
    
    public void setEattachAttachment(byte[] eattachAttachment) {
        this.eattachAttachment = eattachAttachment;
    }
    
    @Column(name="eattach_type", length=50)
    public String getEattachType() {
        return this.eattachType;
    }
    
    public void setEattachType(String eattachType) {
        this.eattachType = eattachType;
    }




}

