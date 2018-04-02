package calculator;

public class XpowY {
	public static double answer=1;
	public static double base;
	public static double exponent ;

	public static double xpowy(double answer) {
		answer=answer*exponent;
		return answer;
	}
	
	
	
	public static double posBase(double base, double exp){
		if (exp%1==0){
			return EpowX.xpowerinty(base, exp);
		}
		double log=Logarithms.Logarithms(base);
		double expo_fac=exp%1;
		double expo_int=exp-expo_fac;
		double power=EpowX.xpowerinty(base, expo_int);
		double antilog=log*expo_fac;
		answer=EpowX.ex(antilog);
		answer=answer*power;
		return answer;
		
	}
	;
	public static double negBase(double base,double exp){
		double result;
		if(base==0){
			if(exp<0){
				throw new IllegalArgumentException(
	                    "It's impossible to raise 0 to the power of a negative number");
			}
			else if(exp==0){
				return 1;
			}
			else{
				return 0;
			}
		}
		base=-base;
		String xString = String.valueOf(base);
		System.out.println(xString);
		String[] parts = xString.split("\\.");
		int count=parts[1].length();
		int b=(int)EpowX.xpowerinty(10, count);
		int a=Integer.parseInt(parts[1])+Integer.parseInt(parts[0])*b;
		System.out.println("a is "+a +" and b is "+b);
		int c=GCD.gcd(a,b);
		a=a/c;
		b=b/c;

		if(b%2==0){
			throw new IllegalArgumentException(
                    "It's impossible to take even numberth root of a negative number.");
		}
		else if(a%2==0){
			result=posBase(base,exp);
		}
		else{
			result=-posBase(base,exp);
		}
		return result;
		
	}
	public static double pow(double base, double exponent){
		if(base>0){
			answer=posBase(base,exponent);
		}
		else{
			answer=negBase(base,exponent);
		}
		return answer;
		
	}

}
