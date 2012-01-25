
public class Dial {
	
	int[] counters;
	int max = 13;
	int min = 1;
	int n;
	public Dial(int n,int mx,int mn){
		counters = new int[n];
		for(int i=0;i<n;i++)
			counters[i]=mn;
		this.n = n;
		max = mx;
		min = mn;
	}
	
	public void increment(){
		for(int i=0;i<n;i++){
			counters[i]++;
			if(counters[i]>max) counters[i]=min;
			else return;		
		}
	}
	
	public boolean isFinish(){
		
		for(int i=0;i<n;i++){
			if(counters[i]!=max) return false;
		}
		return true;
	}

}
