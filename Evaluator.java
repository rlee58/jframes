import java.util.ArrayList;


public class Evaluator {
	
	private ArrayList<Integer> playerValue = new ArrayList<Integer>();
	private ArrayList<Integer> cpuValue = new ArrayList<Integer>();
	private int[] playerTotal = new int[5];
	private int[] cpuTotal = new int[5];
	private boolean cpuAce = false;
	
	public Evaluator(ArrayList<Integer> player,ArrayList<Integer> cpu){
		cpuValue = cpu;
		playerValue = player;
		for(int i=0;i<playerValue.size();i++){
			if(playerValue.get(i)>10){
				playerValue.set(i, 10);
			}
		}for(int i=0;i<cpuValue.size();i++){
			if(cpuValue.get(i)>10){
				cpuValue.set(i, 10);
			}
		}
	}
	
	public void evaluate(){
		int playerCount = 0;
		int playerAceCount = 0;
		for(int i=0;i<playerValue.size();i++){
			playerCount+=playerValue.get(i);
		}
		playerTotal[0]=playerCount;
		
		for(int i=0;i<playerValue.size();i++){
			if(playerValue.get(i)==1){
				playerAceCount++;
			}
		}
		if(playerAceCount==4){
			int ten = 0;
			for(int i=1;i<=4;i++){
				playerTotal[i]=playerCount;
				ten+=10;
				playerTotal[i]+=ten;
			}
		}
		if(playerAceCount>=3){
			int ten = 0;
			for(int i=1;i<=3;i++){
				playerTotal[i]=playerCount;
				ten+=10;
				playerTotal[i]+=ten;
			}
		}
		if(playerAceCount>=2){
			int ten = 0;
			for(int i=1;i<=2;i++){
				playerTotal[i]=playerCount;
				ten+=10;
				playerTotal[i]+=ten;
			}
		}
		if(playerAceCount>=1){
			playerTotal[1]=playerCount+10;
		}
		
		int cpuCount = 0;
		int cpuAceCount = 0;
		for(int i=0;i<cpuValue.size();i++){
			cpuCount+=cpuValue.get(i);
		}
		cpuTotal[0]=cpuCount;
		
		for(int i=0;i<cpuValue.size();i++){
			if(cpuValue.get(i)==1){
				cpuAceCount++;
			}
		}
		if(cpuAceCount==4){
			int ten = 0;
			for(int i=1;i<=4;i++){
				cpuTotal[i]=cpuCount;
				ten+=10;
				cpuTotal[i]+=ten;
			}
		}
		if(cpuAceCount>=3){
			int ten = 0;
			for(int i=1;i<=3;i++){
				cpuTotal[i]=cpuCount;
				ten+=10;
				cpuTotal[i]+=ten;
			}
		}
		if(cpuAceCount>=2){
			int ten = 0;
			for(int i=1;i<=2;i++){
				cpuTotal[i]=cpuCount;
				ten+=10;
				cpuTotal[i]+=ten;
			}
		}
		if(cpuAceCount>=1){
			cpuTotal[1]=cpuCount+10;
		}
	}
	public void updateValue(ArrayList<Integer> arr,int turn){
		for(int i=0;i<arr.size();i++){
			if(arr.get(i)>10){
				arr.set(i, 10);
			}
		}
		if(turn==0){
			playerValue=arr;
		}else if(turn==1){
			cpuValue=arr;
		}
		evaluate();
	}
	public boolean blackJack(int i){
		if(i==0){
			for(int j=0;j<5;j++){
				if(playerTotal[j]==21){
					return true;
				}
			}
		}else if(i==1){
			for(int j=0;j<5;j++){
				if(cpuTotal[j]==21){
					return true;
				}
			}
		}
		return false;
	}
	public int getHighest(int turn){
		if(turn==0){
			for(int i=4;i>=0;i--){
				if(playerTotal[i]>0 && playerTotal[i]<=21){
					return playerTotal[i];
				}
			}
		}else if(turn==1){
			for(int i=4;i>=0;i--){
				if(cpuTotal[i]>0 && cpuTotal[i]<=21){
					return cpuTotal[i];
				}
			}
		}
		return -1;
	}
	public int getPlayerTotal(int i){
		return playerTotal[i];
	}
	public int getCpuTotal(int i){
		return cpuTotal[i];
	}
	public boolean caseCheck(int num){
		if(cpuTotal[1]!=0){
			cpuAce = true;
		}
		if(cpuAce){
			if(num==0){
				if(cpuTotal[0]<=17 && cpuTotal[0]>0){
					return true;
				}
			}
			if(num==1){
				if(cpuTotal[1]<=17 && cpuTotal[1]>0){
					return true;
				}
			}
			if(num==2){
				if(cpuTotal[2]<=17 && cpuTotal[2]>0){
					return true;
				}
			}
			if(num==3){
				if(cpuTotal[3]<=17 && cpuTotal[3]>0){
					return true;
				}
			}
			if(num==4){
				if(cpuTotal[4]<=17 && cpuTotal[4]>0){
					return true;
				}
			}
		}else{
			if(num==0){
				if(cpuTotal[0]<17 && cpuTotal[0]>0){
					return true;
				}
			}
			if(num==1){
				if(cpuTotal[1]<17 && cpuTotal[1]>0){
					return true;
				}
			}
			if(num==2){
				if(cpuTotal[2]<17 && cpuTotal[2]>0){
					return true;
				}
			}
			if(num==3){
				if(cpuTotal[3]<17 && cpuTotal[3]>0){
					return true;
				}
			}
			if(num==4){
				if(cpuTotal[4]<17 && cpuTotal[4]>0){
					return true;
				}
			}
		}
		return false;
	}
	
}
