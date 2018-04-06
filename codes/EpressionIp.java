package calculator;
import Exceptions;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class EpressionIp {
	
	public static String replaceAt(char x,int position,String s){
		return s.substring(0,position)+x+s.substring(position+1);	
	}
	public static String minusTrans(String expression){
		int exp_length=expression.length();
		 for(int i=0;i<exp_length;i++){
			if(expression.charAt(i)=='m'){
				if(i==0){
					expression=replaceAt('-',i,expression);
				}
				else if(expression.charAt(i-1)=='('){
					expression=replaceAt('-',i,expression);
				}else if(expression.charAt(i-1)=='*'){
					expression=replaceAt('-',i,expression);
				}else if(expression.charAt(i-1)=='/'){
					expression=replaceAt('-',i,expression);
				}else if(expression.charAt(i-1)=='+'){
					expression=replaceAt('-',i,expression);
				}else if(expression.charAt(i-1)=='%'){
					expression=replaceAt('-',i,expression);
				}
			}
		}
		 return expression;
	}
	 public static String stack(String expression)
	 {
		 String lastOne;
		 expression=expression.replaceAll("--", "+");
		expression=expression.replaceAll("sin", "1s");
		expression=expression.replaceAll("ln", "1l");
		expression=expression.replaceAll("\u221A", "1r");
		expression=expression.replaceAll("-","m");
		expression=expression.replaceAll("e", "2.7182818284590452353602874713527");
		expression=expression.replaceAll("\u03C0", "3.14159265358979323846264338327950288419716939937510582097494");
		
		//check to see that expression is valid and ends in a number	
		for(int i = 0; i<expression.length(); i++)
		{
			//if two consecutive operators exist then return error
			if(i != expression.length()-1)
			{
				if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='/' ||expression.charAt(i)=='*' || expression.charAt(i)=='%' || expression.charAt(i)=='.')
				{
					if(expression.charAt(i+1)=='+' || expression.charAt(i+1)=='-' || expression.charAt(i+1)=='/' ||expression.charAt(i+1)=='*' || expression.charAt(i+1)=='%' || expression.charAt(i+1)=='.')
					{
						return "Syntax Error: Operators";
						
					}
				}
			}
			//if last character of input string is operator then return error
			else
			{
				if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='/' ||expression.charAt(i)=='*' || expression.charAt(i)=='%' || expression.charAt(i)=='.')
				{
					//return "Syntax Error: Operators";
					try {
						throw new OperatorSyntax();} 
					catch (OperatorSyntax e) {
						e.printStackTrace();}
				}
			}

		}
		expression=minusTrans(expression);
		//remove white space and add evaluation operator
		expression="("+expression+")";//---->send the entire expression inside the bracket to the calculate in the function
		expression=expression.replaceAll("[\t\n ]", "");
		String operator="*/+m%=()^slr";
		StringTokenizer tokenizer=new StringTokenizer(expression, operator, true);
		Stack expressionStack=new Stack();
		
		while(tokenizer.hasMoreTokens())
        {
			String token=tokenizer.nextToken();
			expressionStack.push(token);
			if(token.compareTo(")")==0){
				String exp="";
				String temp="";
				while(temp.compareTo("(")!=0){
					temp=(String)expressionStack.pop();
					exp= temp+(String)exp;
				}
				exp=exp.substring(1, exp.length()-1);//---->remove the brackets and 
				//System.out.println(exp);
				exp=String.valueOf(infix(exp));
			
				
				expressionStack.push(exp);//-----> push the evaluated value in the stack
			}
		}		

		
		//check if number of opening brackets equals number of closing brackets
		int numOpenBracks=0;
		int numClosedBracks=0;			
		for(int i=0;i<expression.length();i++)
		{
			if(expression.charAt(i) == ')')
			{		
				numOpenBracks++;
			}
			if(expression.charAt(i)=='(')
			{
				numClosedBracks++;
			}
		}
		if(numOpenBracks != numClosedBracks)
		{
			//lastOne = "Syntax Error: Brackets";
			try {
				throw new BracketSyntax();} 
			catch (BracketSyntax e) {
				e.printStackTrace();}
		}						
		else
		{
			lastOne=(String)expressionStack.pop();
		}		
		
		
				
        //return the top of the value stack                
        return lastOne;  
		
	 }
	 public static double infix(String expression)
	    {
	        //remove white space and add evaluation operator
	        expression=expression.replaceAll("[\t\n ]", "")+"=";
	        String operator="*/+m%=)(^slr";
	        //split up the operators from the values
	        StringTokenizer tokenizer=new StringTokenizer(expression, operator, true);
	        Stack operatorStack=new Stack();
	        Stack valueStack=new Stack();
	        while(tokenizer.hasMoreTokens())
	        {
	            //add the next token to the proper stack
	            String token=tokenizer.nextToken();
	            if(operator.indexOf(token)<0)
	                valueStack.push(token);
	            else
	                operatorStack.push(token);
	            //perform any pending operations
	            resolve(valueStack, operatorStack);
	        }
	        //return the top of the value stack
	        String lastOne=(String)valueStack.pop();
	        return Double.parseDouble(lastOne);   
	    }
	    
	        
	    public static int getPriority(String op)
	    {
	    	if(op.equals("^")|| op.equals("s")||op.equals("l")||op.equals("r")||op.equals("%"))
	            return 1;
	    	else if(op.equals("*") || op.equals("/"))
	            return 2;
	        else if(op.equals("+") || op.equals("m"))
	            return 3;
	        else if(op.equals("="))
	            return 4;
	    	
	        else
	            return Integer.MIN_VALUE;
	    }
	    
	    public static void resolve(Stack values, Stack operators)
	    {
	        while(operators.size()>=2)
	        {
	            String first=(String)operators.pop();
	            String second=(String)operators.pop();
	            if(getPriority(first)<getPriority(second))
	            {
	                operators.push(second);
	                operators.push(first);
	                return;
	            }
	            else
	            {
	                String firstValue=(String)values.pop();
	                String secondValue=(String)values.pop();
	                values.push(getResults(secondValue, second, firstValue));
	                operators.push(first);
	            }
	        }
	    }
	    
	    public static String getResults(String operand1, String operator, String operand2)
	    {
	        double op1=Double.parseDouble(operand1);
	        double op2=Double.parseDouble(operand2);
	        if(operator.equals("^"))				//exponent
	        	return ""+(XpowY.pow(op1,op2));
	        else if(operator.equals("*"))			//multiplication
	            return ""+(op1*op2);
	        
	        else if(operator.equals("/"))			//division
	        {
	        	if(op2 == 0)
	        	{
	        		//return "10000000000000000000000"; //Error if divide by 0: 22
				try {
					throw new DivideByZero();} 
				catch (DivideByZero e) {
					e.printStackTrace();}
	        	}
	        	else
	        	{
	        		return ""+ (op1/op2);
	        	}
	        }	            
	        else if(operator.equals("+"))			//addition
	            return ""+(op1+op2);
	        else if(operator.equals("m"))			//subtraction
	             return ""+(op1-op2);
	        else if(operator.equals("%"))			//modulo
	            return ""+(op1%op2);
	        else if(operator.equals("s"))	        //sine
	            return ""+TrigoFuncs.SinFuncs(TrigoFuncs.convert(op2));
	        else if(operator.equals("l"))
	        {
	        	if(op2<0)
	        	{
	        		//return "100000000000000000000";	 //error code if log value less than zero: 20   
				try {
					throw new DivideByZero();} 
				catch (DivideByZero e) {
					e.printStackTrace();}
	        	}
	        	if(op2==0)
	        	{
	        		//return "1000000000000000000000";	//error code if log value is zero: 21
				try {
					throw new DivideByZero();} 
				catch (DivideByZero e) {
					e.printStackTrace();}
	        	}
	        	else
	        	{
	        		//return ""+Logarithms.Logarithms(op2);
				try {
					throw new NegativeLog();} 
				catch (NegativeLog e) {
					e.printStackTrace();}
	        	}
	        }
	        else if(operator.equals("r"))			//root
	        {	        	
	        	if(op2<0)
	        	{
	        		//return "10000000000000000000000000";				//error code if square root of negative number: 23
	        		try {
					throw new SquareRootNegative();} 
				catch (SquareRootNegative e) {
					e.printStackTrace();}
			}
	        	else
	        	{	        	
	        		return ""+XpowY.pow(op2, 0.5);
	        	}	
	        }
	        else return null;
	    }

}
