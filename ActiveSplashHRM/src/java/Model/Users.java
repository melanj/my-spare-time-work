package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users"
    ,catalog="ashrm"
    , uniqueConstraints = @UniqueConstraint(columnNames="user_name") 
)
public class Users  implements java.io.Serializable {


     private String id;
     private Users usersByCreatedBy;
     private Users usersByModifiedUserId;
     private Employee employee;
     private UserGroup userGroup;
     private String userName;
     private String userPassword;
     private String firstName;
     private String lastName;
     private String userHash;
     private String isAdmin;
     private Character receiveNotification;
     private String description;
     private Date dateEntered;
     private Date dateModified;
     private String title;
     private String department;
     private String phoneHome;
     private String phoneMobile;
     private String phoneWork;
     private String phoneOther;
     private String phoneFax;
     private String email1;
     private String email2;
     private String status;
     private String addressStreet;
     private String addressCity;
     private String addressState;
     private String addressCountry;
     private String addressPostalcode;
     private String userPreferences;
     private boolean deleted;
     private String employeeStatus;
     private Set<FileVersion> fileVersionsForEnteredBy = new HashSet<FileVersion>(0);
     private Set<Versions> versionsesForModifiedBy = new HashSet<Versions>(0);
     private Set<Versions> versionsesForCreatedBy = new HashSet<Versions>(0);
     private Set<JobApplicationEvents> jobApplicationEventses = new HashSet<JobApplicationEvents>(0);
     private Set<FileVersion> fileVersionsForModifiedBy = new HashSet<FileVersion>(0);
     private Set<Users> usersesForCreatedBy = new HashSet<Users>(0);
     private Set<Users> usersesForModifiedUserId = new HashSet<Users>(0);
     private Set<DbVersion> dbVersionsForEnteredBy = new HashSet<DbVersion>(0);
     private Set<DbVersion> dbVersionsForModifiedBy = new HashSet<DbVersion>(0);

    public Users() {
    }

	
    public Users(String id, boolean deleted) {
        this.id = id;
        this.deleted = deleted;
    }
    public Users(String id, Users usersByCreatedBy, Users usersByModifiedUserId, Employee employee, UserGroup userGroup, String userName, String userPassword, String firstName, String lastName, String userHash, String isAdmin, Character receiveNotification, String description, Date dateEntered, Date dateModified, String title, String department, String phoneHome, String phoneMobile, String phoneWork, String phoneOther, String phoneFax, String email1, String email2, String status, String addressStreet, String addressCity, String addressState, String addressCountry, String addressPostalcode, String userPreferences, boolean deleted, String employeeStatus, Set<FileVersion> fileVersionsForEnteredBy, Set<Versions> versionsesForModifiedBy, Set<Versions> versionsesForCreatedBy, Set<JobApplicationEvents> jobApplicationEventses, Set<FileVersion> fileVersionsForModifiedBy, Set<Users> usersesForCreatedBy, Set<Users> usersesForModifiedUserId, Set<DbVersion> dbVersionsForEnteredBy, Set<DbVersion> dbVersionsForModifiedBy) {
       this.id = id;
       this.usersByCreatedBy = usersByCreatedBy;
       this.usersByModifiedUserId = usersByModifiedUserId;
       this.employee = employee;
       this.userGroup = userGroup;
       this.userName = userName;
       this.userPassword = userPassword;
       this.firstName = firstName;
       this.lastName = lastName;
       this.userHash = userHash;
       this.isAdmin = isAdmin;
       this.receiveNotification = receiveNotification;
       this.description = description;
       this.dateEntered = dateEntered;
       this.dateModified = dateModified;
       this.title = title;
       this.department = department;
       this.phoneHome = phoneHome;
       this.phoneMobile = phoneMobile;
       this.phoneWork = phoneWork;
       this.phoneOther = phoneOther;
       this.phoneFax = phoneFax;
       this.email1 = email1;
       this.email2 = email2;
       this.status = status;
       this.addressStreet = addressStreet;
       this.addressCity = addressCity;
       this.addressState = addressState;
       this.addressCountry = addressCountry;
       this.addressPostalcode = addressPostalcode;
       this.userPreferences = userPreferences;
       this.deleted = deleted;
       this.employeeStatus = employeeStatus;
       this.fileVersionsForEnteredBy = fileVersionsForEnteredBy;
       this.versionsesForModifiedBy = versionsesForModifiedBy;
       this.versionsesForCreatedBy = versionsesForCreatedBy;
       this.jobApplicationEventses = jobApplicationEventses;
       this.fileVersionsForModifiedBy = fileVersionsForModifiedBy;
       this.usersesForCreatedBy = usersesForCreatedBy;
       this.usersesForModifiedUserId = usersesForModifiedUserId;
       this.dbVersionsForEnteredBy = dbVersionsForEnteredBy;
       this.dbVersionsForModifiedBy = dbVersionsForModifiedBy;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false, length=36)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="created_by")
    public Users getUsersByCreatedBy() {
        return this.usersByCreatedBy;
    }
    
    public void setUsersByCreatedBy(Users usersByCreatedBy) {
        this.usersByCreatedBy = usersByCreatedBy;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="modified_user_id")
    public Users getUsersByModifiedUserId() {
        return this.usersByModifiedUserId;
    }
    
    public void setUsersByModifiedUserId(Users usersByModifiedUserId) {
        this.usersByModifiedUserId = usersByModifiedUserId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emp_number")
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userg_id")
    public UserGroup getUserGroup() {
        return this.userGroup;
    }
    
    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
    
    @Column(name="user_name", unique=true, length=40)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="user_password", length=40)
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
    
    @Column(name="user_hash", length=32)
    public String getUserHash() {
        return this.userHash;
    }
    
    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }
    
    @Column(name="is_admin", length=3)
    public String getIsAdmin() {
        return this.isAdmin;
    }
    
    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    @Column(name="receive_notification", length=1)
    public Character getReceiveNotification() {
        return this.receiveNotification;
    }
    
    public void setReceiveNotification(Character receiveNotification) {
        this.receiveNotification = receiveNotification;
    }
    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_entered", length=19)
    public Date getDateEntered() {
        return this.dateEntered;
    }
    
    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_modified", length=19)
    public Date getDateModified() {
        return this.dateModified;
    }
    
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
    
    @Column(name="title", length=50)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="department", length=50)
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Column(name="phone_home", length=45)
    public String getPhoneHome() {
        return this.phoneHome;
    }
    
    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }
    
    @Column(name="phone_mobile", length=45)
    public String getPhoneMobile() {
        return this.phoneMobile;
    }
    
    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }
    
    @Column(name="phone_work", length=45)
    public String getPhoneWork() {
        return this.phoneWork;
    }
    
    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }
    
    @Column(name="phone_other", length=45)
    public String getPhoneOther() {
        return this.phoneOther;
    }
    
    public void setPhoneOther(String phoneOther) {
        this.phoneOther = phoneOther;
    }
    
    @Column(name="phone_fax", length=45)
    public String getPhoneFax() {
        return this.phoneFax;
    }
    
    public void setPhoneFax(String phoneFax) {
        this.phoneFax = phoneFax;
    }
    
    @Column(name="email1", length=100)
    public String getEmail1() {
        return this.email1;
    }
    
    public void setEmail1(String email1) {
        this.email1 = email1;
    }
    
    @Column(name="email2", length=100)
    public String getEmail2() {
        return this.email2;
    }
    
    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    
    @Column(name="status", length=25)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="address_street", length=150)
    public String getAddressStreet() {
        return this.addressStreet;
    }
    
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }
    
    @Column(name="address_city", length=150)
    public String getAddressCity() {
        return this.addressCity;
    }
    
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
    
    @Column(name="address_state", length=100)
    public String getAddressState() {
        return this.addressState;
    }
    
    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }
    
    @Column(name="address_country", length=25)
    public String getAddressCountry() {
        return this.addressCountry;
    }
    
    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }
    
    @Column(name="address_postalcode", length=10)
    public String getAddressPostalcode() {
        return this.addressPostalcode;
    }
    
    public void setAddressPostalcode(String addressPostalcode) {
        this.addressPostalcode = addressPostalcode;
    }
    
    @Column(name="user_preferences", length=65535)
    public String getUserPreferences() {
        return this.userPreferences;
    }
    
    public void setUserPreferences(String userPreferences) {
        this.userPreferences = userPreferences;
    }
    
    @Column(name="deleted", nullable=false)
    public boolean isDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    @Column(name="employee_status", length=25)
    public String getEmployeeStatus() {
        return this.employeeStatus;
    }
    
    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usersByEnteredBy")
    public Set<FileVersion> getFileVersionsForEnteredBy() {
        return this.fileVersionsForEnteredBy;
    }
    
    public void setFileVersionsForEnteredBy(Set<FileVersion> fileVersionsForEnteredBy) {
        this.fileVersionsForEnteredBy = fileVersionsForEnteredBy;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usersByModifiedBy")
    public Set<Versions> getVersionsesForModifiedBy() {
        return this.versionsesForModifiedBy;
    }
    
    public void setVersionsesForModifiedBy(Set<Versions> versionsesForModifiedBy) {
        this.versionsesForModifiedBy = versionsesForModifiedBy;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usersByCreatedBy")
    public Set<Versions> getVersionsesForCreatedBy() {
        return this.versionsesForCreatedBy;
    }
    
    public void setVersionsesForCreatedBy(Set<Versions> versionsesForCreatedBy) {
        this.versionsesForCreatedBy = versionsesForCreatedBy;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="users")
    public Set<JobApplicationEvents> getJobApplicationEventses() {
        return this.jobApplicationEventses;
    }
    
    public void setJobApplicationEventses(Set<JobApplicationEvents> jobApplicationEventses) {
        this.jobApplicationEventses = jobApplicationEventses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usersByModifiedBy")
    public Set<FileVersion> getFileVersionsForModifiedBy() {
        return this.fileVersionsForModifiedBy;
    }
    
    public void setFileVersionsForModifiedBy(Set<FileVersion> fileVersionsForModifiedBy) {
        this.fileVersionsForModifiedBy = fileVersionsForModifiedBy;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usersByCreatedBy")
    public Set<Users> getUsersesForCreatedBy() {
        return this.usersesForCreatedBy;
    }
    
    public void setUsersesForCreatedBy(Set<Users> usersesForCreatedBy) {
        this.usersesForCreatedBy = usersesForCreatedBy;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usersByModifiedUserId")
    public Set<Users> getUsersesForModifiedUserId() {
        return this.usersesForModifiedUserId;
    }
    
    public void setUsersesForModifiedUserId(Set<Users> usersesForModifiedUserId) {
        this.usersesForModifiedUserId = usersesForModifiedUserId;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usersByEnteredBy")
    public Set<DbVersion> getDbVersionsForEnteredBy() {
        return this.dbVersionsForEnteredBy;
    }
    
    public void setDbVersionsForEnteredBy(Set<DbVersion> dbVersionsForEnteredBy) {
        this.dbVersionsForEnteredBy = dbVersionsForEnteredBy;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usersByModifiedBy")
    public Set<DbVersion> getDbVersionsForModifiedBy() {
        return this.dbVersionsForModifiedBy;
    }
    
    public void setDbVersionsForModifiedBy(Set<DbVersion> dbVersionsForModifiedBy) {
        this.dbVersionsForModifiedBy = dbVersionsForModifiedBy;
    }




}


