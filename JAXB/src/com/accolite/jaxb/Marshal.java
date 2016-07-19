package com.accolite.jaxb;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshal {

	public static void main(String[] args) {

		Entry entry = new Entry();
		entry.data = new ArrayList<GoT>(5);
		  GoT favorite1 = new GoT();
		  favorite1.getCharacter().setAge(20);
		  favorite1.getCharacter().setFirstname("Daenerys");
		  favorite1.getCharacter().setFamily("Targaryen");
		  favorite1.setAddress("Westeros");
		  favorite1.setKingdom("All 7 Kingdoms");
		  favorite1.setPet_type("Dragons");
		  favorite1.setFamily_line("Fire and Blood");
		  
		  GoT favorite2 = new GoT();
		  favorite2.getCharacter().setAge(15);
		  favorite2.getCharacter().setFirstname("Arya");
		  favorite2.getCharacter().setFamily("Stark");
		  favorite2.setAddress("Riverlands");
		  favorite2.setKingdom("Winterfell");
		  favorite2.setPet_type("Direwolf");
		  favorite2.setFamily_line("Winter is Coming");
		  entry.data.add(favorite1);
		  entry.data.add(favorite2);
		  
		  try {

			File file = new File("parsed.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(entry, file);
			//jaxbMarshaller.marshal(favorite2, file);
			jaxbMarshaller.marshal(entry, System.out);

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }

		}
}
