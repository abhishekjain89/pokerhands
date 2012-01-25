
public class Card {
	
	int value;
	int suit;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Card(int value,int suit) {
		super();
		this.value = value;
		this.suit = suit;	
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	public boolean isPicture(){
		if(value>10){
			return true;
		}
		return false;
	}
	
	public char getSuitAlphabet(){
		if(this.getSuit()==0) return 'A';
		if(this.getSuit()==1) return 'B';
		if(this.getSuit()==2) return 'C';
		if(this.getSuit()==3) return 'D';
		return 'X';
	}
	
	public String toString(){
		return this.value+""+this.getSuitAlphabet();
	}

}
