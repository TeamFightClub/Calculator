import java.util.Scanner;

//Using absolute tolerance but if we want to work on really small numbers a relative tolerance //may be better


public class rootFunc extends eternityMath{
	
	public rootFunc(){
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Value of n to be used :: ");
		int value1= sc.nextInt();
		int n=value1;
		
		System.out.print("Value to be rooted :: ");
		double value2= sc.nextDouble();
		double x=value2;
		
		double n_root=getRoot(x,n);
		System.out.println("The "+n+" root of "+x+" is "+n_root);
		sc.close();
		
		
	}

	public static double getRoot(double x, double n) {
	
			//Check if x is positive
			if (x<0) {
			 //return error message 
			}
	
			//check if root is positive and integer
			int n_int=getIntPart(n);
			double n_fract=getFractPart(n, n_int);
	
	
			if (n<0){
				 //return error message 
			} else if (n_fract != 0){					
				//return error message 	
			}
			
			//make guess x0
			double x0;
			if (x>=1){
				x0=x/n;
			} else{ //roots of number x less than 1 are larger than x
				x0=x*n;
			}
			//set tolerance to 1*10^(-12)
			double eps=powFuncs.getPow(10,-12);	
			double x_k=x0;
			double delta_xk=x0;
						
			while ( eps<abs(delta_xk)) {
				delta_xk=1/n*(x/powFuncs.getPow(x_k, (n-1))-x_k);
				x_k=x_k+delta_xk;
			}	
	
			return x_k;
		}
}
