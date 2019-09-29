
public class Card {
	private int number;
	private String suit; // Heart, Spade, Diamond, Club
	
	public Card(int n, String s) {
		this.number = n;
		this.suit = s;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}

	public void print() {
		System.out.printf("#Card: %d %s \n", number, suit);
	}

}
