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
 * Customer generated by hbm2java
 */
@Entity
@Table(name="customer"
    ,catalog="ashrm"
)
public class Customer  implements java.io.Serializable {


     private int customerId;
     private String name;
     private String description;
     private Boolean deleted;
     private Set<Project> projects = new HashSet<Project>(0);

    public Customer() {
    }

	
    public Customer(int customerId) {
        this.customerId = customerId;
    }
    public Customer(int customerId, String name, String description, Boolean deleted, Set<Project> projects) {
       this.customerId = customerId;
       this.name = name;
       this.description = description;
       this.deleted = deleted;
       this.projects = projects;
    }
   
     @Id 
    
    @Column(name="customer_id", unique=true, nullable=false)
    public int getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    @Column(name="name", length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="description", length=250)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="deleted")
    public Boolean getDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customer")
    public Set<Project> getProjects() {
        return this.projects;
    }
    
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }




}

