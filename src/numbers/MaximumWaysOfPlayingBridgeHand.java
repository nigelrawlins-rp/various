package numbers;

public class MaximumWaysOfPlayingBridgeHand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(Math.pow(factorial(13L), 4));
	}

	public static Long factorial(Long n) {
		
		if (n == 1)
			return n;
		
		return n * factorial(n - 1);
	}
}
