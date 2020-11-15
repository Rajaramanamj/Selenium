package resources;

import java.util.ArrayList;

//import org.testng.annotations.Test;

public class JavaStreams {

	//@Test
	public void conventionalList() {
		
		int count = 0;
		ArrayList<String> names = new ArrayList<String> ();
		names.add("Abi");
		names.add("Ram");
		names.add("Abishek");
		names.add("Don");
		names.add("Alister");
		
		for(int i=0;i<names.size();i++) {
			String startsWithA = names.get(i);
			if(startsWithA.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}

}
