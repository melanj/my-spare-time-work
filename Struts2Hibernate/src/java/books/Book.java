package books;

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
@Table(name="book"
    ,catalog="j2ee"
)
public class Book  implements java.io.Serializable {


     private Integer id;
     private String title;
     private String year;
     private String author;
     private String isbn10;
     private String isbn13;
     private String publisher;
     private String cat1;
     private String cat2;
     private Date addedon;
     private String filename;
     private String filetype;
     private String isSourceCodeDownloaded;

    public Book() {
    }

    public Book(String title, String year, String author, String isbn10, String isbn13, String publisher, String cat1, String cat2, Date addedon, String filename, String filetype, String isSourceCodeDownloaded) {
       this.title = title;
       this.year = year;
       this.author = author;
       this.isbn10 = isbn10;
       this.isbn13 = isbn13;
       this.publisher = publisher;
       this.cat1 = cat1;
       this.cat2 = cat2;
       this.addedon = addedon;
       this.filename = filename;
       this.filetype = filetype;
       this.isSourceCodeDownloaded = isSourceCodeDownloaded;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="Title")
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="Year")
    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    @Column(name="Author")
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    @Column(name="ISBN10")
    public String getIsbn10() {
        return this.isbn10;
    }
    
    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }
    
    @Column(name="ISBN13")
    public String getIsbn13() {
        return this.isbn13;
    }
    
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }
    
    @Column(name="Publisher")
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @Column(name="cat1")
    public String getCat1() {
        return this.cat1;
    }
    
    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }
    
    @Column(name="cat2")
    public String getCat2() {
        return this.cat2;
    }
    
    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="addedon", length=19)
    public Date getAddedon() {
        return this.addedon;
    }
    
    public void setAddedon(Date addedon) {
        this.addedon = addedon;
    }
    
    @Column(name="filename")
    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    @Column(name="filetype")
    public String getFiletype() {
        return this.filetype;
    }
    
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
    
    @Column(name="isSourceCodeDownloaded")
    public String getIsSourceCodeDownloaded() {
        return this.isSourceCodeDownloaded;
    }
    
    public void setIsSourceCodeDownloaded(String isSourceCodeDownloaded) {
        this.isSourceCodeDownloaded = isSourceCodeDownloaded;
    }




}


