package MarshallAndUnmarshall;
import javax.xml.bind.annotation.XmlElement;  
import java.util.List;

public class Catalog {
	private  List<Book> books ;
Catalog(){}
	Catalog(List<Book> books)
	{
		this.books=books;
	}
	@XmlElement  
	
	public List<Book> getBook() {
		return this.books;
	}

	public void setBook(List<Book>books) {
		this.books = books;
	}
}
