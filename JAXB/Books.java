package com.accolite.asignment;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Books {

	List<Book> book;

	public Books()
	{
		
	}
	
	public Books(List<Book> book) {
		this.book = book;
	}
	@XmlElement
	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}


}
