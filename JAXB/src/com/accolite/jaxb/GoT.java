package com.accolite.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GoT {

		Identity character = new Identity();
		String kingdom;
		String pet_type;
		String address;
		String family_line;
		public Identity getCharacter() {
			return character;
		}
		
		public void setCharacter(Identity character) {
			this.character = character;
		}
		public String getKingdom() {
			return kingdom;
		}
		public void setKingdom(String kingdom) {
			this.kingdom = kingdom;
		}
		public String getPet_type() {
			return pet_type;
		}
		public void setPet_type(String pet_type) {
			this.pet_type = pet_type;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getFamily_line() {
			return family_line;
		}
		public void setFamily_line(String family_line) {
			this.family_line = family_line;
		}
		
}
