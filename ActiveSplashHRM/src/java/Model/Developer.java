package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Developer generated by hbm2java
 */
@Entity
@Table(name="developer"
    ,catalog="ashrm"
)
public class Developer  implements java.io.Serializable {


     private String id;
     private String firstName;
     private String lastName;
     private String reportsToId;
     private String description;
     private String department;

    public Developer() {
    }

	
    public Developer(String id) {
        this.id = id;
    }
    public Developer(String id, String firstName, String lastName, String reportsToId, String description, String department) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.reportsToId = reportsToId;
       this.description = description;
       this.department = department;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false, length=36)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(name="first_name", length=45)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="last_name", length=45)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name="reports_to_id", length=45)
    public String getReportsToId() {
        return this.reportsToId;
    }
    
    public void setReportsToId(String reportsToId) {
        this.reportsToId = reportsToId;
    }
    
    @Column(name="description", length=200)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="department", length=45)
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }




}


