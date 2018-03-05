//Priority is natural logarithm as above functions need it 
//Need to extend to include log base 10 

import java.util.Scanner;

public class logFunc extends eternityMath{
	
	public logFunc(){
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Value of log to be calculated :: ");
		double value= sc.nextDouble();
		double x=value;
		double log_x=getNatLog(x);
		System.out.println("The log value of "+x+" is "+log_x);
		sc.close();
		
	}

	public static double getNatLog(double x) {
		//use borchardt's algorithm 
		
		double a0=(1+x)/2;
		double b0=rootFunc.getRoot(x,2);
		double ak=a0;
		double bk=b0;
		//set tolerance to 1*10^(-12)
		double eps=powFuncs.getPow(10,-12);
		
		while (eps<abs(ak-bk)){
			ak=(ak+bk)/2;
			bk=rootFunc.getRoot((ak*bk), 2);
		}
				
		double log_x=2*(x-1)/(ak+bk);
		return log_x;
	}
}
