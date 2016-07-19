package MarshallAndUnmarshall;
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  

@XmlRootElement  
public class Library {
	private Catalog catalog;
Library(){}
	Library( Catalog catalog)
	{
		this.catalog=catalog;
	}
	@XmlElement  
	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		return "Library [catalog = " + catalog + "]";
	}

}
