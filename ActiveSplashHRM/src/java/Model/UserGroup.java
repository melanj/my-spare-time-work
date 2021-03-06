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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UserGroup generated by hbm2java
 */
@Entity
@Table(name="user_group"
    ,catalog="ashrm"
)
public class UserGroup  implements java.io.Serializable {


     private String usergId;
     private String usergName;
     private Short usergRepdef;
     private Set<Empreport> empreports = new HashSet<Empreport>(0);
     private Set<Users> userses = new HashSet<Users>(0);
     private Set<Rights> rightses = new HashSet<Rights>(0);

    public UserGroup() {
    }

	
    public UserGroup(String usergId) {
        this.usergId = usergId;
    }
    public UserGroup(String usergId, String usergName, Short usergRepdef, Set<Empreport> empreports, Set<Users> userses, Set<Rights> rightses) {
       this.usergId = usergId;
       this.usergName = usergName;
       this.usergRepdef = usergRepdef;
       this.empreports = empreports;
       this.userses = userses;
       this.rightses = rightses;
    }
   
     @Id 
    
    @Column(name="userg_id", unique=true, nullable=false, length=36)
    public String getUsergId() {
        return this.usergId;
    }
    
    public void setUsergId(String usergId) {
        this.usergId = usergId;
    }
    
    @Column(name="userg_name", length=45)
    public String getUsergName() {
        return this.usergName;
    }
    
    public void setUsergName(String usergName) {
        this.usergName = usergName;
    }
    
    @Column(name="userg_repdef")
    public Short getUsergRepdef() {
        return this.usergRepdef;
    }
    
    public void setUsergRepdef(Short usergRepdef) {
        this.usergRepdef = usergRepdef;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="emprep_usergroup", catalog="ashrm", joinColumns = { 
        @JoinColumn(name="userg_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="rep_code", nullable=false, updatable=false) })
    public Set<Empreport> getEmpreports() {
        return this.empreports;
    }
    
    public void setEmpreports(Set<Empreport> empreports) {
        this.empreports = empreports;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userGroup")
    public Set<Users> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userGroup")
    public Set<Rights> getRightses() {
        return this.rightses;
    }
    
    public void setRightses(Set<Rights> rightses) {
        this.rightses = rightses;
    }




}


