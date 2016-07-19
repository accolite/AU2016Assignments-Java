package com.accolite.asignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLToObject {

	public static void main(String[] args) throws JAXBException {

		int bookCount=1;
		File xmlFile = new  File("D:\\AU\\Web\\books.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		Books booksUnmarshall = (Books) jaxbUnmarshaller.unmarshal(xmlFile);
		//Books booksUnmarshall = (Books) jaxbUnmarshaller.unmarshal(is);
		
		List<Book> unmarshalledBookList = booksUnmarshall.getBook();
		for(Book book: unmarshalledBookList)
		{
			System.out.println("Book No"+ bookCount);
			System.out.println("Book name"+ book.getName());
			System.out.println("Book author"+book.getAuthor());
			System.out.println("Book price"+ book.getPrice());
			System.out.println("Book rating"+ book.getRating());
			bookCount++;
		}
		
	}

}
