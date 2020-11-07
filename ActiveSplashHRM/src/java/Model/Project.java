package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Project generated by hbm2java
 */
@Entity
@Table(name="project"
    ,catalog="ashrm"
)
public class Project  implements java.io.Serializable {


     private ProjectId id;
     private Customer customer;
     private String name;
     private String description;
     private Boolean deleted;
     private Set<TimeEvent> timeEvents = new HashSet<TimeEvent>(0);
     private Set<Employee> employees = new HashSet<Employee>(0);
     private Set<ProjectActivity> projectActivities = new HashSet<ProjectActivity>(0);

    public Project() {
    }

	
    public Project(ProjectId id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }
    public Project(ProjectId id, Customer customer, String name, String description, Boolean deleted, Set<TimeEvent> timeEvents, Set<Employee> employees, Set<ProjectActivity> projectActivities) {
       this.id = id;
       this.customer = customer;
       this.name = name;
       this.description = description;
       this.deleted = deleted;
       this.timeEvents = timeEvents;
       this.employees = employees;
       this.projectActivities = projectActivities;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="projectId", column=@Column(name="project_id", nullable=false) ), 
        @AttributeOverride(name="customerId", column=@Column(name="customer_id", nullable=false) ) } )
    public ProjectId getId() {
        return this.id;
    }
    
    public void setId(ProjectId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id", nullable=false, insertable=false, updatable=false)
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="project")
    public Set<TimeEvent> getTimeEvents() {
        return this.timeEvents;
    }
    
    public void setTimeEvents(Set<TimeEvent> timeEvents) {
        this.timeEvents = timeEvents;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="project_admin", catalog="ashrm", joinColumns = { 
        @JoinColumn(name="project_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="emp_number", nullable=false, updatable=false) })
    public Set<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="project")
    public Set<ProjectActivity> getProjectActivities() {
        return this.projectActivities;
    }
    
    public void setProjectActivities(Set<ProjectActivity> projectActivities) {
        this.projectActivities = projectActivities;
    }




}

