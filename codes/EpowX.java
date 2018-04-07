package calculator;

//calculates e to the power of x by separating integer and decimal and recursively call power function
public class EpowX {
	public static final double Euler_Number=2.7182818284590452353602874713527;
	
	//separates exponent into integer and decimal part
	public static double calcExp(double exponent){
		double answer=1;
		double fact=1;
		double exp=1;
		
		double exponent_fac=exponent%1; // chopping off into integer part and decimal part
		double exponent_int=exponent-exponent_fac;// absolute value of the integer part.
		
		for(int i=1;i<100;i++){
			fact=fact*i;
			exp=exp*exponent_fac;
			answer= answer + (exp/fact);
		}
		double result=xPowerInty(Euler_Number,exponent_int); 
		return result*answer;
		
		
	}
	
	
	
	//performs x to the power of integer y
	public static double xPowerInty(double x, double y) {
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
	        return 1 / xPowerInty(x, -y);
	    } else {
	        // Positive power

	        double temp = xPowerInty(x,y/2);
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
