package Cards;

public abstract class AbstractCard implements GameCard {
	protected String name;
	protected String prev;
	protected String next;
	protected int[] res = new int[8];
	protected int epoch;
	protected int playersNum;
	
	// constructor for dif card
		
		public AbstractCard(String nm , String pr , String nx , int ep , int pln){
			this.name = nm;
			this.prev = pr;
			this.next = nx;
			this.epoch = ep;
			this.playersNum = pln;
		}
		
	//easy const
		
		public AbstractCard(String nm , int ep , int pln){
			this.name = nm;
			this.epoch = ep;
			this.playersNum = pln;			
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
			return res;
		}

		public String getName(){
			return name;
		}
		
		public String getPrev(){
			return prev;
		}
		
		public String getNext(){
			return next;
		}
		
		public int getEpoch(){
			return epoch;
		}
		
		public int getPlayers(){
			return playersNum;
		}
}
