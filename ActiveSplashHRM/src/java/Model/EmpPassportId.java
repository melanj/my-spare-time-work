package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmpPassportId generated by hbm2java
 */
@Embeddable
public class EmpPassportId  implements java.io.Serializable {


     private int empNumber;
     private byte epSeqno;

    public EmpPassportId() {
    }

    public EmpPassportId(int empNumber, byte epSeqno) {
       this.empNumber = empNumber;
       this.epSeqno = epSeqno;
    }
   

    @Column(name="emp_number", nullable=false)
    public int getEmpNumber() {
        return this.empNumber;
    }
    
    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    @Column(name="ep_seqno", nullable=false, precision=2, scale=0)
    public byte getEpSeqno() {
        return this.epSeqno;
    }
    
    public void setEpSeqno(byte epSeqno) {
        this.epSeqno = epSeqno;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EmpPassportId) ) return false;
		 EmpPassportId castOther = ( EmpPassportId ) other; 
         
		 return (this.getEmpNumber()==castOther.getEmpNumber())
 && (this.getEpSeqno()==castOther.getEpSeqno());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getEmpNumber();
         result = 37 * result + this.getEpSeqno();
         return result;
   }   


}


