package com.accolite.jaxb;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentMap.
 */
@XmlRootElement (name="students")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentEntryMap {
     
    /** The student map. */
    private Map<Integer, student> studentMap = new HashMap<Integer, student>();
 
    /**
     * Gets the student map.
     *
     * @return the student map
     */
    public Map<Integer, student> getStudentMap() {
        return studentMap;
    }
 
    /**
     * Sets the student map.
     *
     * @param studentMap the student map
     */
    public void setStudentMap(Map<Integer, student> studentMap) {
        this.studentMap = studentMap;
    }
}