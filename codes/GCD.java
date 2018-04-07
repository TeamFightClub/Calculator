package calculator;

/**
 * 
 * Calculates the Greatest Common Denominator.
 *
 */

public class GCD 
{
	public static int gcd(int x, int y){
		if(x<1 || y<1){
			throw new IllegalArgumentException(
                    "Wrong GCD input, no negatives");
		}
		int temp=x;
		if (x<y){
			x=y;
			y=temp;
		}
		while (y>0){
			temp=y;
			y=x%y;
			x=temp;
		}
		return x;
	}
	

}
