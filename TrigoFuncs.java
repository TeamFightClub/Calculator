package testing;
import java.util.Scanner;
//import java.lang.Math; //----------> using this for the math.pow(x,y) = x^y ---> no need anymore
import java.math.BigDecimal;
import java.math.RoundingMode;

//Things working in this code
//1. Giving the right values of ALL FUNCTIONS.(problem 1,2,3 solved)
//2. No need to use java.math library(problem 5 is solved)

//Problems in this code
//1. The Cosine function will execute values properly only upto certain loop iteration
//2. The value of Tangent will need to be done via the taylor/ mcclaurin series method or the value of sine and cosines will need to be mode more accurate
//3. The math.cos function is not giving the right value of cos for some reason
//4. The value of Secant function is incorrect for 90 degrees because it is infinity,
//   but it is giving a random value because the iterations is suppose to go for infinity (so maybe an "if" condition will solve the problem)
//5. Using the math.pow function for now, will need to implement the x^y function here instead.

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
        for(int i=1; i<=10; i++){
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
        for(int i=1; i<=10; i++){
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
	
	public static double CoSecFuncs(double x) {

        double numerator=1;
        double denominator = SinFuncs(x);
        double CoSec = numerator/denominator;
        return CoSec;
		
	}
	public static double SecFuncs(double x) {
		double numerator=1;
        double denominator = CosFuncs(x);
        double Sec = numerator/denominator;
        return Sec;
		
	}
	
	public static double CotFuncs(double x) {
		double numerator=1;
        double denominator = TanFuncs(x);
        double Cot = numerator/denominator;
        return Cot;
				
	}
	
	//--------------------Main Function---------------------
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Radians :: ");
		
		double value= sc.nextDouble();
		
		sc.close();
		
		double result=SinFuncs(value);
		//System.out.println("Value in Radians = " +convert(value));
		
		//value=convert(value);
		
		
		System.out.println("Value of Sine = " + result + "  Value of Sine Using Math Functions =  " + Math.sin(value));
		
		System.out.println("Value of Cosine = " + CosFuncs(value) + "  Value of Cosine Using Math Functions =  " + Math.cos(value));
	
		System.out.println("Value of Tangent = " + TanFuncs(value) + "  Value of Tangent Using Math Functions =  " + Math.tan(value));
		
		
	}
}
