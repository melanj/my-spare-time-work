package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmpLicensesId generated by hbm2java
 */
@Embeddable
public class EmpLicensesId  implements java.io.Serializable {


     private int empNumber;
     private String licensesCode;

    public EmpLicensesId() {
    }

    public EmpLicensesId(int empNumber, String licensesCode) {
       this.empNumber = empNumber;
       this.licensesCode = licensesCode;
    }
   

    @Column(name="emp_number", nullable=false)
    public int getEmpNumber() {
        return this.empNumber;
    }
    
    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    @Column(name="licenses_code", nullable=false, length=13)
    public String getLicensesCode() {
        return this.licensesCode;
    }
    
    public void setLicensesCode(String licensesCode) {
        this.licensesCode = licensesCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EmpLicensesId) ) return false;
		 EmpLicensesId castOther = ( EmpLicensesId ) other; 
         
		 return (this.getEmpNumber()==castOther.getEmpNumber())
 && ( (this.getLicensesCode()==castOther.getLicensesCode()) || ( this.getLicensesCode()!=null && castOther.getLicensesCode()!=null && this.getLicensesCode().equals(castOther.getLicensesCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getEmpNumber();
         result = 37 * result + ( getLicensesCode() == null ? 0 : this.getLicensesCode().hashCode() );
         return result;
   }   


}


