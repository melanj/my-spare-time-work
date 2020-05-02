package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="comp_property")
public class CompProperty  implements java.io.Serializable {


     private Integer propId;
     private String propName;
     private Integer empId;

    public CompProperty() {
    }

	
    public CompProperty(String propName) {
        this.propName = propName;
    }
    public CompProperty(String propName, Integer empId) {
       this.propName = propName;
       this.empId = empId;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="prop_id", unique=true, nullable=false)
    public Integer getPropId() {
        return this.propId;
    }
    
    public void setPropId(Integer propId) {
        this.propId = propId;
    }
    
    @Column(name="prop_name", nullable=false, length=250)
    public String getPropName() {
        return this.propName;
    }
    
    public void setPropName(String propName) {
        this.propName = propName;
    }
    
    @Column(name="emp_id")
    public Integer getEmpId() {
        return this.empId;
    }
    
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }




}


