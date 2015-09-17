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
public class NumberArranger {

	private List<String> previousOneLineOutput = new ArrayList<String>();
	private List<String> oneLineOutput = new ArrayList<String>();

	final String[] objectList;
	
	private Long totalEntries = 0L;
	
	public NumberArranger(String[] objectList) {
		this.objectList = objectList;
	}

	public void deriveOutput(final String[] array) {
		
		for (int j = 0 ; j <= array.length - 1 ; j++) {
			
			oneLineOutput.add(array[j]);
			
			if (array.length == 1) {
				if (oneLineOutput.size() < this.objectList.length) {
					int currentOneLineOutputSize = oneLineOutput.size();
					for (int l = 0 ; l <= this.objectList.length - currentOneLineOutputSize - 1 ; l++) {
						oneLineOutput.add(l, this.previousOneLineOutput.get(l));
					}
				}
				this.previousOneLineOutput.clear();
				this.previousOneLineOutput = new ArrayList<String>(oneLineOutput);
				for (String string : oneLineOutput) {
					System.out.print(string);
				}
				System.out.print("\n");
				totalEntries++;
				oneLineOutput.clear();
				return;
			}
			
			final String[] remainingArray = new String[array.length - 1];
			
			for (int k = 0 ; k <= array.length - 1 ; k++) {
				if (k < j)
					remainingArray[k] = array[k];
				if (k > j)
					remainingArray[k - 1] = array[k];
			}
			
			deriveOutput(remainingArray);
		}
	}
	
	public Long getTotalEntries() {
		return this.totalEntries;
	}
}
