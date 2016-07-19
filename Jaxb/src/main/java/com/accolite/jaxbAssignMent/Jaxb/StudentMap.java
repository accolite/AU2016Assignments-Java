package com.accolite.jaxbAssignMent.Jaxb;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="students")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentMap {
     
    private Map<Integer, student> studentMap = new HashMap<Integer, student>();
 
    public Map<Integer, student> getStudentMap() {
        return studentMap;
    }
 
    public void setStudentMap(Map<Integer, student> studentMap) {
        this.studentMap = studentMap;
    }
}