package Model;
// Generated Jan 14, 2011 3:39:55 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * HsPrSalaryCurrencyDetailId generated by hbm2java
 */
@Embeddable
public class HsPrSalaryCurrencyDetailId  implements java.io.Serializable {


     private String salGrdCode;
     private String currencyId;

    public HsPrSalaryCurrencyDetailId() {
    }

    public HsPrSalaryCurrencyDetailId(String salGrdCode, String currencyId) {
       this.salGrdCode = salGrdCode;
       this.currencyId = currencyId;
    }
   

    @Column(name="sal_grd_code", nullable=false, length=13)
    public String getSalGrdCode() {
        return this.salGrdCode;
    }
    
    public void setSalGrdCode(String salGrdCode) {
        this.salGrdCode = salGrdCode;
    }

    @Column(name="currency_id", nullable=false, length=3)
    public String getCurrencyId() {
        return this.currencyId;
    }
    
    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HsPrSalaryCurrencyDetailId) ) return false;
		 HsPrSalaryCurrencyDetailId castOther = ( HsPrSalaryCurrencyDetailId ) other; 
         
		 return ( (this.getSalGrdCode()==castOther.getSalGrdCode()) || ( this.getSalGrdCode()!=null && castOther.getSalGrdCode()!=null && this.getSalGrdCode().equals(castOther.getSalGrdCode()) ) )
 && ( (this.getCurrencyId()==castOther.getCurrencyId()) || ( this.getCurrencyId()!=null && castOther.getCurrencyId()!=null && this.getCurrencyId().equals(castOther.getCurrencyId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSalGrdCode() == null ? 0 : this.getSalGrdCode().hashCode() );
         result = 37 * result + ( getCurrencyId() == null ? 0 : this.getCurrencyId().hashCode() );
         return result;
   }   


}

