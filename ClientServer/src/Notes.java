
import java.io.Serializable;

public class Notes implements Serializable{

	   String desc;
	   String number;

	   public void setStreet(String street){
		   this.desc = street;
	   }
	   
	   public void setCountry(String country){
		   this.number = country;
	   }
	   
	   public String getStreet(){
		   return this.desc;
	   }
	   
	   public String getCountry(){
		   return this.number;
	   }
	   
	   @Override
	   public String toString() {
    	   return new StringBuffer(" Desc: ")
    	   .append(this.desc)
    	   .append(" Number : ")
    	   .append(this.number).toString();
	   }
	   
}