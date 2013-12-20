package Cards;

public abstract class ABSTRACT_CARD implements GameCard {
	protected String Name;
	protected String Prev;
	protected String Next;
	protected int[] Res = new int[8];
	protected int Epoch;
	protected int Players;
	
	// creat a card 
	// if some line is empty  just put 0
	
		public void createCard(String Nm, String Pr, String Nx, int ep, int pl){
			Name = Nm;
			Prev = Pr;
			Next = Nx;
			Epoch = ep;
			Players = pl;
		}
		
	// set all resources to our created card;
		
		public void setRes(int Clay , int Ore , int Stone , int Wood , int Glass , int Loom , int Papyrus , int Money){
			Res[0] = Clay ; 
			Res[1] = Ore;
			Res[2] = Stone;
			Res[3] = Wood;
			Res[4] = Glass;
			Res[5] = Loom;
			Res[6] = Papyrus;
			Res[7] = Money;
		}
		
		// get for everything
		
		public int[] getRes(){
			return Res;
		}

		public String getName(){
			return Name;
		}
		
		public String getPrev(){
			return Prev;
		}
		
		public String getNext(){
			return Next;
		}
		
		public int getEpoch(){
			return Epoch;
		}
		
		public int getPlayers(){
			return Players;
		}
}
