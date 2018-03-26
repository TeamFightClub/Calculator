package calculator;

public class GCD {
	
	
	/*public static void main(String[] args){
		double x=2.25;
		String xString = String.valueOf(x);
		System.out.println(xString);
		String[] parts = xString.split("\\.");
		int count=parts[1].length();
	
		
		int b=(int)EpowX.xpowerinty(10, count);
		int a=Integer.parseInt(parts[1])+Integer.parseInt(parts[0])*b;
		System.out.println("a is "+a +" and b is "+b);
		int c=gcd(a,b);
		a=a/c;
		b=b/c;
		System.out.println("The reduced fraction is "+a+"/"+b);
		
		
		
	}*/
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
