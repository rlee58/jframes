import java.util.ArrayList;


public class Evaluator {
	
	private ArrayList<Integer> cpuValue = new ArrayList<Integer>();
	private ArrayList<Integer> cpuValue2 = new ArrayList<Integer>();
	private ArrayList<Integer> playerValue = new ArrayList<Integer>();
	private ArrayList<Integer> playerValue2 = new ArrayList<Integer>();
	private int[] cpuTotal = new int[2];
	private int[] playerTotal = new int[2];
	
	public Evaluator(ArrayList<Integer> cpu,ArrayList<Integer> player){
		cpuValue = cpu;
		playerValue = player;
		cpuValue2 = cpu;
		playerValue2 = player;
		for(int i=0;i<cpuValue.size();i++){
			if(cpuValue.get(i)>10){
				cpuValue.set(i, 10);
			}
			if(cpuValue.get(i)==1){
				cpuValue2.set(i, 11);
			}
		}for(int i=0;i<playerValue.size();i++){
			if(playerValue.get(i)>10){
				playerValue.set(i, 10);
			}
			if(playerValue.get(i)==11){
				playerValue2.set(i, 11);
			}
		}
	}
	
	public void evaluate(){
		int cpuTotal1=0;
		int cpuTotal2=0;
		for(int i=0;i<cpuValue.size();i++){
			cpuTotal1+=cpuValue.get(i);
		}
		for(int i=0;i<cpuValue.size();i++){
			cpuTotal2+=cpuValue2.get(i);
		}
	}
}
