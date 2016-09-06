package cracking.recursion;

public class Q8_1 {
	//Write a method to generate the nth Fibonacci number.
	
	public static Integer getNthFiboIter(Integer n){
		Integer x = 0;
		Integer ret = 0;
		int i = 1;
		
		while(i < n){
			if(isFibo(x)){
				ret = x;
				i++;
			}
			x++;
		}
		return ret;
	}
	
	public static Integer getNthFiboRecur(Integer n){
		
	}
	
	public static boolean isFibo(Integer x){
		boolean ret = false;
		if(x == 0 ){
			ret = true;
		}
		if (x == (x -1) + (x - 2)){
			ret = false;
		}	
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println("1 fibo = " + getNthFiboIter(1));
		System.out.println("2 fibo = " + getNthFiboIter(2));
		System.out.println("3 fibo = " + getNthFiboIter(3));
		System.out.println("4 fibo = " + getNthFiboIter(4));
		System.out.println("5 fibo = " + getNthFiboIter(5));
		System.out.println("6 fibo = " + getNthFiboIter(6));
	}
}
