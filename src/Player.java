import java.util.ArrayList;

public class Player {

	private String name;
	private int chips;
	private int bet = 0;
	private ArrayList<Card> oneRoundCard;

	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}

	public String get_name() {
		return name;
	}

	public int make_bet() {
		if (chips > 0) {
			if (chips % 2 == 0)
				bet = chips / 2;
			else
				bet = chips / 2 + 1;

		} else
			bet = 0;
		return bet;
	}

	public void setOneRoundCard(ArrayList<Card> cards) {
		oneRoundCard = cards;
	}

	public boolean hit_me() {

		if (getTotalValue() > 16)
			return false;
		else
			return true;

	}

	public int getTotalValue() {
		int TotalValue = 0, AAmount = 0, ranks;
		for (int i = 0; i < oneRoundCard.size(); i++) {
			ranks = oneRoundCard.get(i).getRank();
			if (ranks == 1)
				AAmount += 1;
			else if (ranks > 10)
				TotalValue += 10;
			else
				TotalValue += ranks;
		}
		while (AAmount > 0) {
			if (TotalValue + AAmount * 11 > 21) {
				TotalValue += 1;
				AAmount -= 1;
			} else {
				TotalValue += 11;
				AAmount -= 1;
			}
		}
		return TotalValue;
	}

	public int get_current_chips() {
		return chips;
	}

	public void increase_chips(int diff) {
		chips += diff;
	}

	public void say_hello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}

}
