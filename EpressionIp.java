package calculator;

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
	 public static String stack(String expression){
		 expression=expression.replaceAll("--", "+");
		expression=expression.replaceAll("sin", "1s");
		expression=expression.replaceAll("ln", "1l");
		expression=expression.replaceAll("\u221A", "1r");
		expression=expression.replaceAll("-","m");
		expression=expression.replaceAll("e", "2.7182818284590452353602874713527");
		expression=expression.replaceAll("\u03C0", "3.14159265358979323846264338327950288419716939937510582097494");
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

        //return the top of the value stack
        String lastOne=(String)expressionStack.pop();
        //System.out.println(lastOne);
        return lastOne;
        //return Double.parseDouble(lastOne);  
		
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
	        if(operator.equals("^"))
	        	return ""+(XpowY.pow(op1,op2));
	        else if(operator.equals("*"))
	            return ""+(op1*op2);
	        else if(operator.equals("/"))
	            return ""+(op1/op2);
	        else if(operator.equals("+"))
	            return ""+(op1+op2);
	        else if(operator.equals("m"))
	             return ""+(op1-op2);
	        else if(operator.equals("%"))
	            return ""+(op1%op2);
	        else if(operator.equals("s"))
	            return ""+TrigoFuncs.SinFuncs(TrigoFuncs.convert(op2));
	        else if(operator.equals("l"))
	        	return ""+Logarithms.Logarithms(op2);
	        else if(operator.equals("r"))
	        	return ""+XpowY.pow(op2, 0.5);
	        else return null;
	    }
	    
	    
	    public static void main(String[] args)
	    {
	        Scanner sc =  new Scanner(System.in);
			System.out.print("enter the expression you want to evaluate : ");
			//String Exp ="1r(4)"; 
			String Exp = sc.nextLine();  
			String answer = stack(Exp);
			System.out.println(answer);
	    	
	    }
}
