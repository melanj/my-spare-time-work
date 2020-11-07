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
import javax.persistence.Version;

/**
 * Module generated by hbm2java
 */
@Entity
@Table(name="module"
    ,catalog="ashrm"
)
public class Module  implements java.io.Serializable {


     private String modId;
     private String version;
     private Versions versions;
     private String name;
     private String owner;
     private String ownerEmail;
     private String description;
     private Set<FileVersion> fileVersions = new HashSet<FileVersion>(0);
     private Set<Rights> rightses = new HashSet<Rights>(0);

    public Module() {
    }

	
    public Module(String modId) {
        this.modId = modId;
    }
    public Module(String modId, Versions versions, String name, String owner, String ownerEmail, String description, Set<FileVersion> fileVersions, Set<Rights> rightses) {
       this.modId = modId;
       this.versions = versions;
       this.name = name;
       this.owner = owner;
       this.ownerEmail = ownerEmail;
       this.description = description;
       this.fileVersions = fileVersions;
       this.rightses = rightses;
    }
   
     @Id 
    
    @Column(name="mod_id", unique=true, nullable=false, length=36)
    public String getModId() {
        return this.modId;
    }
    
    public void setModId(String modId) {
        this.modId = modId;
    }
    @Version
    @Column(name="version", length=36)
    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="version", insertable=false, updatable=false)
    public Versions getVersions() {
        return this.versions;
    }
    
    public void setVersions(Versions versions) {
        this.versions = versions;
    }
    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="owner", length=45)
    public String getOwner() {
        return this.owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    @Column(name="owner_email", length=100)
    public String getOwnerEmail() {
        return this.ownerEmail;
    }
    
    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="module")
    public Set<FileVersion> getFileVersions() {
        return this.fileVersions;
    }
    
    public void setFileVersions(Set<FileVersion> fileVersions) {
        this.fileVersions = fileVersions;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="module")
    public Set<Rights> getRightses() {
        return this.rightses;
    }
    
    public void setRightses(Set<Rights> rightses) {
        this.rightses = rightses;
    }




}

