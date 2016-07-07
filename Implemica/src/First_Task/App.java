package First_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Если мы из корректно записанного арифметического выражения, содержащего числа, 
 * знаки операций и открывающие и закрывающие круглые скобки выбросим числа и знаки операций, 
 * а затем запишем оставшиеся в выражении скобки без пробелов между ними, 
 * то полученный результат назовем правильным скобочным выражением 
 * [скобочное выражение "(()(()))" - правильное, а "()(" и "())(" - нет].
 * Найти число правильных скобочных выражений, содержащих N открывающихся и N закрывающихся скобок.
 * N вводится с клавиатуры. N неотрицательное целое число.
 */

public class App {
	
	// Declare a method that solves the problem
	
	public static long findNumberOfPairs (int n) {
		
		// Declare and initialize a variables which the method will return.
		long result = 0;
		final long SMALLEST_POSSIBLE_PARAMETER = 1;
        
		// If the parameter is less or equal to 0, the method will return 1.
		if (n <= 0) {
            return SMALLEST_POSSIBLE_PARAMETER;
        }
		
		/*
		 *  With for statement, find the appropriate Catalan number, using recursion.
		 *  The resulting number is the answer to the question, which the method will return.
		 */
        for (int i = 0; i < n; i++) {
        	result += findNumberOfPairs(i) * findNumberOfPairs(n - i - 1);
        }
        return result;
    }
	
	public static void main(String[] args) throws IOException {
		/*
		 * Get the number of matching brackets from the user.
		 * Save a reference to the information.
		 */
		System.out.println("Enter the number of pairs:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        try {
        	/*
        	 * Convert String with the information to Integer.
        	 * If the resulting number is larger than 0,
        	 * call the method, passing the resulting number as a parameter.
        	 * If the value is less or equal to 0, print a message in the console.
        	 */
            int number = Integer.valueOf(str);
            if (number > 0) {
            	System.out.println("The number of expressions containing " + number
            		+ " pairs of parentheses which are correctly matched: " + findNumberOfPairs(number));
            } else {
            	System.err.println("You entered the incorrect number. Please, use numbers that bigger than 0.");
            }
        } catch (NumberFormatException e) {
        	/*
        	 * Catch exceptions.
        	 * If conversion is impossible, print a message in the console. 
        	 */
            System.err.println("Invalid string format!");  
        }
	}
}
