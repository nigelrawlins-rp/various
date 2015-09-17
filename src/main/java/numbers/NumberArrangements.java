package numbers;


public class NumberArrangements {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final String array[] = {"A", "B", "C", "D", "E", "F", "G", "H"/*, "I", "J", "K", "L", "M"*/};
		
		final NumberArranger numberArranger = new NumberArranger(array);
		
		numberArranger.deriveOutput(array);
		
		System.out.print("Total entries: " + numberArranger.getTotalEntries());
	}
}
