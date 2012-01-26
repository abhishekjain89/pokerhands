import java.util.Scanner;


public class Parser {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(sc.hasNext()){
			String[] line = sc.nextLine().split("\t");
			//System.out.println("all[" + (i++) +"] = new hand(\"" +line[0] +"\",\"" + line[1] + "\"," + line[2] +"," + line[3] + ")");
			System.out.println(line[1]+"," +line[0]+");");
		}
		
	}

}
