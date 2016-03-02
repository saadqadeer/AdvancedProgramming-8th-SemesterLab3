import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializer {

  /* public static void main (String args[]) {
    
	   Serializer serializer = new Serializer();
	   serializer.serializeAddress("wall street", "united state");
   }*/

   public void serializeAddress(String street, String country){
	   
	   Notes address = new Notes();
	   address.setStreet(street);
	   address.setCountry(country);
	   
	   try{
		   
		FileOutputStream fout = new FileOutputStream("F:\\saad.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(address);
		oos.close();   
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }
}