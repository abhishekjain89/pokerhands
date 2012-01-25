import java.util.ArrayList;


public class Hand implements Comparable<Hand>{
	
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public Card largest(){
		int val=0;
		Card card = null;
		
		for(Card c : cards){
			if(c.getValue() > val){
				card = c;
				val = c.getValue();
			}
		}
		
		return card;
	}
	
	public Card smallest(){
		int val=20;
		Card card = null;
		
		for(Card c : cards){
			if(c.getValue() < val){
				card = c;
				val = c.getValue();
			}
		}
		
		return card;
	}
	
	public int suitCount(int suit){
		int count=0;
		
		for(Card c: cards){
			if(c.getSuit()==suit)
				count++;
		}
		
		return count;	
	}
	
	public int largestSuit(){
		int count=0;
		int suit=0;
		for(int i=0;i<4;i++){
			int c = this.suitCount(i);
			
			if(c>count){
				suit=i;
				count=c;
			}
		}
		
		return suit;
	}
	
	public int GroupCount(int size){
		
		int[] count = new int[15];
		
		for(int i=0;i<15;i++)
			count[i]=0;
		
		for(Card c: cards){
			count[c.getValue()]++;
		}
		
		int groupCount = 0;
		
		for(int i=0;i<15;i++){
			if(count[i]==size)
				groupCount++;
		}
		
		return groupCount;
		
	}
	
	public void add(Card card){
		this.cards.add(card);
	}
	
	public int PictureCount(){
		int count = 0;
		for(Card c: cards){
			if(c.isPicture()) count++;
		}
		return count;
	}
	
	public boolean containsValue(int val){
		for(Card c: cards){
			if(c.getValue()==val) return true;
		}
		return false;
	}
	
	public boolean isOnePair(){
		if(this.GroupCount(2)==1) return true;
		return false;
	}
	
	public boolean isTwoPair(){
		if(this.GroupCount(2)==2) return true;
		return false;
	}
	
	public boolean isTrips(){
		int suit = this.largestSuit();
		int size = this.suitCount(suit);
		if(size>=3) return true;
		return false;
	}
	
	public boolean isStraight(){
		int val = this.largest().getValue();
		
		for(int i=val-1;i>val-5;i--){
			if(!this.containsValue(i)) return false;
		}
		return true;
	}
	
	public boolean isFlush(){
		int suit = this.largestSuit();
		int size = this.suitCount(suit);
		if(size==5) return true;
		return false;
	}
	
	public boolean isFullHouse(){
		if(this.PictureCount()==5) return true;
		return false;
	}
	
	public boolean isQuads(){
		if(this.GroupCount(4)==1) return true;
		return false;
	}
	
	public boolean isStraightFlush(){
		if(isFlush() && isStraight()) return true;
		return false;
	}
	
	public boolean isRoyalFlush(){
		if(isFlush() && isStraight() && this.largest().getValue()==14) return true;
		return false;
	}
	
	int Value(){
		int value = 0;
		if(this.isRoyalFlush()) value+=102400;
		if(this.isStraightFlush()) value+=51200;
		if(this.isQuads()) value+=25600;
		if(this.isFullHouse()) value+=12800;
		if(this.isFlush()) value+=6400;
		if(this.isStraight()) value+=3200;
		if(this.isTrips()) value+=1600;
		if(this.isTwoPair()) value+=800;
		if(this.isOnePair()) value+=200;
		value+=this.largest().getValue();
		return value;	
	}

	@Override
	public int compareTo(Hand arg0) {
		if(this.Value()>arg0.Value()) return 1;
		else if(this.Value()<arg0.Value()) return -1;
		return 0;
	}
	
	public String toString(){
		String ret = "";
		
		for(Card c: cards){
			ret += c.toString()+" ";
		}
		
		return ret;
	}
	

}
