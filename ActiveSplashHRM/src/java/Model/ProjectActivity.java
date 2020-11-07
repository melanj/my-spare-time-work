package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProjectActivity generated by hbm2java
 */
@Entity
@Table(name="project_activity"
    ,catalog="ashrm"
)
public class ProjectActivity  implements java.io.Serializable {


     private int activityId;
     private Project project;
     private String name;
     private Boolean deleted;
     private Set<TimeEvent> timeEvents = new HashSet<TimeEvent>(0);

    public ProjectActivity() {
    }

	
    public ProjectActivity(int activityId, Project project) {
        this.activityId = activityId;
        this.project = project;
    }
    public ProjectActivity(int activityId, Project project, String name, Boolean deleted, Set<TimeEvent> timeEvents) {
       this.activityId = activityId;
       this.project = project;
       this.name = name;
       this.deleted = deleted;
       this.timeEvents = timeEvents;
    }
   
     @Id 
    
    @Column(name="activity_id", unique=true, nullable=false)
    public int getActivityId() {
        return this.activityId;
    }
    
    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id", nullable=false)
    public Project getProject() {
        return this.project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    
    @Column(name="name", length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="deleted")
    public Boolean getDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="projectActivity")
    public Set<TimeEvent> getTimeEvents() {
        return this.timeEvents;
    }
    
    public void setTimeEvents(Set<TimeEvent> timeEvents) {
        this.timeEvents = timeEvents;
    }




}

