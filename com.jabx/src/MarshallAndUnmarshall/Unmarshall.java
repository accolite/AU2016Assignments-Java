package MarshallAndUnmarshall;
import java.io.File;  
import java.util.List;  
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
   
public class Unmarshall {

public void unmarshalling(){  
	   
	     try {  
	   
	        File file = new File("books.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);  
	   
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	         
	        Library library= (Library) jaxbUnmarshaller.unmarshal(file);  
	        Catalog c=library.getCatalog();
	        List<Book> booklist=c.getBook();  

	        
	        for(Book book:booklist)  
	          System.out.println(" id is "+book.getId()+" author is  "+book.getAuthor()+" description is  "+book.getDescription()+" price is "+book.getPrice()+"  titile is "+book.getTitle()+" date of publish "+book.getPublish_date());  
	   
	      } catch (JAXBException e) {  
	        e.printStackTrace();  
	      }  
	   
	    }  
	}  

