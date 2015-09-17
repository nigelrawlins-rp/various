/**
 * 
 */
package bridge;


/**
 * @author Nigel
 *
 */
public class DealManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Deal all the cards out.
		
		Player.WEST.addCard(Card.KING_OF_SPADES);
		Player.WEST.addCard(Card.JACK_OF_SPADES);
		Player.WEST.addCard(Card.NINE_OF_SPADES);
		Player.WEST.addCard(Card.SEVEN_OF_SPADES);
		Player.WEST.addCard(Card.EIGHT_OF_HEARTS);
		Player.WEST.addCard(Card.KING_OF_DIAMONDS);
		Player.WEST.addCard(Card.TEN_OF_DIAMONDS);
		Player.WEST.addCard(Card.ACE_OF_CLUBS);
		Player.WEST.addCard(Card.KING_OF_CLUBS);
		Player.WEST.addCard(Card.QUEEN_OF_CLUBS);
		Player.WEST.addCard(Card.EIGHT_OF_CLUBS);
		Player.WEST.addCard(Card.SIX_OF_CLUBS);
		Player.WEST.addCard(Card.FOUR_OF_CLUBS);
		
		Player.NORTH.addCard(Card.TEN_OF_SPADES);
		Player.NORTH.addCard(Card.EIGHT_OF_SPADES);
		Player.NORTH.addCard(Card.SIX_OF_SPADES);
		Player.NORTH.addCard(Card.NINE_OF_HEARTS);
		Player.NORTH.addCard(Card.NINE_OF_DIAMONDS);
		Player.NORTH.addCard(Card.EIGHT_OF_DIAMONDS);
		Player.NORTH.addCard(Card.SEVEN_OF_DIAMONDS);
		Player.NORTH.addCard(Card.SIX_OF_DIAMONDS);
		Player.NORTH.addCard(Card.FIVE_OF_DIAMONDS);
		Player.NORTH.addCard(Card.FOUR_OF_DIAMONDS);
		Player.NORTH.addCard(Card.THREE_OF_DIAMONDS);
		Player.NORTH.addCard(Card.TWO_OF_DIAMONDS);
		Player.NORTH.addCard(Card.NINE_OF_CLUBS);
		
		Player.EAST.addCard(Card.ACE_OF_SPADES);
		Player.EAST.addCard(Card.QUEEN_OF_SPADES);
		Player.EAST.addCard(Card.ACE_OF_HEARTS);
		Player.EAST.addCard(Card.KING_OF_HEARTS);
		Player.EAST.addCard(Card.QUEEN_OF_HEARTS);
		Player.EAST.addCard(Card.JACK_OF_HEARTS);
		Player.EAST.addCard(Card.SEVEN_OF_HEARTS);
		Player.EAST.addCard(Card.FIVE_OF_HEARTS);
		Player.EAST.addCard(Card.THREE_OF_HEARTS);
		Player.EAST.addCard(Card.ACE_OF_DIAMONDS);
		Player.EAST.addCard(Card.QUEEN_OF_DIAMONDS);
		Player.EAST.addCard(Card.JACK_OF_DIAMONDS);
		Player.EAST.addCard(Card.TEN_OF_CLUBS);
		
		Player.SOUTH.addCard(Card.FIVE_OF_SPADES);
		Player.SOUTH.addCard(Card.FOUR_OF_SPADES);
		Player.SOUTH.addCard(Card.THREE_OF_SPADES);
		Player.SOUTH.addCard(Card.TWO_OF_SPADES);
		Player.SOUTH.addCard(Card.TEN_OF_HEARTS);
		Player.SOUTH.addCard(Card.SIX_OF_HEARTS);
		Player.SOUTH.addCard(Card.FOUR_OF_HEARTS);
		Player.SOUTH.addCard(Card.TWO_OF_HEARTS);
		Player.SOUTH.addCard(Card.JACK_OF_CLUBS);
		Player.SOUTH.addCard(Card.SEVEN_OF_CLUBS);
		Player.SOUTH.addCard(Card.FIVE_OF_CLUBS);
		Player.SOUTH.addCard(Card.THREE_OF_CLUBS);
		Player.SOUTH.addCard(Card.TWO_OF_CLUBS);
		
		// Set the trump suit - pass in null for no trumps.
		setTrumpSuit(null);
		
		// Set the leader - cannot be null.
		setLeader(Player.WEST);
		
		final HandCalculator handCalculator = new HandCalculator();
		handCalculator.processHand(true);
	}
	
	private static void setTrumpSuit(Suit trumpSuit) {
		
		for (Suit suit : Suit.values()) {
			
			if (suit.equals(trumpSuit)) {
				suit.setTrumps(true);
			}
			else {
				suit.setTrumps(false);
			}
		}
	}
	
	private static void setLeader(Player leader) {
		
		for (Player player : Player.values()) {
			
			if (player.equals(leader)) {
				player.setLeader(true);
			}
			else {
				player.setLeader(false);
			}
		}
	}
}
