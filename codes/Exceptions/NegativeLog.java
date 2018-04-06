package Exceptions;

public class NegativeLog extends Exception{
		
		public NegativeLog(){
			super("Semantic Error: No negative of log function");}
			
		public String getMessage(){
			return super.getMessage();}}

