import books.Book;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.apache.struts2.convention.annotation.Action;
//import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
//import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.ModelDriven;

public class BookAction extends ActionSupport/* implements ModelDriven*/ {

    Book book = new Book();
    List<Book> bookList = new ArrayList<Book>();

    public BookAction() {
    }

    @Override
    @Action(value="Book", results={
	@Result(name="success",location="/WEB-INF/book.jsp")
    })
    public String execute() throws Exception {
        SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
        Session session = sessionFactory.openSession();
        bookList = session.createQuery("from Book").list();
        return SUCCESS;
    }

  //  public Object getModel() {
  //      return book;
  //  }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return this.bookList;
    }
}
