package Exceptions;

public class SquareRootNegative extends Exception{
	public SquareRootNegative(){
		super("Semantic Error: Cannot take square root of a negative number");}
		
	public String getMessage(){
		return super.getMessage();}}


