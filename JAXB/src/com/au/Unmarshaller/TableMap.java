/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: SaiCharan Movva

* ***************************************************************************

*/
package com.au.Unmarshaller;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class TableMap.
 */
@XmlRootElement (name="tablemap")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableMap {
	
	/** The table list. */
	@XmlElement(name="table")
	private List<Table> tableList = null;
 
    /**
     * Gets the table.
     *
     * @return the table
     */
    public List<Table> getTable() {
        return tableList;
    }
 
    /**
     * Sets the table.
     *
     * @param tableList the new table
     */
    public void setTable(List<Table> tableList) {
        this.tableList = tableList;
    }
}
