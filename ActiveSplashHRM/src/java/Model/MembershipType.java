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
 * MembershipType generated by hbm2java
 */
@Entity
@Table(name="membership_type"
    ,catalog="ashrm"
)
public class MembershipType  implements java.io.Serializable {


     private String membtypeCode;
     private String membtypeName;
     private Set<Membership> memberships = new HashSet<Membership>(0);
     private Set<EmpMemberDetail> empMemberDetails = new HashSet<EmpMemberDetail>(0);

    public MembershipType() {
    }

	
    public MembershipType(String membtypeCode) {
        this.membtypeCode = membtypeCode;
    }
    public MembershipType(String membtypeCode, String membtypeName, Set<Membership> memberships, Set<EmpMemberDetail> empMemberDetails) {
       this.membtypeCode = membtypeCode;
       this.membtypeName = membtypeName;
       this.memberships = memberships;
       this.empMemberDetails = empMemberDetails;
    }
   
     @Id 
    
    @Column(name="membtype_code", unique=true, nullable=false, length=13)
    public String getMembtypeCode() {
        return this.membtypeCode;
    }
    
    public void setMembtypeCode(String membtypeCode) {
        this.membtypeCode = membtypeCode;
    }
    
    @Column(name="membtype_name", length=120)
    public String getMembtypeName() {
        return this.membtypeName;
    }
    
    public void setMembtypeName(String membtypeName) {
        this.membtypeName = membtypeName;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="membershipType")
    public Set<Membership> getMemberships() {
        return this.memberships;
    }
    
    public void setMemberships(Set<Membership> memberships) {
        this.memberships = memberships;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="membershipType")
    public Set<EmpMemberDetail> getEmpMemberDetails() {
        return this.empMemberDetails;
    }
    
    public void setEmpMemberDetails(Set<EmpMemberDetail> empMemberDetails) {
        this.empMemberDetails = empMemberDetails;
    }




}


