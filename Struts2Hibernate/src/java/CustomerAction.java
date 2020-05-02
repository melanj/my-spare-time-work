import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@ResultPath(value="/")
public class CustomerAction extends ActionSupport
	implements ModelDriven{

	Customer customer = new Customer();
	List<Customer> customerList = new ArrayList<Customer>();

    	@Action(value="Customer", results={
		@Result(name="success",location="WEB-INF/customer.jsp")
        })
    @Override
	public String execute() throws Exception {
		return listCustomer();
	}

	public Object getModel() {
		return customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	@Action(value="addCustomerAction", results={
		@Result(name="success",location="WEB-INF/customer.jsp")
        })
	public String addCustomer() throws Exception{

		//get hibernate session from the servlet context
		SessionFactory sessionFactory =
	         (SessionFactory) ServletActionContext.getServletContext()
                     .getAttribute(HibernateListener.KEY_NAME);

		Session session = sessionFactory.openSession();

		//save it
		customer.setCreatedDate(new Date());

		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();

		//reload the customer list
		customerList = null;
		customerList = session.createQuery("from Customer").list();

		return SUCCESS;

	}

	@Action(value="listCustomerAction", results={
		@Result(name="success",location="/WEB-INF/customer.jsp")
        })
	public String listCustomer() throws Exception{

		//get hibernate session from the servlet context
		SessionFactory sessionFactory =
	         (SessionFactory) ServletActionContext.getServletContext()
                     .getAttribute(HibernateListener.KEY_NAME);

		Session session = sessionFactory.openSession();

		customerList = session.createQuery("from Customer").list();

		return SUCCESS;

	}
}