package numbers;

import java.util.ArrayList;
import java.util.List;


public class NumberArrangements2 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final List<String> letters = new ArrayList<String>();
		letters.add("A");
		letters.add("B");
		letters.add("C");
		letters.add("D");
		letters.add("E");
		
		final NumberArranger2 numberArranger2 = new NumberArranger2();
		
		numberArranger2.deriveOutput(letters, new ArrayList<String>());
	}
}
