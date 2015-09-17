/**
 * 
 */
package bridge;

/**
 * @author Nigel
 *
 */
public class Trick {
	
	private Player leader;
	
	private Card firstCard;
	private Card secondCard;
	private Card thirdCard;
	private Card fourthCard;
	
	public void setLeader(Player leader) {
		this.leader = leader;
	}
	
	public void setFirstCard(Card firstCard) {
		this.firstCard = firstCard;
	}
	
	public void setSecondCard(Card secondCard) {
		this.secondCard = secondCard;
	}
	
	public void setThirdCard(Card thirdCard) {
		this.thirdCard = thirdCard;
	}
	
	public void setFourthCard(Card fourthCard) {
		this.fourthCard = fourthCard;
	}
	
	public Player winner() {
		
		Card currentWinningCard = this.firstCard;
		
		if (!currentWinningCard.beats(this.secondCard)) {
			currentWinningCard = this.secondCard;
		}
		
		if (!currentWinningCard.beats(this.thirdCard)) {
			currentWinningCard = this.thirdCard;
		}
		
		if (!currentWinningCard.beats(this.fourthCard)) {
			currentWinningCard = this.fourthCard;
		}
		
		if (currentWinningCard.equals(this.firstCard)) {
			return this.leader;
		}
		
		if (currentWinningCard.equals(this.secondCard)) {
			return this.leader.nextPlayer();
		}
		
		if (currentWinningCard.equals(this.thirdCard)) {
			return this.leader.nextPlayer().nextPlayer();
		}
		
		return this.leader.nextPlayer().nextPlayer().nextPlayer();
	}
}
