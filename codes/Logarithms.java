package calculator;
import java.util.Scanner;
import java.lang.Math;

public class Logarithms {

	public static double Logarithms(double value)
	{
		double x=value;
		int sign=1;
		int e=0;
		if(x<0){
			//System.out.print("No Negative allowed");
			//errsz();
			try {
				throw new NegativeLog();} 
			catch (NegativeLog e) {
				e.printStackTrace();}
			return 0;
		}else if(x==0){
			System.out.print("Negative Infinity");
			return 0;
		}
		else{
			if(x>1.5){
				sign=-1;
				x=1/x;
				
			} 
			while(x<0.5){
				x = x*2.718281828;
				e++;
			}
			double sum=0;
			x=x-1;
			double pow=x;
			for(int i=1; i<100; i++){
				
				if(i%2==1){
					sum= (sum+(pow/i));
				}else{
					sum= (sum-(pow/i));
				}
				pow=pow*x;
			}
		
			sum=sum - e;
			sum=sum*sign;
	
			return sum;
		}
	}
	public static String errsz()
	{
		System.out.println("aaaaaa");
		return "No Negative Allowed";
	}
	/*public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			System.out.print("Value of log to be calculated :: ");
			Double value= sc.nextDouble();
			sc.close();
			double log = Logarithms(value);
		
				System.out.println("The log value of "+log + "= "+value+" using Java library = " + Math.log(value));
	}*/
}
