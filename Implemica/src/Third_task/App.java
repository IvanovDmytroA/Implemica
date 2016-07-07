package Third_task;

import java.math.BigInteger;

/*
 * Find the sum of the digits in the number 100! (i.e. 100 factorial) 
 */

public class App {
	
	// Declare a method that solves the task
	public static BigInteger funct(int number){
		
		/*
		 * Declare and initialize a variables.
		 * Use BigInteger class to work with large numbers.
		 * BigInteger factorial will store the factorial of the number.
		 * BigInteger sum will store the final result.
		 */
	    BigInteger sum = BigInteger.ZERO;
	    BigInteger factorial = BigInteger.ONE;
	    
	    // Calculate the factorial of a given number with the for statement.
	    for(int i = 1; i <= number; i++){
	    	// Use BigInteger methods to multiply all numbers
	    	factorial = factorial.multiply(BigInteger.valueOf(i));
//	    	System.out.println(factorial);
	    }

	    // Addition every number with the while statement
	    while (!factorial.equals(BigInteger.ZERO)) {
	    	// Add the number and reduce factorial
	        sum = sum.add(factorial.mod(BigInteger.TEN));
	        factorial = factorial.divide(BigInteger.TEN);
//	        System.out.println(sum + " "+ factorial);
	    }
	    
	    // Print the result and return it
	    System.out.println(sum);
	    return sum;
	}
	
	public static void main (String [] args){
		// Call the method
		funct(100);
	}

}
