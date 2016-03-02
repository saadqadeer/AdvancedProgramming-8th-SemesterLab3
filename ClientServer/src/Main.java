import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String,String> object=new HashMap<String,String>();
		int length = 0;
		
		Scanner i=new Scanner(System.in);
		System.out.println("How many objects?");
		length=i.nextInt();
		
		
		String username;
		String detail;
		
		
		for(int i2=0;i2<length;i2++){
			Notes me=new Notes();
			System.out.println("Enter username");
			
			username=i.nextLine();
			i.nextLine();
			me.setCountry(username);
			System.out.println("Enter desc");
			detail=i.nextLine();
			i.nextLine();
			me.setStreet(detail);
			object.put(me.getCountry(), me.getStreet());
			
		}
		
		
		System.out.println("Enter username to search");
		Scanner ij=new Scanner(System.in);
		String match=ij.nextLine();
		
		Iterator<HashMap.Entry<String, String>> entries = object.entrySet().iterator();
		while (entries.hasNext()) {
		    HashMap.Entry<String, String> entry = entries.next();
		    if(match.equals(entry.getKey()) || match.equals(entry.getValue())){
		    	System.out.println("match found");
		    }
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
		
		

	}

}
