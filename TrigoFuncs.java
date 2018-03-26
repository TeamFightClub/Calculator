package calculator;
import java.util.Scanner;

public class TrigoFuncs {
	// ----------Converting Degrees to Radians----------
	public static double convert(double x){
		double radians;
		radians = (x*22)/(7*180);
		return radians;
	}
	
	//----------------Trigo Functions-------------------
	public static double SinFuncs(double x) {
		double sin=0;
		double fact=1;
		double currX=x;
		int sign=1;
		double update=x*x;
        for(int i=1; i<=100; i++){
            sin= sin+ sign*currX/fact;
            currX=currX*update;
            sign =sign*(-1);
            fact=fact *(i*2)*(i*2+1);
        }
        return sin;
		
	}
	
	
	
public static double CosFuncs(double x) {	
		double cos=0;
		double fact=1;
		double currX=1;
		int sign=1;
		double update=x*x;
        for(int i=1; i<=100; i++){
            cos= cos+ sign*currX/fact;
            currX=currX*update;
            sign =sign*(-1);
            fact=fact *(i*2)*(i*2-1);
        }
        return cos;		
	}
	
	
	public static double TanFuncs(double x) {
		
        double numerator=SinFuncs(x);
        double denominator = CosFuncs(x);
        double tan = numerator/denominator;
        return tan;
		
	}
	
	
	//--------------------Main Function---------------------
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Angle :: ");
		
		double value= sc.nextDouble();
		
		sc.close();
		double reduce=value;
		
		
		value=convert(value);
		reduce=convert(reduce);
		System.out.println("The value in radians is :: " + reduce);
		
		//This takes care of the absurd high value when entered in the calculator 
		// And also takes care if the value entered in degree is negative
		//----------------------------------------------------------------------
		while(reduce>6.2831853072 ){
			reduce=reduce-6.2831853072;
		}
		while(reduce<0 ){
			reduce=reduce+6.2831853072;
		}
		System.out.println("The reduced value of the angle is :: "+ reduce);
		//----------------------------------------------------------------------
		
		System.out.println("Value of Sine = " + SinFuncs(reduce) + "  Value of Sine Using Math Functions =  " + Math.sin(value));
		
		System.out.println("Value of Cosine = " + CosFuncs(reduce) + "  Value of Cosine Using Math Functions =  " + Math.cos(value));
	
		System.out.println("Value of Tangent = " + TanFuncs(reduce) + "  Value of Tangent Using Math Functions =  " + Math.tan(value));
		
		
	}
}
