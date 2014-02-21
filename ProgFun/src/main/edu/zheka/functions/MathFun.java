package edu.zheka.functions;

public class MathFun {
	
    private static int s = 1;
    private static int n = 0;
    private static int w = 2;
    private static int e = 3;

static int[][] positions = new int[][]{
    {} ,
    {s} ,
    { s , n} ,
    {s , w , e} ,
    {s , w , n , e} ,
    {s , w , n , e , e} , 
    {s , w , n , e , w, e} ,
    {s , w, n , e , w , n , e}
};   
    
  public static int getPos (int number , int posMe , int posTarget){
      int pos;
      pos = positions[number][(number - (posMe - posTarget))%number];
      printRes (pos);
      return pos;
  }
  private static void printRes (int pos){
      System.out.print("this guy is siting on the ");
      switch (pos) {
           case 1 :
              System.out.println("SOUTH");
              break;
           case 2:
               System.out.println("WEST");
               break;
           case 0:
               System.out.println("NORTH");
               break;
           case 3:
               System.out.println("EAST");
      }
  }
	
	public int factorial(int n) {
		if (n == 0) return 1;
		else return factorial(n-1) * n;
		
	}
	
	public int fibonachi(int n) {
		int n1 = 0;
		int n2 = 1;
		int r=1;
		if (n == 0) {
			return n1;
		}else{
		for(int i=1; i<n; i++ ){
			r = n1 + n2;
			n1 = n2;
			n2 = r;
			//System.out.println(r);
		}
		return r;
		}
	}
}
