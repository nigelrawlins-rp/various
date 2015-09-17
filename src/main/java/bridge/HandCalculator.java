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
public class HandCalculator {
	
	private int totalPossibleSequences = 0;
	
	private int currentNorthSouthMaximum = 0;
	private int currentEastWestMaximum = 0;
	
	private List<Card> cardsForNorthSouthMaximum = new ArrayList<Card>();
	private List<Card> cardsForEastWestMaximum = new ArrayList<Card>();
	
	private int handSize = 0;
	
	private boolean useAdjacentCardsBehaviour;
	
	public void processHand(final boolean useAdjacentCardsBehaviour) {
		
		this.useAdjacentCardsBehaviour = useAdjacentCardsBehaviour;
		
		this.handSize = validateAllHandsHaveSameNumberOfCards();
		
		final Player leader = findLeader();
		
		final List<Card> fullCardList = new ArrayList<Card>();
		fullCardList.addAll(Player.WEST.getCards());
		fullCardList.addAll(Player.NORTH.getCards());
		fullCardList.addAll(Player.EAST.getCards());
		fullCardList.addAll(Player.SOUTH.getCards());
		
		List<Card> playableCards = leader.derivePlayableCards(null, new ArrayList<Card>(), fullCardList, true);
		
		playHand(playableCards, new ArrayList<Card>(), leader, 0, 0, fullCardList);
		
		printFinalResults();
	}
	
	private int validateAllHandsHaveSameNumberOfCards() {
		
		Integer handSize = null;
		
		for (Player player : Player.values()) {
			if (null == handSize) {
				handSize = player.getCards().size();
			}
			else if (!handSize.equals(player.getCards().size())) {
				throw new HandSizesUnequalException("The players do not all have the same hand size.");
			}
		}
		
		return handSize.intValue();
	}
	
	private Player findLeader() {
		
		for (Player player : Player.values()) {
			if (player.isLeader()) {
				return player;
			}
		}
		
		throw new NoLeaderException("Initial leader has not been specified.");
	}
	
	public void playHand(final List<Card> playableCards, final List<Card> cardsPlayedSoFar, final Player currentPlayer,
			final int northSouthTrickCount, final int eastWestTrickCount, final List<Card> cardsNotYetPlayed) {
		
		for (Card playableCard : playableCards) {
			
			final List<Card> cardsPlayedSoFarPlusPlayableCard = new ArrayList<Card>(cardsPlayedSoFar);
			cardsPlayedSoFarPlusPlayableCard.add(playableCard);
			
			Card cardWhichMustBeFollowed = null;
			
			Player nextPlayer = currentPlayer;
			
			int northSouthTrickCountAfterNextCard = northSouthTrickCount;
			int eastWestTrickCountAfterNextCard = eastWestTrickCount;
			
			if (hasTrickBeenCompleted(cardsPlayedSoFarPlusPlayableCard)) {
				
				final Trick trick = new Trick();
				trick.setLeader(currentPlayer.nextPlayer());
				trick.setFirstCard(cardsPlayedSoFarPlusPlayableCard.get(cardsPlayedSoFarPlusPlayableCard.size() - 4));
				trick.setSecondCard(cardsPlayedSoFarPlusPlayableCard.get(cardsPlayedSoFarPlusPlayableCard.size() - 3));
				trick.setThirdCard(cardsPlayedSoFarPlusPlayableCard.get(cardsPlayedSoFarPlusPlayableCard.size() - 2));
				trick.setFourthCard(cardsPlayedSoFarPlusPlayableCard.get(cardsPlayedSoFarPlusPlayableCard.size() - 1));
				
				nextPlayer = trick.winner();
				
				if (Player.WEST.equals(nextPlayer) || Player.EAST.equals(nextPlayer)) {
					printPossibleSequence(cardsPlayedSoFarPlusPlayableCard,	northSouthTrickCountAfterNextCard, eastWestTrickCountAfterNextCard);
					continue;
				}
				
				nextPlayer.setLeader(true);
				
				cardWhichMustBeFollowed = null;
				
				if (nextPlayer.equals(Player.NORTH) || nextPlayer.equals(Player.SOUTH)) {
					northSouthTrickCountAfterNextCard++;
				}
				else {
					eastWestTrickCountAfterNextCard++;
				}
			}
			else {
			    
				nextPlayer = currentPlayer.nextPlayer();
			    nextPlayer.setLeader(false);
			    
				cardWhichMustBeFollowed = cardsPlayedSoFarPlusPlayableCard.get((cardsPlayedSoFarPlusPlayableCard.size()/4)*4);
			}
			
			final List<Card> cardsNotYetPlayedMinusPlayableCard = new ArrayList<Card>(cardsNotYetPlayed);
			cardsNotYetPlayedMinusPlayableCard.remove(playableCard);
			
			final List<Card> newPlayableCards = nextPlayer.derivePlayableCards(cardWhichMustBeFollowed, cardsPlayedSoFarPlusPlayableCard, cardsNotYetPlayedMinusPlayableCard, this.useAdjacentCardsBehaviour);
			
			if (cardsPlayedSoFarPlusPlayableCard.size() == (this.handSize * 4)) {
				
				printPossibleSequence(cardsPlayedSoFarPlusPlayableCard,	northSouthTrickCountAfterNextCard, eastWestTrickCountAfterNextCard);
				
				System.exit(0);
				
				if (northSouthTrickCountAfterNextCard > this.currentNorthSouthMaximum) {
					this.currentNorthSouthMaximum = northSouthTrickCountAfterNextCard;
					this.cardsForNorthSouthMaximum.clear();
					this.cardsForNorthSouthMaximum.addAll(cardsPlayedSoFarPlusPlayableCard);
				}
				
				if (eastWestTrickCountAfterNextCard > this.currentEastWestMaximum) {
					this.currentEastWestMaximum = eastWestTrickCountAfterNextCard;
					this.cardsForEastWestMaximum.clear();
					this.cardsForEastWestMaximum.addAll(cardsPlayedSoFarPlusPlayableCard);
				}
				
				this.totalPossibleSequences++;
				
				return;
			}
			
			playHand(newPlayableCards, cardsPlayedSoFarPlusPlayableCard, nextPlayer, northSouthTrickCountAfterNextCard, eastWestTrickCountAfterNextCard, cardsNotYetPlayedMinusPlayableCard);
		}
	}
	
	private boolean hasTrickBeenCompleted(final List<Card> cards) {
		return ((((double) cards.size())/4) - Math.floor(cards.size()/4) < 0.00000001) && cards.size() > 0;
	}
	
	private void printPossibleSequence(
			final List<Card> cardsPlayedSoFarPlusPlayableCard,
			int newNorthSouthTrickCount, int newEastWestTrickCount) {
		for (Card card : cardsPlayedSoFarPlusPlayableCard) {
			System.out.print(card.getShortName() + ",");
		}
		
		System.out.print("  North/South trick count: " + newNorthSouthTrickCount + ", East/West trick count: " + newEastWestTrickCount);
		System.out.print("\n");
	}
	
	private void printFinalResults() {
		
		System.out.print("Total: " + totalPossibleSequences + "\n");
		
		System.out.print("Maximum available to north-south is: " + this.currentNorthSouthMaximum + " with sequence:\n");
		
		for (Card card : this.cardsForNorthSouthMaximum) {
			System.out.print(card.getShortName() + ",");
		}
		
		System.out.print("\n");
		
		System.out.print("Maximum available to east-west is: " + this.currentEastWestMaximum + " with sequence:\n");
		
		for (Card card : this.cardsForEastWestMaximum) {
			System.out.print(card.getShortName() + ",");
		}
	}
}
