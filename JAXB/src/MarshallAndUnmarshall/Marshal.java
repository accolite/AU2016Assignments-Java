package MarshallAndUnmarshall;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshal {

	public void marshalling() {
		try {
			JAXBContext contextObj = JAXBContext.newInstance(Library.class);

			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Book book = new Book();
			book.setAuthor("abi");
			book.setDescription("a nice book");
			book.setGenre("horror");
			book.setId("123");
			book.setTitle("paranormal");
			book.setPrice("95");
			book.setPublish_date("09/05/2014");

			Book book2 = new Book();
			book2.setAuthor("padu");
			book2.setDescription("a good book");
			book2.setGenre("horror");
			book2.setId("143");
			book2.setTitle("supernatural");
			book2.setPrice("100");
			book2.setPublish_date("10/05/1995");

			ArrayList<Book> books = new ArrayList<Book>();
			books.add(book);
			books.add(book2);

			Catalog catalog = new Catalog(books);
			Library library = new Library(catalog);
			marshallerObj.marshal(library, new FileOutputStream("xmInput.xml"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
