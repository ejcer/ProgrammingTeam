package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;



/**
 * Kattis
 * Round 5
 * Division 2
 * Problem D
 * @author Edward McEnrue
 */
public class Flip_Five {

	static char[][] soln; // Initializes the static target solution flip board
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int n = in.nextInt();
		
		/**
		 * Instantiates the starting board with all white cells, and the target solution board
		 * with the input text for each flipboard problem.
		 */
		for(int z = 0; z < n; z++) 
		{
			soln = new char[3][3];
			char[][] startBoard = new char[3][3];
			
			for(int i = 0; i < 3; i++)
			{
				String row = in.nextLine();
				for(int j = 0; j < 3; j++)
				{
					soln[i][j] = row.charAt(j);
					startBoard[i][j] = '.';
				}
			}
			
			State start = new State(startBoard); // Starting state is always a grid of all white "."	
			solve(start); // Start the solution method
		}
	}
	
	
	/** BFS Skeleton.
	 * Assumes that 'State' implements equals() and hashCode()
	 * according to contract.
	 * State must also provide 'isFinal', and 'successors' methods
	 * 
	 * NOTES--------------------------------------------------------------
	 * Using a FIFO queue, BFS queues up a node, searches all of that nodes 
	 * neighbors (queuing them up subsequently), and then removes that first 
	 * node from the queue. Rinse wash repeat for the next node in the queue.
	 * 
	 * Based on the above description, BFS will traverse a graph based on
	 * the distance from the start node, so it will visit all nodes
	 * distance 1 from the start node, then distance 2, then 3, etc.
	 * Therefore, by going backwards in the queue from the destination node
	 * you can reconstruct the shortest path back to the start.
	 * 
	 * BFS acquires the shortest path in an unweighted graph.
	 * -------------------------------------------------------------------
	 */
	static void solve(State start) {
		
	    Set<State> visited = new HashSet<State>(); // has this state been visited?                  
	    
	    Map<State, State> pred = new HashMap<State, State>(); // predecessor on the shortest path to the start state      
	    
	    Map<State, Integer> dist = new HashMap<State, Integer>(); // shortest distance from start state  
	    
	    Deque<State> bfs = new ArrayDeque<State>(); 
	    bfs.offer(start); // Put the starting state into the Breadth First Search queue to be analyzed.
	    dist.put(start, 0); // Initialize the starting state to have 0 distance from start, and put it in the shortest distance map.
	    
	    int min = Integer.MAX_VALUE; //=========ADDED4FLIPFIVE==========

	    /**
	     * Runs while the size of the breadth first search queue has not been expended of new possible states
	     */
	    while (bfs.size() > 0) {
	        State s = bfs.poll(); // Gets the first element to be put into the queue (or the most recently put in)
	        int n = dist.get(s); // Gets the distance of that first element
	        visited.add(s); // Adds this element's hashCode to the set of visited states, effectively ignoring it later on.
	        

	        // If this state matches the target solution state then figure out the distance to it
	        if (s.isFinal()) {
	        	
	        	//I don't think this if statement is necessary
	        	
	        		min = n;
	        		//output(n, s, pred); //=========UNUSED4FLIPFIVE==========
	        	
	        	break;
	        }

	        // For all possible successors of the state most recently taken from the head of the breadth first search queue
	        for (State succ : s.successors()) {
	            if (visited.contains(succ)) // Check if a successor has already been visited, if it has go to the next successor
	                continue;

	            // The state hasn't been visited yet
	            if (!pred.containsKey(succ)) // The state is not already in predecessors 
	                pred.put(succ, s); // Put the successor state into the predecessor state with the current state as the predecessor
	            
	            if (!dist.containsKey(succ)) { // The state's distance from start hasn't been recorded yet in the distance map.
	                dist.put(succ, n+1); // Put the successor state into the distance from start map with 1+distance from current state.
	                bfs.offer(succ); // Queue up the successor state to be analyzed once the breadth first search queue reaches it.
	            }
	        }
	    }
	    
	    System.out.println(""+min); //=========ADDED4FLIPFIVE==========
	}
	
	//=========UNUSED4FLIPFIVE==========
	/* Compute and output path */
	void output(int distToSolution, State finalState, Map<State, State> pred) {
	    System.out.println("The distance to the solution is: " + distToSolution);

	    List<State> revPath = new ArrayList<State>();
	    State s = finalState; // The target solution state
	    while (pred.containsKey(s)) {
	        revPath.add(s);
	        s = pred.get(s);
	    }
	    revPath.add(s); // The starting state, since the BFS solve() method doesn't ever add the first start state to pred

	    for (int i = 0; i < revPath.size(); i++) {
	        System.out.printf("%3d %s%n", i, revPath.get(revPath.size() - 1 - i));
	    }
	} //=========UNUSED4FLIPFIVE==========
	
	
	/**
	 * NOTES-------------------------------------------------
	 * successors() are all the next possible states of the 3x3 flipboard
	 * 
	 * State is actually another name for a node.
	 * 
	 * State must implement equals(), hashCode(), isFinal(), and successors()
	 * for any BFS problem
	 * ------------------------------------------------------
	 * @author emcenrue
	 */
	public static class State
	{
		char[][] flipBoard;
		
		/**
		 * Instantiates a board with a given 3x3 configuration of chars
		 * @param fb
		 */
		public State(char[][] fb)
		{
			flipBoard = new char[3][3];
			
			for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    flipBoard[i][j] = fb[i][j];
                }
            }
		}
		
		/**
		 * Checks to see if two board's cell configurations are the same
		 */
		@Override
		public boolean equals(Object o)
		{
			State s = (State)o;
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if(flipBoard[i][j] != s.flipBoard[i][j])
						return false;
				}
			}
			return true;
		}
		
		/**
		 * @return A list of all the new states that can occur from the current state
		 */
		public List<State> successors()
		{
			List<State> list = new ArrayList<State>(); //adjacent nodes list
			
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					State flipper = new State(flipBoard);
					flipper.flip(i, j);
					list.add(flipper);
				}
			}
			return list;
		}
		
		public char[][] getBoard()
        {
            return flipBoard;
        }
		
		/**
		 * Flips the board based on the coordinates given
		 * @param x coordinate of the click on the flip board
		 * @param y coordinate of the click on the flip board
		 */
		public void flip(int x, int y)
		{
			flipBoard[x][y] = flipChar(flipBoard[x][y]);
			if(x > 0)
				flipBoard[x-1][y] = flipChar(flipBoard[x-1][y]);
			if(y > 0)
				flipBoard[x][y-1] = flipChar(flipBoard[x][y-1]);
			if(x < 2)
				flipBoard[x+1][y] = flipChar(flipBoard[x+1][y]);
			if(y < 2)
				flipBoard[x][y+1] = flipChar(flipBoard[x][y+1]);
			
		}
		public char flipChar(char cur)
		{
			if(cur == '.')
				return '*';
			else
				return '.';
		}
		
		/**
		 * @return True if the current state object has the same cell configuration as the target solution.
		 */
		public boolean isFinal()
		{			
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if(this.flipBoard[i][j] != soln[i][j])
					{
						return false;
					}
				}
			}
			return true;
		}
		
		/**
		 * Creates a unique integer identifier for each permutation of a flipboard
		 */
		public int hashCode()
		{
			int count = 0;
			int mult = 1;
			
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					count += mult * hash(flipBoard[i][j]); 
					mult *= 2;
				}
			}
			
			return count;
		}
		
		public int hash(char c)
		{
			if (c == '*')
				return 0;
			else
				return 1;
		}
		
	}
	
	
	

	// -------------------------------------MyScanner class for faster input-------------------------------------
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
	// ---------------------------------------------------------------------------------------------------------------
}
