import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Solver {

	public static void main(String[] args){

		ArrayList<Hand> all = new ArrayList<Hand>();
		int total = 100000;
		
		Random generator = new Random();
		for(int j=0;j<total;j++){
			
		
		Hand h = new Hand();
		for(int i=0;i<5;i++){
			Card card = new Card(generator.nextInt(14)+1, generator.nextInt(4));
			h.add(card);
		}

		all.add(h);
		System.out.println(h.toString() + " = " + h.Value());
		
		}

		Collections.sort(all);
		
		for(int j=0;j<all.size()-1;j++){
			if(all.get(j).Value()==all.get(j+1).Value())
				all.remove(j+1);
		}
		
		/*for(Hand hand: all){
			System.out.println(hand.toString() + " = " + hand.Value());
		}*/
		
		for(int j=0;j<all.size();j++){
			System.out.println(all.get(j).toString() + " = " + ((double)j*100)/(double)((all.size())));
		}

	}



}
