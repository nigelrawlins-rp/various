/**
 * 
 */
package bridge;

/**
 * @author Nigel
 *
 */
public enum Suit {
	
	SPADES,
	HEARTS,
	DIAMONDS,
	CLUBS;
	
	private boolean trumps;
	private boolean led;
	
	public void setTrumps(final boolean trumps) {
		this.trumps = trumps;
	}
	
	public boolean isTrumps() {
		return this.trumps;
	}
	
	public void setLed(final boolean led) {
		this.led = led;
	}
	
	public boolean isLed() {
		return this.led;
	}
}
