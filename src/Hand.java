import java.util.ArrayList;


public class Hand implements Comparable<Hand>{
	
	ArrayList<Card> cards = new ArrayList<Card>();
	int[] savedVal = null;
	public int[] getVal(){
		
		if(savedVal==null){
			savedVal = this.Value();
		}
		return savedVal;
	}
	
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
	int groupValue = 0;
	public int GroupCount(int size){
		groupValue=0;
		int[] count = new int[15];
		
		for(int i=0;i<15;i++)
			count[i]=0;
		
		for(Card c: cards){
			count[c.getValue()]++;
		}
		
		int groupCount = 0;
		
		for(int i=0;i<15;i++){
			if(count[i]==size){
				groupCount++;
				if(i>groupValue) groupValue=i;
			}
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
		if(this.GroupCount(3)==1) return true;
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
		if(this.GroupCount(3)==1 && this.GroupCount(2)==1) {
			this.GroupCount(3);
			return true;
		}
		
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
	
	public int[] Value(){
		int[] value = new int[10];
		
		for(int i=0;i<10;i++)
			value[i]=0;
		
		if(this.isRoyalFlush()) value[0] = this.largest().value;
		if(this.isStraightFlush()) value[1] = this.largest().value;
		if(this.isQuads()) value[2] = groupValue;
		if(this.isFullHouse()) value[3] = groupValue;
		if(this.isFlush()) value[4] = this.largest().value;
		if(this.isStraight()) value[5] = this.largest().value;
		if(this.isTrips()) value[6] = groupValue;
		if(this.isTwoPair()) value[7] = groupValue;
		if(this.isOnePair()) value[8] = groupValue;
		value[9]=this.largest().getValue();
		return value;	
	}

	@Override
	public int compareTo(Hand arg0) {
		
		for(int i=0;i<10;i++){
			if(getVal()[i]>arg0.getVal()[i]) return 1;
			else if(getVal()[i]<arg0.getVal()[i]) return -1;
		}
		return 0;
	}
	
	public String toString(){
		String ret = "";
		
		for(Card c: cards){
			ret += c.toString()+" ";
		}
		
		return ret;
	}
	
	public String ValueToString(){
		String ret = "";
		int[] val = this.getVal();
		for(int i=0;i<10;i++){
			ret+=val[i]+",";
		}
		return ret;
	}
	

}
