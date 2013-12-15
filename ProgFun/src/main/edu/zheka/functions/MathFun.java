package edu.zheka.functions;

public class MathFun {
	
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
