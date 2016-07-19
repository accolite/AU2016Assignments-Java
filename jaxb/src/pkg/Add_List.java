package pkg;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="add")
public class Add_List
{
	@XmlElement(name="emp")
	ArrayList<Address> l = new ArrayList<>();
	Add_List(){	}
	Add_List(Address a1,Address a2 )
	{
		l.add(a1);
		l.add(a2);
	}
	ArrayList<Address> getList()
	{
		return l;
	}
}
