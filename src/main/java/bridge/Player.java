/**
 * 
 */
package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nigel
 *
 */
public enum Player {
	
	NORTH,
	SOUTH,
	EAST,
	WEST;
	
	private List<Card> cards = new ArrayList<Card>();
	
	private boolean leader;
	
	public void addCard(final Card card) {
		this.cards.add(card);
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
	
	public void setLeader(final boolean leader) {
		this.leader = leader;
	}
	
	public boolean isLeader() {
		return this.leader;
	}
	
	public Player nextPlayer() {
		
		Player nextPlayer = null;
		
		if (this.equals(Player.NORTH))
			nextPlayer = Player.EAST;
		
		if (this.equals(Player.EAST))
			nextPlayer = Player.SOUTH;
		
		if (this.equals(Player.SOUTH))
			nextPlayer = Player.WEST;
		
		if (this.equals(Player.WEST))
			nextPlayer = Player.NORTH;
		
		return nextPlayer;
	}
	
	public List<Card> derivePlayableCards(final Card cardLed, final List<Card> allCardsPlayedSoFar, final List<Card> allCardsNotYetPlayed, final boolean useAdjacentCardsBehaviour) {
		
		List<Card> playableCards = new ArrayList<Card>();
		
		List<Card> cardsInTrickSoFar = new ArrayList<Card>();
		
		for (int i = 0 ; i < allCardsPlayedSoFar.size() % 4 ; i++) {
			cardsInTrickSoFar.add(allCardsPlayedSoFar.get(allCardsPlayedSoFar.size() - 1 - i));
		}
		
		for (Card card : this.cards) {
			if (!allCardsPlayedSoFar.contains(card) && (this.leader || null == cardLed || cardLed.getSuit().equals(card.getSuit())) &&
					(!useAdjacentCardsBehaviour || !hasHigherAdjacentCard(card, allCardsNotYetPlayed, cardsInTrickSoFar)))
				playableCards.add(card);
		}
		
		if (playableCards.isEmpty()) {
			for (Card card : this.cards) {
				if (!allCardsPlayedSoFar.contains(card) && !hasHigherAdjacentCard(card, allCardsNotYetPlayed, cardsInTrickSoFar))
					playableCards.add(card);
			}
		}
		
		return playableCards;
	}
	
	private boolean hasHigherAdjacentCard(final Card card, final List<Card> allCardsNotYetPlayed, final List<Card> cardsInTrickSoFar) {
		
		Card nextHighestCardInSameSuitOfThoseRemaining = null;
		
		final List<Card> allUnplayedPlusCurrentTrickCards = new ArrayList<Card>();
		allUnplayedPlusCurrentTrickCards.addAll(allCardsNotYetPlayed);
		allUnplayedPlusCurrentTrickCards.addAll(cardsInTrickSoFar);
		
		for (Card otherCard : allUnplayedPlusCurrentTrickCards) {
			if (otherCard.getSuit().equals(card.getSuit()) && otherCard.getRank().beats(card.getRank()) &&
					(null == nextHighestCardInSameSuitOfThoseRemaining || nextHighestCardInSameSuitOfThoseRemaining.getRank().beats(otherCard.getRank()))) {
				nextHighestCardInSameSuitOfThoseRemaining = otherCard;
			}
		}
		
		return (null != nextHighestCardInSameSuitOfThoseRemaining && !cardsInTrickSoFar.contains(nextHighestCardInSameSuitOfThoseRemaining) && this.cards.contains(nextHighestCardInSameSuitOfThoseRemaining));
	}
}
