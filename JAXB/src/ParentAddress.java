import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ParentAddress {
	private List<Address> list;
	
	public ParentAddress() {
		list = new ArrayList<>();
		
	}
	
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}
	
}
