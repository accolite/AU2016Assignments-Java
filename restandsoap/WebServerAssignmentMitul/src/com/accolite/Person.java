package com.accolite;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mitul Kapoor on 7/22/2016.
 */
@XmlRootElement
public class Person {
    private int personoID;
    private String personName;

    public Person(){
        super();
    }

    public void setPersonoID(int personoID) {
        this.personoID = personoID;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonoID() {
        return personoID;
    }

    public String getPersonName() {
        return personName;
    }
}
