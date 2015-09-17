package numbers;

public class SquareNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer numberToWriteOut = 0;
		
		System.out.print("Starting program...\n");
		
		if (args.length != 1) {
			System.out.print("Must supply just one number.\n");
		    return;
		}
		
		try {
			numberToWriteOut = Integer.valueOf(args[0]);
		}
		catch (NumberFormatException numberFormatException) {
			System.out.print("Invalid integer supplied.\n");
		}
		
		for (int i = 1 ; i <= numberToWriteOut ; i++)
			System.out.print(i + " squared is: " + i*i + "\n");
	}

}
