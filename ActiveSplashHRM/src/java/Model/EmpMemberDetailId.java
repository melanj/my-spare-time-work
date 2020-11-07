package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmpMemberDetailId generated by hbm2java
 */
@Embeddable
public class EmpMemberDetailId  implements java.io.Serializable {


     private int empNumber;
     private String membshipCode;
     private String membtypeCode;

    public EmpMemberDetailId() {
    }

    public EmpMemberDetailId(int empNumber, String membshipCode, String membtypeCode) {
       this.empNumber = empNumber;
       this.membshipCode = membshipCode;
       this.membtypeCode = membtypeCode;
    }
   

    @Column(name="emp_number", nullable=false)
    public int getEmpNumber() {
        return this.empNumber;
    }
    
    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    @Column(name="membship_code", nullable=false, length=13)
    public String getMembshipCode() {
        return this.membshipCode;
    }
    
    public void setMembshipCode(String membshipCode) {
        this.membshipCode = membshipCode;
    }

    @Column(name="membtype_code", nullable=false, length=13)
    public String getMembtypeCode() {
        return this.membtypeCode;
    }
    
    public void setMembtypeCode(String membtypeCode) {
        this.membtypeCode = membtypeCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EmpMemberDetailId) ) return false;
		 EmpMemberDetailId castOther = ( EmpMemberDetailId ) other; 
         
		 return (this.getEmpNumber()==castOther.getEmpNumber())
 && ( (this.getMembshipCode()==castOther.getMembshipCode()) || ( this.getMembshipCode()!=null && castOther.getMembshipCode()!=null && this.getMembshipCode().equals(castOther.getMembshipCode()) ) )
 && ( (this.getMembtypeCode()==castOther.getMembtypeCode()) || ( this.getMembtypeCode()!=null && castOther.getMembtypeCode()!=null && this.getMembtypeCode().equals(castOther.getMembtypeCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getEmpNumber();
         result = 37 * result + ( getMembshipCode() == null ? 0 : this.getMembshipCode().hashCode() );
         result = 37 * result + ( getMembtypeCode() == null ? 0 : this.getMembtypeCode().hashCode() );
         return result;
   }   


}

