package calculator;

/**
 * Calculates the Natural Log using Taylor Series Expansion
 * 
 *
 */

public class Logarithms {
	
	public static final double Euler_Number=2.7182818284590452;
	
	public static double Logarithms(double value)
	{
		double x=value;
		int sign=1;
		int e=0;
			//if number is very large then compacts it
			if(x>1.5){
				sign=-1;
				x=1/x;
				
			} 
			while(x<0.5){
				x = x*Euler_Number;
				e++;
			}
			double sum=0;
			x=x-1;
			double pow=x;
			
			// Taylor series expansion
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
