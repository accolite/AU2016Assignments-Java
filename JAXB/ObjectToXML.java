package com.accolite.asignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjectToXML {

	public static void main(String args[]) throws JAXBException, FileNotFoundException
	{
		JAXBContext contextObj = JAXBContext.newInstance(Books.class);
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
		Book book1 = new Book("Alchemist","Paul",400,5);
		Book book2 =new Book("Sparkling cyanide","agatha christae",200,5);
		List<Book> booksList = new ArrayList<Book>();
		booksList.add(book1);
		booksList.add(book2);
		Books books=new Books(booksList);
		marshallerObj.marshal(books, new FileOutputStream("D:\\AU\\Web\\marshallBook.xml"));  
	}
}
