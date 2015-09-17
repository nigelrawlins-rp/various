/**
 * 
 */
package bridge;

/**
 * @author Nigel
 *
 */
public class NoLeaderException extends RuntimeException {
	
	private static final long serialVersionUID = -740261284849724289L;
	
	public NoLeaderException(final String message) {
		super(message);
	}
}
