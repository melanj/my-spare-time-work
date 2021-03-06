package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmpDependentsId generated by hbm2java
 */
@Embeddable
public class EmpDependentsId  implements java.io.Serializable {


     private int empNumber;
     private byte edSeqno;

    public EmpDependentsId() {
    }

    public EmpDependentsId(int empNumber, byte edSeqno) {
       this.empNumber = empNumber;
       this.edSeqno = edSeqno;
    }
   

    @Column(name="emp_number", nullable=false)
    public int getEmpNumber() {
        return this.empNumber;
    }
    
    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    @Column(name="ed_seqno", nullable=false, precision=2, scale=0)
    public byte getEdSeqno() {
        return this.edSeqno;
    }
    
    public void setEdSeqno(byte edSeqno) {
        this.edSeqno = edSeqno;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EmpDependentsId) ) return false;
		 EmpDependentsId castOther = ( EmpDependentsId ) other; 
         
		 return (this.getEmpNumber()==castOther.getEmpNumber())
 && (this.getEdSeqno()==castOther.getEdSeqno());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getEmpNumber();
         result = 37 * result + this.getEdSeqno();
         return result;
   }   


}


