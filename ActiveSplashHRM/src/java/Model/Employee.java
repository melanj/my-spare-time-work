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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name="employee"
    ,catalog="ashrm"
    , uniqueConstraints = @UniqueConstraint(columnNames="employee_id") 
)
public class Employee  implements java.io.Serializable {


     private int empNumber;
     private Eec eec;
     private EthnicRace ethnicRace;
     private Nationality nationality;
     private Empstat empstat;
     private Compstructtree compstructtree;
     private JobTitle jobTitle;
     private String employeeId;
     private String empLastname;
     private String empFirstname;
     private String empMiddleName;
     private String empNickName;
     private Short empSmoker;
     private Date empBirthday;
     private Short empGender;
     private String empMaritalStatus;
     private String empSsnNum;
     private String empSinNum;
     private String empOtherId;
     private String empDriLiceNum;
     private Date empDriLiceExpDate;
     private String empMilitaryService;
     private String empStreet1;
     private String empStreet2;
     private String cityCode;
     private String counCode;
     private String provinCode;
     private String empZipcode;
     private String empHmTelephone;
     private String empMobile;
     private String empWorkTelephone;
     private String empWorkEmail;
     private String salGrdCode;
     private Date joinedDate;
     private String empOthEmail;
     private Date terminatedDate;
     private String terminationReason;
     private String custom1;
     private String custom2;
     private String custom3;
     private String custom4;
     private String custom5;
     private String custom6;
     private String custom7;
     private String custom8;
     private String custom9;
     private String custom10;
     private Set<EmpEmergencyContacts> empEmergencyContactses = new HashSet<EmpEmergencyContacts>(0);
     private Set<EmpContractExtend> empContractExtends = new HashSet<EmpContractExtend>(0);
     private Set<EmpDirectdebit> empDirectdebits = new HashSet<EmpDirectdebit>(0);
     private Set<EmpLocationHistory> empLocationHistories = new HashSet<EmpLocationHistory>(0);
     private Set<EmpDependents> empDependentses = new HashSet<EmpDependents>(0);
     private Set<EmpLicenses> empLicenseses = new HashSet<EmpLicenses>(0);
     private Set<EmpMemberDetail> empMemberDetails = new HashSet<EmpMemberDetail>(0);
     private Set<JobVacancy> jobVacancies = new HashSet<JobVacancy>(0);
     private Set<Timesheet> timesheets = new HashSet<Timesheet>(0);
     private Set<EmpReportto> empReporttosForErepSupEmpNumber = new HashSet<EmpReportto>(0);
     private Set<EmpReportto> empReporttosForErepSubEmpNumber = new HashSet<EmpReportto>(0);
     private Set<EmpBasicsalary> empBasicsalaries = new HashSet<EmpBasicsalary>(0);
     private Set<JobApplicationEvents> jobApplicationEventses = new HashSet<JobApplicationEvents>(0);
     private Set<EmpChildren> empChildrens = new HashSet<EmpChildren>(0);
     private Set<EmpSubdivisionHistory> empSubdivisionHistories = new HashSet<EmpSubdivisionHistory>(0);
     private Set<TimesheetSubmissionPeriod> timesheetSubmissionPeriods = new HashSet<TimesheetSubmissionPeriod>(0);
     private Set<EmpPicture> empPictures = new HashSet<EmpPicture>(0);
     private Set<HspPaymentRequest> hspPaymentRequests = new HashSet<HspPaymentRequest>(0);
     private Set<Project> projects = new HashSet<Project>(0);
     private Set<Hsp> hsps = new HashSet<Hsp>(0);
     private Set<EmpJobtitleHistory> empJobtitleHistories = new HashSet<EmpJobtitleHistory>(0);
     private Set<EmployeeLeaveQuota> employeeLeaveQuotas = new HashSet<EmployeeLeaveQuota>(0);
     private Set<TimeEvent> timeEvents = new HashSet<TimeEvent>(0);
     private Set<EmpLanguage> empLanguages = new HashSet<EmpLanguage>(0);
     private Set<EmpPassport> empPassports = new HashSet<EmpPassport>(0);
     private Set<Location> locations = new HashSet<Location>(0);
     private Set<Users> userses = new HashSet<Users>(0);
     private Set<EmpHistoryOfEalierPos> empHistoryOfEalierPoses = new HashSet<EmpHistoryOfEalierPos>(0);
     private Set<EmpWorkExperience> empWorkExperiences = new HashSet<EmpWorkExperience>(0);
     private Set<EmpEducation> empEducations = new HashSet<EmpEducation>(0);
     private Set<Workshift> workshifts = new HashSet<Workshift>(0);
     private Set<LeaveRequests> leaveRequestses = new HashSet<LeaveRequests>(0);
     private Set<EmpUsTax> empUsTaxes = new HashSet<EmpUsTax>(0);
     private Set<EmpAttachment> empAttachments = new HashSet<EmpAttachment>(0);

    public Employee() {
    }

	
    public Employee(int empNumber, String empLastname, String empFirstname, String empMiddleName) {
        this.empNumber = empNumber;
        this.empLastname = empLastname;
        this.empFirstname = empFirstname;
        this.empMiddleName = empMiddleName;
    }
    public Employee(int empNumber, Eec eec, EthnicRace ethnicRace, Nationality nationality, Empstat empstat, Compstructtree compstructtree, JobTitle jobTitle, String employeeId, String empLastname, String empFirstname, String empMiddleName, String empNickName, Short empSmoker, Date empBirthday, Short empGender, String empMaritalStatus, String empSsnNum, String empSinNum, String empOtherId, String empDriLiceNum, Date empDriLiceExpDate, String empMilitaryService, String empStreet1, String empStreet2, String cityCode, String counCode, String provinCode, String empZipcode, String empHmTelephone, String empMobile, String empWorkTelephone, String empWorkEmail, String salGrdCode, Date joinedDate, String empOthEmail, Date terminatedDate, String terminationReason, String custom1, String custom2, String custom3, String custom4, String custom5, String custom6, String custom7, String custom8, String custom9, String custom10, Set<EmpEmergencyContacts> empEmergencyContactses, Set<EmpContractExtend> empContractExtends, Set<EmpDirectdebit> empDirectdebits, Set<EmpLocationHistory> empLocationHistories, Set<EmpDependents> empDependentses, Set<EmpLicenses> empLicenseses, Set<EmpMemberDetail> empMemberDetails, Set<JobVacancy> jobVacancies, Set<Timesheet> timesheets, Set<EmpReportto> empReporttosForErepSupEmpNumber, Set<EmpReportto> empReporttosForErepSubEmpNumber, Set<EmpBasicsalary> empBasicsalaries, Set<JobApplicationEvents> jobApplicationEventses, Set<EmpChildren> empChildrens, Set<EmpSubdivisionHistory> empSubdivisionHistories, Set<TimesheetSubmissionPeriod> timesheetSubmissionPeriods, Set<EmpPicture> empPictures, Set<HspPaymentRequest> hspPaymentRequests, Set<Project> projects, Set<Hsp> hsps, Set<EmpJobtitleHistory> empJobtitleHistories, Set<EmployeeLeaveQuota> employeeLeaveQuotas, Set<TimeEvent> timeEvents, Set<EmpLanguage> empLanguages, Set<EmpPassport> empPassports, Set<Location> locations, Set<Users> userses, Set<EmpHistoryOfEalierPos> empHistoryOfEalierPoses, Set<EmpWorkExperience> empWorkExperiences, Set<EmpEducation> empEducations, Set<Workshift> workshifts, Set<LeaveRequests> leaveRequestses, Set<EmpUsTax> empUsTaxes, Set<EmpAttachment> empAttachments) {
       this.empNumber = empNumber;
       this.eec = eec;
       this.ethnicRace = ethnicRace;
       this.nationality = nationality;
       this.empstat = empstat;
       this.compstructtree = compstructtree;
       this.jobTitle = jobTitle;
       this.employeeId = employeeId;
       this.empLastname = empLastname;
       this.empFirstname = empFirstname;
       this.empMiddleName = empMiddleName;
       this.empNickName = empNickName;
       this.empSmoker = empSmoker;
       this.empBirthday = empBirthday;
       this.empGender = empGender;
       this.empMaritalStatus = empMaritalStatus;
       this.empSsnNum = empSsnNum;
       this.empSinNum = empSinNum;
       this.empOtherId = empOtherId;
       this.empDriLiceNum = empDriLiceNum;
       this.empDriLiceExpDate = empDriLiceExpDate;
       this.empMilitaryService = empMilitaryService;
       this.empStreet1 = empStreet1;
       this.empStreet2 = empStreet2;
       this.cityCode = cityCode;
       this.counCode = counCode;
       this.provinCode = provinCode;
       this.empZipcode = empZipcode;
       this.empHmTelephone = empHmTelephone;
       this.empMobile = empMobile;
       this.empWorkTelephone = empWorkTelephone;
       this.empWorkEmail = empWorkEmail;
       this.salGrdCode = salGrdCode;
       this.joinedDate = joinedDate;
       this.empOthEmail = empOthEmail;
       this.terminatedDate = terminatedDate;
       this.terminationReason = terminationReason;
       this.custom1 = custom1;
       this.custom2 = custom2;
       this.custom3 = custom3;
       this.custom4 = custom4;
       this.custom5 = custom5;
       this.custom6 = custom6;
       this.custom7 = custom7;
       this.custom8 = custom8;
       this.custom9 = custom9;
       this.custom10 = custom10;
       this.empEmergencyContactses = empEmergencyContactses;
       this.empContractExtends = empContractExtends;
       this.empDirectdebits = empDirectdebits;
       this.empLocationHistories = empLocationHistories;
       this.empDependentses = empDependentses;
       this.empLicenseses = empLicenseses;
       this.empMemberDetails = empMemberDetails;
       this.jobVacancies = jobVacancies;
       this.timesheets = timesheets;
       this.empReporttosForErepSupEmpNumber = empReporttosForErepSupEmpNumber;
       this.empReporttosForErepSubEmpNumber = empReporttosForErepSubEmpNumber;
       this.empBasicsalaries = empBasicsalaries;
       this.jobApplicationEventses = jobApplicationEventses;
       this.empChildrens = empChildrens;
       this.empSubdivisionHistories = empSubdivisionHistories;
       this.timesheetSubmissionPeriods = timesheetSubmissionPeriods;
       this.empPictures = empPictures;
       this.hspPaymentRequests = hspPaymentRequests;
       this.projects = projects;
       this.hsps = hsps;
       this.empJobtitleHistories = empJobtitleHistories;
       this.employeeLeaveQuotas = employeeLeaveQuotas;
       this.timeEvents = timeEvents;
       this.empLanguages = empLanguages;
       this.empPassports = empPassports;
       this.locations = locations;
       this.userses = userses;
       this.empHistoryOfEalierPoses = empHistoryOfEalierPoses;
       this.empWorkExperiences = empWorkExperiences;
       this.empEducations = empEducations;
       this.workshifts = workshifts;
       this.leaveRequestses = leaveRequestses;
       this.empUsTaxes = empUsTaxes;
       this.empAttachments = empAttachments;
    }
   
     @Id 
    
    @Column(name="emp_number", unique=true, nullable=false)
    public int getEmpNumber() {
        return this.empNumber;
    }
    
    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="eeo_cat_code")
    public Eec getEec() {
        return this.eec;
    }
    
    public void setEec(Eec eec) {
        this.eec = eec;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ethnic_race_code")
    public EthnicRace getEthnicRace() {
        return this.ethnicRace;
    }
    
    public void setEthnicRace(EthnicRace ethnicRace) {
        this.ethnicRace = ethnicRace;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nation_code")
    public Nationality getNationality() {
        return this.nationality;
    }
    
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emp_status")
    public Empstat getEmpstat() {
        return this.empstat;
    }
    
    public void setEmpstat(Empstat empstat) {
        this.empstat = empstat;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="work_station")
    public Compstructtree getCompstructtree() {
        return this.compstructtree;
    }
    
    public void setCompstructtree(Compstructtree compstructtree) {
        this.compstructtree = compstructtree;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="job_title_code")
    public JobTitle getJobTitle() {
        return this.jobTitle;
    }
    
    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    @Column(name="employee_id", unique=true, length=50)
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    @Column(name="emp_lastname", nullable=false, length=100)
    public String getEmpLastname() {
        return this.empLastname;
    }
    
    public void setEmpLastname(String empLastname) {
        this.empLastname = empLastname;
    }
    
    @Column(name="emp_firstname", nullable=false, length=100)
    public String getEmpFirstname() {
        return this.empFirstname;
    }
    
    public void setEmpFirstname(String empFirstname) {
        this.empFirstname = empFirstname;
    }
    
    @Column(name="emp_middle_name", nullable=false, length=100)
    public String getEmpMiddleName() {
        return this.empMiddleName;
    }
    
    public void setEmpMiddleName(String empMiddleName) {
        this.empMiddleName = empMiddleName;
    }
    
    @Column(name="emp_nick_name", length=100)
    public String getEmpNickName() {
        return this.empNickName;
    }
    
    public void setEmpNickName(String empNickName) {
        this.empNickName = empNickName;
    }
    
    @Column(name="emp_smoker")
    public Short getEmpSmoker() {
        return this.empSmoker;
    }
    
    public void setEmpSmoker(Short empSmoker) {
        this.empSmoker = empSmoker;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="emp_birthday", length=10)
    public Date getEmpBirthday() {
        return this.empBirthday;
    }
    
    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }
    
    @Column(name="emp_gender")
    public Short getEmpGender() {
        return this.empGender;
    }
    
    public void setEmpGender(Short empGender) {
        this.empGender = empGender;
    }
    
    @Column(name="emp_marital_status", length=20)
    public String getEmpMaritalStatus() {
        return this.empMaritalStatus;
    }
    
    public void setEmpMaritalStatus(String empMaritalStatus) {
        this.empMaritalStatus = empMaritalStatus;
    }
    
    @Column(name="emp_ssn_num", length=100)
    public String getEmpSsnNum() {
        return this.empSsnNum;
    }
    
    public void setEmpSsnNum(String empSsnNum) {
        this.empSsnNum = empSsnNum;
    }
    
    @Column(name="emp_sin_num", length=100)
    public String getEmpSinNum() {
        return this.empSinNum;
    }
    
    public void setEmpSinNum(String empSinNum) {
        this.empSinNum = empSinNum;
    }
    
    @Column(name="emp_other_id", length=100)
    public String getEmpOtherId() {
        return this.empOtherId;
    }
    
    public void setEmpOtherId(String empOtherId) {
        this.empOtherId = empOtherId;
    }
    
    @Column(name="emp_dri_lice_num", length=100)
    public String getEmpDriLiceNum() {
        return this.empDriLiceNum;
    }
    
    public void setEmpDriLiceNum(String empDriLiceNum) {
        this.empDriLiceNum = empDriLiceNum;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="emp_dri_lice_exp_date", length=10)
    public Date getEmpDriLiceExpDate() {
        return this.empDriLiceExpDate;
    }
    
    public void setEmpDriLiceExpDate(Date empDriLiceExpDate) {
        this.empDriLiceExpDate = empDriLiceExpDate;
    }
    
    @Column(name="emp_military_service", length=100)
    public String getEmpMilitaryService() {
        return this.empMilitaryService;
    }
    
    public void setEmpMilitaryService(String empMilitaryService) {
        this.empMilitaryService = empMilitaryService;
    }
    
    @Column(name="emp_street1", length=100)
    public String getEmpStreet1() {
        return this.empStreet1;
    }
    
    public void setEmpStreet1(String empStreet1) {
        this.empStreet1 = empStreet1;
    }
    
    @Column(name="emp_street2", length=100)
    public String getEmpStreet2() {
        return this.empStreet2;
    }
    
    public void setEmpStreet2(String empStreet2) {
        this.empStreet2 = empStreet2;
    }
    
    @Column(name="city_code", length=100)
    public String getCityCode() {
        return this.cityCode;
    }
    
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    
    @Column(name="coun_code", length=100)
    public String getCounCode() {
        return this.counCode;
    }
    
    public void setCounCode(String counCode) {
        this.counCode = counCode;
    }
    
    @Column(name="provin_code", length=100)
    public String getProvinCode() {
        return this.provinCode;
    }
    
    public void setProvinCode(String provinCode) {
        this.provinCode = provinCode;
    }
    
    @Column(name="emp_zipcode", length=20)
    public String getEmpZipcode() {
        return this.empZipcode;
    }
    
    public void setEmpZipcode(String empZipcode) {
        this.empZipcode = empZipcode;
    }
    
    @Column(name="emp_hm_telephone", length=50)
    public String getEmpHmTelephone() {
        return this.empHmTelephone;
    }
    
    public void setEmpHmTelephone(String empHmTelephone) {
        this.empHmTelephone = empHmTelephone;
    }
    
    @Column(name="emp_mobile", length=50)
    public String getEmpMobile() {
        return this.empMobile;
    }
    
    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }
    
    @Column(name="emp_work_telephone", length=50)
    public String getEmpWorkTelephone() {
        return this.empWorkTelephone;
    }
    
    public void setEmpWorkTelephone(String empWorkTelephone) {
        this.empWorkTelephone = empWorkTelephone;
    }
    
    @Column(name="emp_work_email", length=50)
    public String getEmpWorkEmail() {
        return this.empWorkEmail;
    }
    
    public void setEmpWorkEmail(String empWorkEmail) {
        this.empWorkEmail = empWorkEmail;
    }
    
    @Column(name="sal_grd_code", length=13)
    public String getSalGrdCode() {
        return this.salGrdCode;
    }
    
    public void setSalGrdCode(String salGrdCode) {
        this.salGrdCode = salGrdCode;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="joined_date", length=10)
    public Date getJoinedDate() {
        return this.joinedDate;
    }
    
    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }
    
    @Column(name="emp_oth_email", length=50)
    public String getEmpOthEmail() {
        return this.empOthEmail;
    }
    
    public void setEmpOthEmail(String empOthEmail) {
        this.empOthEmail = empOthEmail;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="terminated_date", length=10)
    public Date getTerminatedDate() {
        return this.terminatedDate;
    }
    
    public void setTerminatedDate(Date terminatedDate) {
        this.terminatedDate = terminatedDate;
    }
    
    @Column(name="termination_reason", length=256)
    public String getTerminationReason() {
        return this.terminationReason;
    }
    
    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }
    
    @Column(name="custom1", length=250)
    public String getCustom1() {
        return this.custom1;
    }
    
    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }
    
    @Column(name="custom2", length=250)
    public String getCustom2() {
        return this.custom2;
    }
    
    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }
    
    @Column(name="custom3", length=250)
    public String getCustom3() {
        return this.custom3;
    }
    
    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }
    
    @Column(name="custom4", length=250)
    public String getCustom4() {
        return this.custom4;
    }
    
    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }
    
    @Column(name="custom5", length=250)
    public String getCustom5() {
        return this.custom5;
    }
    
    public void setCustom5(String custom5) {
        this.custom5 = custom5;
    }
    
    @Column(name="custom6", length=250)
    public String getCustom6() {
        return this.custom6;
    }
    
    public void setCustom6(String custom6) {
        this.custom6 = custom6;
    }
    
    @Column(name="custom7", length=250)
    public String getCustom7() {
        return this.custom7;
    }
    
    public void setCustom7(String custom7) {
        this.custom7 = custom7;
    }
    
    @Column(name="custom8", length=250)
    public String getCustom8() {
        return this.custom8;
    }
    
    public void setCustom8(String custom8) {
        this.custom8 = custom8;
    }
    
    @Column(name="custom9", length=250)
    public String getCustom9() {
        return this.custom9;
    }
    
    public void setCustom9(String custom9) {
        this.custom9 = custom9;
    }
    
    @Column(name="custom10", length=250)
    public String getCustom10() {
        return this.custom10;
    }
    
    public void setCustom10(String custom10) {
        this.custom10 = custom10;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpEmergencyContacts> getEmpEmergencyContactses() {
        return this.empEmergencyContactses;
    }
    
    public void setEmpEmergencyContactses(Set<EmpEmergencyContacts> empEmergencyContactses) {
        this.empEmergencyContactses = empEmergencyContactses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpContractExtend> getEmpContractExtends() {
        return this.empContractExtends;
    }
    
    public void setEmpContractExtends(Set<EmpContractExtend> empContractExtends) {
        this.empContractExtends = empContractExtends;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpDirectdebit> getEmpDirectdebits() {
        return this.empDirectdebits;
    }
    
    public void setEmpDirectdebits(Set<EmpDirectdebit> empDirectdebits) {
        this.empDirectdebits = empDirectdebits;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpLocationHistory> getEmpLocationHistories() {
        return this.empLocationHistories;
    }
    
    public void setEmpLocationHistories(Set<EmpLocationHistory> empLocationHistories) {
        this.empLocationHistories = empLocationHistories;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpDependents> getEmpDependentses() {
        return this.empDependentses;
    }
    
    public void setEmpDependentses(Set<EmpDependents> empDependentses) {
        this.empDependentses = empDependentses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpLicenses> getEmpLicenseses() {
        return this.empLicenseses;
    }
    
    public void setEmpLicenseses(Set<EmpLicenses> empLicenseses) {
        this.empLicenseses = empLicenseses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpMemberDetail> getEmpMemberDetails() {
        return this.empMemberDetails;
    }
    
    public void setEmpMemberDetails(Set<EmpMemberDetail> empMemberDetails) {
        this.empMemberDetails = empMemberDetails;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<JobVacancy> getJobVacancies() {
        return this.jobVacancies;
    }
    
    public void setJobVacancies(Set<JobVacancy> jobVacancies) {
        this.jobVacancies = jobVacancies;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<Timesheet> getTimesheets() {
        return this.timesheets;
    }
    
    public void setTimesheets(Set<Timesheet> timesheets) {
        this.timesheets = timesheets;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employeeByErepSupEmpNumber")
    public Set<EmpReportto> getEmpReporttosForErepSupEmpNumber() {
        return this.empReporttosForErepSupEmpNumber;
    }
    
    public void setEmpReporttosForErepSupEmpNumber(Set<EmpReportto> empReporttosForErepSupEmpNumber) {
        this.empReporttosForErepSupEmpNumber = empReporttosForErepSupEmpNumber;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employeeByErepSubEmpNumber")
    public Set<EmpReportto> getEmpReporttosForErepSubEmpNumber() {
        return this.empReporttosForErepSubEmpNumber;
    }
    
    public void setEmpReporttosForErepSubEmpNumber(Set<EmpReportto> empReporttosForErepSubEmpNumber) {
        this.empReporttosForErepSubEmpNumber = empReporttosForErepSubEmpNumber;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpBasicsalary> getEmpBasicsalaries() {
        return this.empBasicsalaries;
    }
    
    public void setEmpBasicsalaries(Set<EmpBasicsalary> empBasicsalaries) {
        this.empBasicsalaries = empBasicsalaries;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<JobApplicationEvents> getJobApplicationEventses() {
        return this.jobApplicationEventses;
    }
    
    public void setJobApplicationEventses(Set<JobApplicationEvents> jobApplicationEventses) {
        this.jobApplicationEventses = jobApplicationEventses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpChildren> getEmpChildrens() {
        return this.empChildrens;
    }
    
    public void setEmpChildrens(Set<EmpChildren> empChildrens) {
        this.empChildrens = empChildrens;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpSubdivisionHistory> getEmpSubdivisionHistories() {
        return this.empSubdivisionHistories;
    }
    
    public void setEmpSubdivisionHistories(Set<EmpSubdivisionHistory> empSubdivisionHistories) {
        this.empSubdivisionHistories = empSubdivisionHistories;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employees")
    public Set<TimesheetSubmissionPeriod> getTimesheetSubmissionPeriods() {
        return this.timesheetSubmissionPeriods;
    }
    
    public void setTimesheetSubmissionPeriods(Set<TimesheetSubmissionPeriod> timesheetSubmissionPeriods) {
        this.timesheetSubmissionPeriods = timesheetSubmissionPeriods;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpPicture> getEmpPictures() {
        return this.empPictures;
    }
    
    public void setEmpPictures(Set<EmpPicture> empPictures) {
        this.empPictures = empPictures;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<HspPaymentRequest> getHspPaymentRequests() {
        return this.hspPaymentRequests;
    }
    
    public void setHspPaymentRequests(Set<HspPaymentRequest> hspPaymentRequests) {
        this.hspPaymentRequests = hspPaymentRequests;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employees")
    public Set<Project> getProjects() {
        return this.projects;
    }
    
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<Hsp> getHsps() {
        return this.hsps;
    }
    
    public void setHsps(Set<Hsp> hsps) {
        this.hsps = hsps;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpJobtitleHistory> getEmpJobtitleHistories() {
        return this.empJobtitleHistories;
    }
    
    public void setEmpJobtitleHistories(Set<EmpJobtitleHistory> empJobtitleHistories) {
        this.empJobtitleHistories = empJobtitleHistories;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmployeeLeaveQuota> getEmployeeLeaveQuotas() {
        return this.employeeLeaveQuotas;
    }
    
    public void setEmployeeLeaveQuotas(Set<EmployeeLeaveQuota> employeeLeaveQuotas) {
        this.employeeLeaveQuotas = employeeLeaveQuotas;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<TimeEvent> getTimeEvents() {
        return this.timeEvents;
    }
    
    public void setTimeEvents(Set<TimeEvent> timeEvents) {
        this.timeEvents = timeEvents;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpLanguage> getEmpLanguages() {
        return this.empLanguages;
    }
    
    public void setEmpLanguages(Set<EmpLanguage> empLanguages) {
        this.empLanguages = empLanguages;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpPassport> getEmpPassports() {
        return this.empPassports;
    }
    
    public void setEmpPassports(Set<EmpPassport> empPassports) {
        this.empPassports = empPassports;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="emp_locations", catalog="ashrm", joinColumns = { 
        @JoinColumn(name="emp_number", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="loc_code", nullable=false, updatable=false) })
    public Set<Location> getLocations() {
        return this.locations;
    }
    
    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<Users> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpHistoryOfEalierPos> getEmpHistoryOfEalierPoses() {
        return this.empHistoryOfEalierPoses;
    }
    
    public void setEmpHistoryOfEalierPoses(Set<EmpHistoryOfEalierPos> empHistoryOfEalierPoses) {
        this.empHistoryOfEalierPoses = empHistoryOfEalierPoses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpWorkExperience> getEmpWorkExperiences() {
        return this.empWorkExperiences;
    }
    
    public void setEmpWorkExperiences(Set<EmpWorkExperience> empWorkExperiences) {
        this.empWorkExperiences = empWorkExperiences;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpEducation> getEmpEducations() {
        return this.empEducations;
    }
    
    public void setEmpEducations(Set<EmpEducation> empEducations) {
        this.empEducations = empEducations;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employees")
    public Set<Workshift> getWorkshifts() {
        return this.workshifts;
    }
    
    public void setWorkshifts(Set<Workshift> workshifts) {
        this.workshifts = workshifts;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<LeaveRequests> getLeaveRequestses() {
        return this.leaveRequestses;
    }
    
    public void setLeaveRequestses(Set<LeaveRequests> leaveRequestses) {
        this.leaveRequestses = leaveRequestses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpUsTax> getEmpUsTaxes() {
        return this.empUsTaxes;
    }
    
    public void setEmpUsTaxes(Set<EmpUsTax> empUsTaxes) {
        this.empUsTaxes = empUsTaxes;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
    public Set<EmpAttachment> getEmpAttachments() {
        return this.empAttachments;
    }
    
    public void setEmpAttachments(Set<EmpAttachment> empAttachments) {
        this.empAttachments = empAttachments;
    }




}


