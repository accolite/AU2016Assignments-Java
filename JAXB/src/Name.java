import javax.xml.bind.annotation.XmlType;

@XmlType
public class Name{
	
	private String firstName;
	private String lastName;
	
	/**
	 * Instantiates a new name.
	 */
	Name(){}
		
	Name(String firstName, String lastName ){
		this.firstName=firstName;
		this.lastName=lastName;
	}
		
	public String getFirstName() {
		return firstName;
	}
		
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
		
	public String getLastName() {
		return lastName;
	}
		
	public void setLastName(String secondName) {
		this.lastName = secondName;
	}
}	