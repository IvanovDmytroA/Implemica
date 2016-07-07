package Second_Task;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * You are given a list of cities.
 * Each direct connection between two cities has it's transportation cost (an integer bigger than 0).
 * The goal is to find the paths of minimum cost between pairs of cities.
 * Assume that the cost of each path (which is the sum of costs of all direct connections belonging to this path)
 * is at most 200000. The name of a city is a string containing characters a,...,z and is at most 10 characters long.2) 
 */

public class App {
	
	public static void findMinimumCost(String path) throws IOException {
		
		// Read the number of tests from the file and parse acquired information to Integer
	    BufferedReader br = new BufferedReader(new FileReader(path));
	    String str = br.readLine();
	    int value = Integer.parseInt(str);
	    
	    for (int test = 0; test < value; test++) {
	    	
	    	// Create an array with cities
	    	String [] cities = new String[10000];
	    	// Read the number of cities from the file and parse acquired information to Integer
	    	str = br.readLine();
	        int countCities = Integer.parseInt(str);
	        
	        // Solve the problem of indexing the array from 0
	        int matrixSize = countCities + 1;
	        // Create a matrix, and iterate all cities with the for statement, add information.
	        Matrix matrix = new Matrix (matrixSize);
	        
	        for (int index = 0; index < countCities; index++) {
	        // Read the name of the city and save this information
	        str = br.readLine();
	        String cityName = str;
	        cities[index] = cityName;
	                
	        // Read the number of neighbors
	        str = br.readLine();
	        int i = Integer.parseInt(str);
	                
	        // Iterate all neighbors, write the weight of edges and set info to the matrix
	        for (int indexOfNeighbor = 0; indexOfNeighbor < i; indexOfNeighbor++){
	        	str = br.readLine();
	            String [] breakLine = str.split(" ");
	            int neighbor = Integer.parseInt(breakLine[0]);
	            int weightOfEdge = Integer.parseInt(breakLine[1]);
	            matrix.setWeight(index, neighbor, weightOfEdge);
	            }
	        }
	            
	        // Read the number of calculated routes and save this information
	        str = br.readLine();
	        int routes = Integer.parseInt(str);
	            
	        // Iterate all routes
	        for (int routeIndex = 0; routeIndex < routes; routeIndex++){
	        	// Read the path
	            str = br.readLine();
	            String [] cityNames = str.split(" ");
	            String startingPoint = cityNames[0];
	            String destination = cityNames[1];
	            List<String> list = new ArrayList<String>();
	                
	            // Remove the null elements from the array
	            for(String s : cities) {
	            	if(s != null) {
	            		list.add(s);
	                }
	            }
	            
	            cities = list.toArray(new String[list.size()]);
	            int startingPointIndex = 0;
	            int destinationIndex = 0;
	            for (int i = 0; i < cities.length; i++) {
	            	// Find the index of the initial city
					if(startingPoint.equals(cities[i])) {
						startingPointIndex = i;
						break;
					}					
				}
	            for (int i = 0; i < cities.length; i++) {
	                // Find the index of the destination place
					if(destination.equals(cities[i])){
						destinationIndex = i;
						break;
					}					
				}
	            // Find an array of the distances from the starting point to other vertices
	            Integer[] distancesFromSource = matrix.findDistances(startingPointIndex);
	            // Save the distance to the destination point
	            int destinationDistance = distancesFromSource[destinationIndex];
	            // Print the result
	            System.out.println(destinationDistance);
	            }

	    }
	    
	    // Close the stream
	    br.close();
	}
	
	public static void main (String[] args) throws IOException {
		findMinimumCost("src\\Second_Task\\Input.txt");
	}
}
