package numericalproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nigel
 */
public class NextNumberSameDigitSum {

	/**
	 * @param args Argument list.
	 */
	public static void main(String[] args) {
		
		List<Integer> originalNumber = new ArrayList<Integer>();
		
		List<Integer> outputNumber = new ArrayList<Integer>();
		
		if (args.length != 1) {
			System.out.print("Please provide a single argument.\n");
			return;
		}
		
		if (args[0].length() > 15) {
			System.out.print("Maximum length of input is 15.\n");
			return;
		}
		
		try {
			Long.valueOf(args[0]);
		}
		catch (NumberFormatException numberFormatException) {
			System.out.print("Argument not recognised as a number.\n");
			return;
		}
		
		// Store the original number as a list of one digit integers.
		for (int originalDigit = 0 ; originalDigit < args[0].length() ; originalDigit++) {
			originalNumber.add(Integer.valueOf(args[0].substring(originalDigit, originalDigit + 1)));
		}
		
		/*
		 * Go through the list from right to left, starting at the second digit
		 * from the right, aiming to find the first one we can increment by 1
		 * to give the solution (the rightmost digit cannot work).
		 */
		for (int counter = originalNumber.size() - 2 ; counter >= 0 ; counter--) {
			
			int remainingTotal = 0;
			
			// If the current number is a 9, we can't increment this, so move on to the next.
			if (originalNumber.get(counter) == 9) {
				continue;
			}
			
			/*
			 * We've found a digit which is not a 9: now define the remaining total as the
			 * sum of all of the digits to the right of this.
			 */
			for (int rightDigit = counter + 1 ; rightDigit <= originalNumber.size() - 1 ; rightDigit++) {
				remainingTotal += originalNumber.get(rightDigit);
			}
			
			/*
			 * If the remaining total is 0, this won't work because all of these digits would
			 * then have to be made to total -1 (after incrementing the current digit by 1),
			 * so just continue to the next one of the main loop.
			 */
			if (remainingTotal == 0) {
				continue;
			}
			
			/*
			 * We now definitely have a solution: to start with, all digits of the output
			 * number up to 1 before the current number remain the same.
			 */
			for (int leftDigit = 0 ; leftDigit <= counter - 1 ; leftDigit++) {
				outputNumber.add(originalNumber.get(leftDigit));
			}
			
			// The current number is incremented by 1.
			outputNumber.add(originalNumber.get(counter) + 1);
			
			// The sum of the remaining digits must now total 1 less than its current value.
			remainingTotal -= 1;
			
			/*
			 * Distribute numbers in the remaining spaces, putting the smallest number possible in each slot.
			 * The smallest number is such that the remaining total after putting the number in that slot is
			 * not more than 9 times the remaining number of slots.
			 */
			for (int i = counter + 1 ; i < originalNumber.size() ; i++) {
				
				final int spacesToFill = originalNumber.size() - i;
				
				// Last digit: add it regardless and break. It will always be in the range 0 to 9.
				if (i == originalNumber.size() - 1) {
					outputNumber.add(remainingTotal);
					break;
				}
				
				/*
				 * Add the first allowable digit as defined in above comment. It is not possible for this to
				 * execute without hitting a digit it can write, given the way the algorithm is defined,
				 * could throw an exception if a digit is not written, but this cannot logically happen.
				 */
				for (int j = 0 ; j <= 9 ; j++) {
					if (remainingTotal - j <= (spacesToFill - 1) * 9) {
						outputNumber.add(j);
						remainingTotal -= j;
						break;
					}
				}
			}
			
			// Print out the solution.
			for (int digitToPrint = 0 ; digitToPrint < outputNumber.size() ; digitToPrint++) {
				System.out.print(outputNumber.get(digitToPrint));
			}
			
			// If we got this far, a solution was found so return.
			return;
		}
		
		// No solution was found so just print -1.
		System.out.print("-1");
	}
}
