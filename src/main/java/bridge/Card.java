/**
 * 
 */
package bridge;

/**
 * @author Nigel
 *
 */
public enum Card {
	
	ACE_OF_SPADES(Rank.ACE, Suit.SPADES, "AS"),
	KING_OF_SPADES(Rank.KING, Suit.SPADES, "KS"),
	QUEEN_OF_SPADES(Rank.QUEEN, Suit.SPADES, "QS"),
	JACK_OF_SPADES(Rank.JACK, Suit.SPADES, "JS"),
	TEN_OF_SPADES(Rank.TEN, Suit.SPADES, "TS"),
	NINE_OF_SPADES(Rank.NINE, Suit.SPADES, "9S"),
	EIGHT_OF_SPADES(Rank.EIGHT, Suit.SPADES, "8S"),
	SEVEN_OF_SPADES(Rank.SEVEN, Suit.SPADES, "7S"),
	SIX_OF_SPADES(Rank.SIX, Suit.SPADES, "6S"),
	FIVE_OF_SPADES(Rank.FIVE, Suit.SPADES, "5S"),
	FOUR_OF_SPADES(Rank.FOUR, Suit.SPADES, "4S"),
	THREE_OF_SPADES(Rank.THREE, Suit.SPADES, "3S"),
	TWO_OF_SPADES(Rank.TWO, Suit.SPADES, "2S"),
	ACE_OF_HEARTS(Rank.ACE, Suit.HEARTS, "AH"),
	KING_OF_HEARTS(Rank.KING, Suit.HEARTS, "KH"),
	QUEEN_OF_HEARTS(Rank.QUEEN, Suit.HEARTS, "QH"),
	JACK_OF_HEARTS(Rank.JACK, Suit.HEARTS, "JH"),
	TEN_OF_HEARTS(Rank.TEN, Suit.HEARTS, "TH"),
	NINE_OF_HEARTS(Rank.NINE, Suit.HEARTS, "9H"),
	EIGHT_OF_HEARTS(Rank.EIGHT, Suit.HEARTS, "8H"),
	SEVEN_OF_HEARTS(Rank.SEVEN, Suit.HEARTS, "7H"),
	SIX_OF_HEARTS(Rank.SIX, Suit.HEARTS, "6H"),
	FIVE_OF_HEARTS(Rank.FIVE, Suit.HEARTS, "5H"),
	FOUR_OF_HEARTS(Rank.FOUR, Suit.HEARTS, "4H"),
	THREE_OF_HEARTS(Rank.THREE, Suit.HEARTS, "3H"),
	TWO_OF_HEARTS(Rank.TWO, Suit.HEARTS, "2H"),
	ACE_OF_DIAMONDS(Rank.ACE, Suit.DIAMONDS, "AD"),
	KING_OF_DIAMONDS(Rank.KING, Suit.DIAMONDS, "KD"),
	QUEEN_OF_DIAMONDS(Rank.QUEEN, Suit.DIAMONDS, "QD"),
	JACK_OF_DIAMONDS(Rank.JACK, Suit.DIAMONDS, "JD"),
	TEN_OF_DIAMONDS(Rank.TEN, Suit.DIAMONDS, "TD"),
	NINE_OF_DIAMONDS(Rank.NINE, Suit.DIAMONDS, "9D"),
	EIGHT_OF_DIAMONDS(Rank.EIGHT, Suit.DIAMONDS, "8D"),
	SEVEN_OF_DIAMONDS(Rank.SEVEN, Suit.DIAMONDS, "7D"),
	SIX_OF_DIAMONDS(Rank.SIX, Suit.DIAMONDS, "6D"),
	FIVE_OF_DIAMONDS(Rank.FIVE, Suit.DIAMONDS, "5D"),
	FOUR_OF_DIAMONDS(Rank.FOUR, Suit.DIAMONDS, "4D"),
	THREE_OF_DIAMONDS(Rank.THREE, Suit.DIAMONDS, "3D"),
	TWO_OF_DIAMONDS(Rank.TWO, Suit.DIAMONDS, "2D"),
	ACE_OF_CLUBS(Rank.ACE, Suit.CLUBS, "AC"),
	KING_OF_CLUBS(Rank.KING, Suit.CLUBS, "KC"),
	QUEEN_OF_CLUBS(Rank.QUEEN, Suit.CLUBS, "QC"),
	JACK_OF_CLUBS(Rank.JACK, Suit.CLUBS, "JC"),
	TEN_OF_CLUBS(Rank.TEN, Suit.CLUBS, "TC"),
	NINE_OF_CLUBS(Rank.NINE, Suit.CLUBS, "9C"),
	EIGHT_OF_CLUBS(Rank.EIGHT, Suit.CLUBS, "8C"),
	SEVEN_OF_CLUBS(Rank.SEVEN, Suit.CLUBS, "7C"),
	SIX_OF_CLUBS(Rank.SIX, Suit.CLUBS, "6C"),
	FIVE_OF_CLUBS(Rank.FIVE, Suit.CLUBS, "5C"),
	FOUR_OF_CLUBS(Rank.FOUR, Suit.CLUBS, "4C"),
	THREE_OF_CLUBS(Rank.THREE, Suit.CLUBS, "3C"),
	TWO_OF_CLUBS(Rank.TWO, Suit.CLUBS, "2C");
	
	private Rank rank;
	private Suit suit;
	private String shortName;
	
	private Card(final Rank rank, final Suit suit, final String shortName) {
		this.rank = rank;
		this.suit = suit;
		this.shortName = shortName;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public boolean beats(final Card subsequentCard) {
		
		if (this.suit.equals(subsequentCard.suit))
			return this.rank.beats(subsequentCard.rank);
		
		if (this.suit.isTrumps())
			return true;
		
		if (subsequentCard.suit.isTrumps())
			return false;
		
		return true;
	}
}
