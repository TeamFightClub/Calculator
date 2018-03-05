// Need to add error handling for factorial. Check that fract part is 0 before proceeding. 

public class eternityMath {
	
	public static int getIntPart(double y){
	    int y_int;
		y_int=(int) y; //need to confirm casting does not round 
		return y_int;
	}
	
	public static double getFractPart(double y, int y_int){
		double y_fract;
		y_fract=y-y_int; 
		return y_fract;
	}
	
	public static double factorial(double n){
		
		double fact;
		
		if (n==0){
			fact=1;
		} else {
			fact=n*factorial(n-1);
		}
		
		return fact;
	}
	
	public static double abs(double x){
		if (x<0){
			return (-1)*x;
		}else{
			return x;
		}
	}

}
