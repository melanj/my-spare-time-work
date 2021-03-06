package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * HsPrSalaryCurrencyDetail generated by hbm2java
 */
@Entity
@Table(name="hs_pr_salary_currency_detail"
    ,catalog="ashrm"
)
public class HsPrSalaryCurrencyDetail  implements java.io.Serializable {


     private HsPrSalaryCurrencyDetailId id;
     private Salarygrade salarygrade;
     private CurrencyType currencyType;
     private Double salcurrDtlMinsalary;
     private Double salcurrDtlStepsalary;
     private Double salcurrDtlMaxsalary;

    public HsPrSalaryCurrencyDetail() {
    }

	
    public HsPrSalaryCurrencyDetail(HsPrSalaryCurrencyDetailId id, Salarygrade salarygrade, CurrencyType currencyType) {
        this.id = id;
        this.salarygrade = salarygrade;
        this.currencyType = currencyType;
    }
    public HsPrSalaryCurrencyDetail(HsPrSalaryCurrencyDetailId id, Salarygrade salarygrade, CurrencyType currencyType, Double salcurrDtlMinsalary, Double salcurrDtlStepsalary, Double salcurrDtlMaxsalary) {
       this.id = id;
       this.salarygrade = salarygrade;
       this.currencyType = currencyType;
       this.salcurrDtlMinsalary = salcurrDtlMinsalary;
       this.salcurrDtlStepsalary = salcurrDtlStepsalary;
       this.salcurrDtlMaxsalary = salcurrDtlMaxsalary;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="salGrdCode", column=@Column(name="sal_grd_code", nullable=false, length=13) ), 
        @AttributeOverride(name="currencyId", column=@Column(name="currency_id", nullable=false, length=3) ) } )
    public HsPrSalaryCurrencyDetailId getId() {
        return this.id;
    }
    
    public void setId(HsPrSalaryCurrencyDetailId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sal_grd_code", nullable=false, insertable=false, updatable=false)
    public Salarygrade getSalarygrade() {
        return this.salarygrade;
    }
    
    public void setSalarygrade(Salarygrade salarygrade) {
        this.salarygrade = salarygrade;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="currency_id", nullable=false, insertable=false, updatable=false)
    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }
    
    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
    
    @Column(name="salcurr_dtl_minsalary", precision=22, scale=0)
    public Double getSalcurrDtlMinsalary() {
        return this.salcurrDtlMinsalary;
    }
    
    public void setSalcurrDtlMinsalary(Double salcurrDtlMinsalary) {
        this.salcurrDtlMinsalary = salcurrDtlMinsalary;
    }
    
    @Column(name="salcurr_dtl_stepsalary", precision=22, scale=0)
    public Double getSalcurrDtlStepsalary() {
        return this.salcurrDtlStepsalary;
    }
    
    public void setSalcurrDtlStepsalary(Double salcurrDtlStepsalary) {
        this.salcurrDtlStepsalary = salcurrDtlStepsalary;
    }
    
    @Column(name="salcurr_dtl_maxsalary", precision=22, scale=0)
    public Double getSalcurrDtlMaxsalary() {
        return this.salcurrDtlMaxsalary;
    }
    
    public void setSalcurrDtlMaxsalary(Double salcurrDtlMaxsalary) {
        this.salcurrDtlMaxsalary = salcurrDtlMaxsalary;
    }




}


