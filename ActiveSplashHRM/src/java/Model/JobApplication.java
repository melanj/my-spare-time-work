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

/**
 * JobApplication generated by hbm2java
 */
@Entity
@Table(name="job_application"
    ,catalog="ashrm"
)
public class JobApplication  implements java.io.Serializable {


     private int applicationId;
     private JobVacancy jobVacancy;
     private String lastname;
     private String firstname;
     private String middlename;
     private String street1;
     private String street2;
     private String city;
     private String countryCode;
     private String province;
     private String zip;
     private String phone;
     private String mobile;
     private String email;
     private String qualifications;
     private Short status;
     private Date appliedDatetime;
     private Integer empNumber;
     private String resumeName;
     private byte[] resumeData;
     private Set<JobApplicationEvents> jobApplicationEventses = new HashSet<JobApplicationEvents>(0);

    public JobApplication() {
    }

	
    public JobApplication(int applicationId, JobVacancy jobVacancy, String lastname, String firstname, String middlename) {
        this.applicationId = applicationId;
        this.jobVacancy = jobVacancy;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
    }
    public JobApplication(int applicationId, JobVacancy jobVacancy, String lastname, String firstname, String middlename, String street1, String street2, String city, String countryCode, String province, String zip, String phone, String mobile, String email, String qualifications, Short status, Date appliedDatetime, Integer empNumber, String resumeName, byte[] resumeData, Set<JobApplicationEvents> jobApplicationEventses) {
       this.applicationId = applicationId;
       this.jobVacancy = jobVacancy;
       this.lastname = lastname;
       this.firstname = firstname;
       this.middlename = middlename;
       this.street1 = street1;
       this.street2 = street2;
       this.city = city;
       this.countryCode = countryCode;
       this.province = province;
       this.zip = zip;
       this.phone = phone;
       this.mobile = mobile;
       this.email = email;
       this.qualifications = qualifications;
       this.status = status;
       this.appliedDatetime = appliedDatetime;
       this.empNumber = empNumber;
       this.resumeName = resumeName;
       this.resumeData = resumeData;
       this.jobApplicationEventses = jobApplicationEventses;
    }
   
     @Id 
    
    @Column(name="application_id", unique=true, nullable=false)
    public int getApplicationId() {
        return this.applicationId;
    }
    
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vacancy_id", nullable=false)
    public JobVacancy getJobVacancy() {
        return this.jobVacancy;
    }
    
    public void setJobVacancy(JobVacancy jobVacancy) {
        this.jobVacancy = jobVacancy;
    }
    
    @Column(name="lastname", nullable=false, length=100)
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    @Column(name="firstname", nullable=false, length=100)
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    @Column(name="middlename", nullable=false, length=100)
    public String getMiddlename() {
        return this.middlename;
    }
    
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }
    
    @Column(name="street1", length=100)
    public String getStreet1() {
        return this.street1;
    }
    
    public void setStreet1(String street1) {
        this.street1 = street1;
    }
    
    @Column(name="street2", length=100)
    public String getStreet2() {
        return this.street2;
    }
    
    public void setStreet2(String street2) {
        this.street2 = street2;
    }
    
    @Column(name="city", length=100)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Column(name="country_code", length=100)
    public String getCountryCode() {
        return this.countryCode;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    @Column(name="province", length=100)
    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    @Column(name="zip", length=20)
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    @Column(name="phone", length=50)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Column(name="mobile", length=50)
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Column(name="email", length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="qualifications", length=65535)
    public String getQualifications() {
        return this.qualifications;
    }
    
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
    
    @Column(name="status")
    public Short getStatus() {
        return this.status;
    }
    
    public void setStatus(Short status) {
        this.status = status;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="applied_datetime", length=19)
    public Date getAppliedDatetime() {
        return this.appliedDatetime;
    }
    
    public void setAppliedDatetime(Date appliedDatetime) {
        this.appliedDatetime = appliedDatetime;
    }
    
    @Column(name="emp_number")
    public Integer getEmpNumber() {
        return this.empNumber;
    }
    
    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }
    
    @Column(name="resume_name", length=100)
    public String getResumeName() {
        return this.resumeName;
    }
    
    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }
    
    @Column(name="resume_data")
    public byte[] getResumeData() {
        return this.resumeData;
    }
    
    public void setResumeData(byte[] resumeData) {
        this.resumeData = resumeData;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="jobApplication")
    public Set<JobApplicationEvents> getJobApplicationEventses() {
        return this.jobApplicationEventses;
    }
    
    public void setJobApplicationEventses(Set<JobApplicationEvents> jobApplicationEventses) {
        this.jobApplicationEventses = jobApplicationEventses;
    }




}


