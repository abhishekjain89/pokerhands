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
			//System.out.println(h.toString() + " = " + h.ValueToString());

		}
		System.out.println("ALMOST..");
		Collections.sort(all);


		/*for(Hand hand: all){
			System.out.println(hand.toString() + " = " + hand.ValueToString());
		}*/
		
		
		for(int j=0;j<all.size();j+=500){
			System.out.println(all.get(j).toString() + "\t" + all.get(j).ValueToString().substring(0, all.get(j).ValueToString().length()-1)+ "\t" + ((double)j*100)/(double)((all.size())));
		}
		for(int j=all.size()-500+1;j<all.size();j+=20){
			System.out.println(all.get(j).toString() + "\t" + all.get(j).ValueToString().substring(0, all.get(j).ValueToString().length()-1)+ "\t" + ((double)j*100)/(double)((all.size())));
		}
		System.out.println("DONE!");
	}



}
