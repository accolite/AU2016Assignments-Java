package pkg;
import java.io.FileOutputStream;  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;  
public class Marshalling {
	
		public static void main(String[] args) throws Exception{  
	    JAXBContext contextObj = JAXBContext.newInstance(Add_List.class);  
	  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	    
	    Add_List a=new Add_List(new Address("9971266690","gagan","26/09/1993"),new Address("8527239717","sumit","27/11/1991"));
	      
	    marshallerObj.marshal(a, new FileOutputStream("D:\\address1.xml"));  
	       
	}  
}  