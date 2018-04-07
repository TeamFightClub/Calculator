package calculator;

import java.util.Stack;
import java.util.StringTokenizer;
/**
 * The EpressionIp.java class, takes the entire expression entered in the Calculator.java
 * The entire expression is enclosed in a pair of brackets
 * It uses 3 stacks
 * the minusTrans class changes the "-" symbol to "m", this is so that the calculator can evaluate expression like "-1+2"
 * The other 2 stacks seperate the expression into numerical values and operators 
 * Infix notation is used to solve the expression
 * The order of precedence is also given in this class
 * The brackets are given the highest priority
 * The getResults() method, calls all the other classes based on the operation being performed
 */

public class ExpressionIp {
	public static final String Euler_Number="2.7182818284590452";
	public static final String PI="3.141592653589793";
	public static String lastOne="0";
	public static String replaceAt(char x,int position,String s){
		return s.substring(0,position)+x+s.substring(position+1);	
	}
	public static String minusTransform(String expression){
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
		
		expression=expression.replaceAll("Ans", lastOne);
		expression=expression.replaceAll("--", "+");
		expression=expression.replaceAll("sin", "1s");
		expression=expression.replaceAll("ln", "1l");
		expression=expression.replaceAll("\u221A", "1r");
		expression=expression.replaceAll("-","m");
		expression=expression.replaceAll("e", Euler_Number);
		expression=expression.replaceAll("\u03C0", PI);
		
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
					return "Syntax Error: Operators";					
				}
			}

		}
		expression=minusTransform(expression);
		//remove white space and add evaluation operator
		expression="("+expression+")";//---->send the entire expression inside the bracket to the calculate in the function
		expression=expression.replaceAll("[\t\n ]", "");
		String operator="A*/+m%=()^slr";
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
			lastOne = "Syntax Error: Brackets";
		}						
		else
		{
			lastOne=(String)expressionStack.pop();
		}		
		
		
				
        //return the top of the value stack                
        return lastOne;  
		
	 }
	 public static String infix(String expression)
	    {
	        //remove white space and add evaluation operator
	        expression=expression.replaceAll("[\t\n ]", "")+"=";
	        String operator="A*/+m%=)(^slr";
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
	        lastOne=(String)valueStack.pop();
			if (lastOne.matches("-?[0-9]+"))
			{
				//return Double.parseDouble(lastOne)+0;  
				return lastOne;
			}
			else
			{
				//if function is equal to letter, error is present and letter code will be translated into error message later on
				if(lastOne.equals("a"))
				{
					return "a"; 
				}
				else if(lastOne.equals("b"))
				{
					return "b";
				}
				else if(lastOne.equals("c"))
				{
					return "c";
				}
				else if(lastOne.equals("d"))
				{
					return "d";				
				}	
				else if(lastOne.equals("e"))
				{
					return "e";
				}
				else
				{
					return lastOne;
				}
					
			}
	         
	    }
	    
	 
	     //prioritizes operators
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
	    
	    //replaces value back into stack
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
	                String results = getResults(secondValue, second, firstValue);
	                values.push(results);
	                operators.push(first);
	            }
	        }
	    }
	    
	    //performs operations on inputed values
	    public static String getResults(String operand1, String operator, String operand2)
	    {
	        double op1=Double.parseDouble(operand1);
	        double op2=Double.parseDouble(operand2);
	        switch(operator){
	        
	        //exponent operation
	        case "^":
	        	if(op1==0 && op2<0)
	        	{
	        		return "e"; //Error if zero to negative exponent
	        	}
	        	else
	        	{
	        		return ""+(XpowY.pow(op1,op2));
	        	}
	        	
	        //multiplication operation	
	        case "*":
	        	return ""+(op1*op2);
	        
	        //division operation
	        case "/":
	        {
	        	if(op2 == 0)
	        	{
	        		return "c"; //Error if divide by 0: 22
	        	}
	        	else
	        	{
	        		return ""+ (op1/op2);
	        	}
	        }	
	        
	        //addition operation
	        case "+":
	        	return ""+(op1+op2);
	        
	        //minus operation
	        case "m":
	        	return ""+(op1-op2);
	        
	        //modulo operation
	        case "%":
	        	 return ""+(op1%op2);
	        
	        //sine operation
	        case "s":
	        	return ""+SinFunction.sinFuncs(SinFunction.Convert(op2));
	       
	        //natural log operation
	        case "l":
	        {
	        	if(op2<0)
	        	{
	        		return "a";	 //error code if log value less than zero  		
	        	}
	        	if(op2==0)
	        	{
	        		return "b";	//error code if log value is zero
	        	}
	        	else
	        	{
	        		return ""+Logarithms.Logarithms(op2);
	        	}
	        }
	        
	        //sqare root operation
	        case "r":
	        {	        	
	        	if(op2<0)
	        	{
	        		return "d";				//error code if square root of negative number
	        	}
	        	else
	        	{	        	
	        		return ""+XpowY.pow(op2, 0.5);
	        	}	
	        }
	        
	        //in case no operation is defined
	        case "A":
	        	return ""+lastOne;
	        default:
	        	return null;
	        
	        }
	        
	    }
}
