package com.accolite.xmldom;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Address
{
    private Birthday birthday;

    private String phone;

    private String email;

    private Name name;

    public Address(){
    	
    }
    
    public Address(Birthday birthday, String phone, String email, Name name) {  
        super();  
        this.birthday = birthday;  
        this.phone = phone;  
        this.email = email;
        this.name = name;
    }  
    
    @XmlElement
    public Birthday getBirthday ()
    {
        return birthday;
    }

    public void setBirthday (Birthday birthday)
    {
        this.birthday = birthday;
    }

    @XmlElement
    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    @XmlElement
    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @XmlElement
    public Name getName ()
    {
        return name;
    }

    public void setName (Name name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "[birthday = "+birthday+", phone = "+phone+", email = "+email+", name = "+name+"]";
    }
}