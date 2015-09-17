/**
 * 
 */
package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nigel
 *
 */
public class NumberArranger2 {
	
	public void deriveOutput(final List<String> letters, final List<String> fixedAtStart) {
		
		for (String letter : letters) {
			
			final List<String> newLetters = new ArrayList<String>(letters);
			newLetters.remove(letter);
			
			final List<String> newFixedAtStart = new ArrayList<String>(fixedAtStart);
			newFixedAtStart.add(letter);
			
			if (newLetters.size() == 0) {
				for (String string : newFixedAtStart) {
					System.out.print(string);
				}
				System.out.print("\n");
				return;
			}
			
			deriveOutput(newLetters, newFixedAtStart);
		}
	}
}
