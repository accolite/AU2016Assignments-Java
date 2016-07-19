package com.accolite.jaxb;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class Unmarshall {

	
		public static void main(String[] args) {

		 try {

			File file = new File("parsed.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Entry reveal_entry = (Entry) jaxbUnmarshaller.unmarshal(file);
			for(GoT favs:reveal_entry.getData())
			{
				
				System.out.println("Name: " + favs.getCharacter().getFirstname());
				System.out.println("House: " + favs.getCharacter().getFamily());
				System.out.println("Age: " + favs.getCharacter().getAge());
				System.out.println("House Words: " + favs.getFamily_line());
				System.out.println("Address: " + favs.getAddress());
				System.out.println("Kingdom: " + favs.getKingdom());
				System.out.println("FavPet: " + favs.getPet_type() + "\n");
			}

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }

		}
	
}
