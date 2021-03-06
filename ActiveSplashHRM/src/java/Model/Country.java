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
 * Country generated by hbm2java
 */
@Entity
@Table(name="country"
    ,catalog="ashrm"
)
public class Country  implements java.io.Serializable {


     private String couCode;
     private String name;
     private String couName;
     private String iso3;
     private Short numcode;
     private Set<Location> locations = new HashSet<Location>(0);

    public Country() {
    }

	
    public Country(String couCode, String name, String couName) {
        this.couCode = couCode;
        this.name = name;
        this.couName = couName;
    }
    public Country(String couCode, String name, String couName, String iso3, Short numcode, Set<Location> locations) {
       this.couCode = couCode;
       this.name = name;
       this.couName = couName;
       this.iso3 = iso3;
       this.numcode = numcode;
       this.locations = locations;
    }
   
     @Id 
    
    @Column(name="cou_code", unique=true, nullable=false, length=2)
    public String getCouCode() {
        return this.couCode;
    }
    
    public void setCouCode(String couCode) {
        this.couCode = couCode;
    }
    
    @Column(name="name", nullable=false, length=80)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="couName", nullable=false, length=80)
    public String getCouName() {
        return this.couName;
    }
    
    public void setCouName(String couName) {
        this.couName = couName;
    }
    
    @Column(name="iso3", length=3)
    public String getIso3() {
        return this.iso3;
    }
    
    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }
    
    @Column(name="numcode")
    public Short getNumcode() {
        return this.numcode;
    }
    
    public void setNumcode(Short numcode) {
        this.numcode = numcode;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="country")
    public Set<Location> getLocations() {
        return this.locations;
    }
    
    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }




}


