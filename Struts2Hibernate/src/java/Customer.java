

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="customer"
    ,catalog="j2ee"
)
public class Customer implements java.io.Serializable {
	private Long customerId;
	private String name;
	private String address;
	private Date createdDate;

public Customer() {
	}

	public Customer(String name, String address, Date createdDate) {
		this.name = name;
		this.address = address;
		this.createdDate = createdDate;
	}

    @Id @GeneratedValue(strategy=IDENTITY)

    @Column(name="CUSTOMER_ID", unique=true, nullable=false)
	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

        @Column(name="NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

        @Column(name="ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name="CREATED_DATE", length=19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
