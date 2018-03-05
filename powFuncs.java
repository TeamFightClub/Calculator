import java.util.Scanner;


//Need to add exception to be thrown when negative base is used with non-integer powers //and -integer powers as those are not defined in the set of real numbers

//Can just use an absolute tolerance for non integer exponents (I initially forgot how exponents work but solution of c=a^b where 0<b<1 always has 1<c<a  )

//check overlap with nth power and negative integer exponents (may be better to implement an nth root algorithm )
 
public class powFuncs extends eternityMath{ 
	
	public powFuncs(){
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Value of x to be used :: ");
		double value1= sc.nextDouble();
		double x=value1;
		
		System.out.print("Value of y to be used :: ");
		double value2= sc.nextDouble();
		double y=value2;
		
		
		double thisPow=getPow(x,y);
		System.out.println(x+" to the power of "+y+" is "+thisPow);
		sc.close();
		
		
	}
	
	public static double getPow (double x, double y) {
		
		//check if exponent is negative. If negative find solution using positive //exponent and return 1 divided by that solution
				if (y<0){ 
				
					return 1/getPow(x, (-1)*y);	
				
				}
		int y_int;
		double y_fract;
		y_int=getIntPart(y);
		y_fract=getFractPart(y, y_int);
		
		if (y_fract==0){
		
			return intPow(x,y_int);
		
		//non integer powers can be decomposed into the product of their integer and //fractional powers
		}else{
			return intPow(x,y_int)*fractPow(x,y_fract);
				
				}
		
			}
	
	public static double intPow (double x, double y){
	//This method performs integer exponentiation using the method of //exponentiation by squaring (recursive version)
			
		if ( y==0){
			
			return 1;
		
		}else if((y%2)==1){
		
			return x*intPow(x,y-1);
		
		}else{
			double temp=intPow(x,y/2);
			return  temp*temp;
		
		}
		
	
	}
	
	public static double fractPow (double x, double y_fract){
		//Use algorithm base on identity x^y_fract=e^(y_fract*log(x))
		
		//tolerance set to 1*10^(-12)
		double eps;
		eps=getPow(10,-12);
			
		//find taylor expansion approximation of e^(x*log(y_fract)) with tolerance eps
			
		double approx=0;//taylor expansion approximation
		double taylor_n=1; //first term in expansion is 1
		int n=0;
		double log_x=logFunc.getNatLog(x);
		double ylogx=y_fract*log_x;
		
		while (eps<taylor_n){
			approx=approx+taylor_n;
			++n;
			double fac_n=factorial(n);
			taylor_n=1/fac_n*intPow(ylogx, n);
		}
		
		return approx;
		}

	}
