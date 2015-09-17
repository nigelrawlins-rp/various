/**
 * 
 */
package bridge;

/**
 * @author Nigel
 *
 */
public enum Rank {
	
	ACE(13),
	KING(12),
	QUEEN(11),
	JACK(10),
	TEN(9),
	NINE(8),
	EIGHT(7),
	SEVEN(6),
	SIX(5),
	FIVE(4),
	FOUR(3),
	THREE(2),
	TWO(1);
	
	int rating;
	
	private Rank(final int rating) {
		this.rating = rating;
	}
	
	public boolean beats(final Rank otherRank) {
		return this.rating > otherRank.rating;
	}
}
