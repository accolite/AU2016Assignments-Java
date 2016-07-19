package com.acco.marsh;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "Addresses")
@XmlAccessorType (XmlAccessType.FIELD)
public class Addresses 
{
    @XmlElement(name = "address")
    private List<Address> addres = null;
 
    public List<Address> getAdreess() {
        return addres;
    }
 
    public void setAdress(List<Address> a) {
        this.addres = a;
    }
}
