package Second_Task;

public final class Matrix {
	
	// The value that exceeds the allowable limit
	final int MAX_VALUE = 10001;
	
	// Declare an array that contains the value of the edges
	private int[][] value;
     
	/*
	 * Create a constructor with parameters, where
	 * vertices is the number of vertices in the graph.
	 */
	public Matrix (int vertices) {
		value = new int [vertices][vertices];
	}
	
	// Set the value of the connection between neighbors
	public void setWeight (int i, int j, int weight) {
		value [i][j] = weight;
	    }
	
	// Get the value of the edge between 2 cities
	private int getValue (int i , int j) {
		// Return 0 if i equals j
		if (i == j) {
			return 0;
	    }
		/*
		 * Return the value that exceeds the allowable limit,
		 * if the cities is not connected to each other.
		 */
		if (value [i][j] == 0){
			return MAX_VALUE;
		}
		// Return the value of the edge
	    return value [i][j];
	}
	    
	// Return the index of the shortest element of distances
	private int findSmallestElement (Integer[] result, boolean [] visited) {
		int cheapest = 0;
	    for (int i = 0; i < value.length; i++) {
	    	/*
	    	 *  If we didn't visit the vertex earlier and the element with index i
	    	 *  less than the element with index cheapest,
	    	 *  change the value.
	    	 */
	    	if (!visited[i] && (result[i] < result[cheapest])) {
	    		cheapest = i;
	        }
	    }
	    // Return the result
	    return cheapest;
	}

	// Return an array of the distances from the starting point to other vertices
	public Integer[] findDistances (int source) {
		
		// Declare and initialize the array that the method will return
		Integer[] result = new Integer[value.length];
		// Set tops mark
		java.util.Arrays.fill(result, MAX_VALUE);
		// Assign first top mark equal to "source", because this vertex is the starting point
		result [source] = source;
		// This variable will determine if we visited the city
		boolean []visited = new boolean [value.length];
		
		// With the for statement go around each vertex
		for (int i = 0; i < value.length; i++){
			// Select the vertex which has a minimum mark
			int city = findSmallestElement(result, visited);
			// Mark selected vertex as visited
	        visited [city] = true;
	        
	     // Write the shortest path between vertices
	        for (int j = 0; j < value.length; j++){
	        	result [j] = Math.min(result[j], result[city] + getValue(city,j));
	        }
		}
		// Return the result
		return result;
	}
}
