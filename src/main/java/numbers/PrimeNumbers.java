package numbers;

/**
 * @author Nigel
 *
 */
public class PrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer maximumNumber = 0;
		Integer primeNumberCount = 0;
		
		System.out.print("Starting program...\n");
		
		if (args.length != 1) {
			System.out.print("Must supply just one number.\n");
		    return;
		}
		
		try {
			maximumNumber = Integer.valueOf(args[0]);
		}
		catch (NumberFormatException numberFormatException) {
			System.out.print("Invalid integer supplied.\n");
		}
		
		for (int i = 1 ; i <= maximumNumber ; i++) {
			if (isPrime(i)) {
				primeNumberCount++;
				System.out.print(i + "\n");
			}
		}
		
		System.out.print("Total number of primes found: " + primeNumberCount + "\n");
	}

	private static boolean isPrime(int i) {
		
		if (i == 1)
			return false;
		
		for (double j = 1 ; j <= Math.sqrt((double) i) + 1 ; j++) {
			if ((i/j) - Math.floor(i/j) < 0.00000001 && j != 1 && j != i)
				return false;
		}
		
		return true;
	}

}
