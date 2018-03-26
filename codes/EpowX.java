package calculator;

import java.util.Scanner;

public class EpowX {
	
	public static double ex(double exponent){
		double answer=1;
		double fact=1;
		double exp=1;
		
		// the previous code was only applicable to small values of exponent.
		double exponent_fac=exponent%1; // chopping off into integer part and decimal part
		double exponent_int=exponent-exponent_fac;// absolute value of the integer part.
		
		for(int i=1;i<100;i++){
			fact=fact*i;
			exp=exp*exponent_fac;
			answer= answer + (exp/fact);
		}
		double result=xpowerinty(2.7182818284590452353602874713527,exponent_int); 
		return result*answer;
		
		
	}
	
	/*public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Value of exponent :: ");
		Double exponent= sc.nextDouble();
		sc.close();	
		double answer=1;
		double fact=1;
		double exp=1;
		
		// the previous code was only applicable to small values of exponent.
		double exponent_fac=exponent%1; // chopping off into integer part and decimal part
		double exponent_int=exponent-exponent_fac;// absolute value of the integer part.
		
		for(int i=1;i<100;i++){
			fact=fact*i;
			exp=exp*exponent_fac;
			answer= answer + (exp/fact);
		}

		double result=xpowerinty(2.718281828,exponent_int); 
		System.out.println(result*answer);
		System.out.println(Math.pow(2.718281828, exponent));
	}*/
	
	
	
	
	public static double xpowerinty(double x, double y) {
	    y=(int)y;
		if ( y== 0) {
	        return 1.0;
	    }
	    if (y < 0) {
	        // Negative power.
	        if (x == 0) {
	            throw new IllegalArgumentException(
	                    "It's impossible to raise 0 to the power of a negative number");
	        }
	        return 1 / xpowerinty(x, -y);
	    } else {
	        // Positive power

	        double temp = xpowerinty(x,y/2);
	        if (y % 2 == 1) {
	            // Odd n
	            return x * temp * temp;
	        } else {
	            // Even n
	            return temp * temp;
	        }
	    }
	}
}