package calculator;


public class SinFunction 
{
	// ----------Converting Degrees to Radians----------
	public static double Convert(double x){
		double radians;
		radians = (x*22)/(7*180);		
		while(radians>6.2831853072 ){
			radians=radians-6.2831853072;
		}
		while(radians<0 ){
			radians=radians+6.2831853072;
		}
		return radians;
	}
	
	//----------------Trigo Functions-------------------
	public static double sinFuncs(double x) {
		double sin=0;
		double fact=1;
		double currX=x;
		int sign=1;
		double update=x*x;
		
		//Taylor series expansion
        for(int i=1; i<=100; i++){
            sin= sin+ sign*currX/fact;
            currX=currX*update;
            sign =sign*(-1);
            fact=fact *(i*2)*(i*2+1);
        }
        return sin;
		
	}
	
}
