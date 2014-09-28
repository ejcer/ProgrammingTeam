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

	static char[][] soln; // target flip board
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int n = in.nextInt();
		
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
			
			State start = new State(startBoard); //starting state is always a grid of all white "."	
			solve(start); 
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
	    Set<State> visited = new HashSet<State>();                  
	    // has this state been visited?
	    Map<State, State> pred = new HashMap<State, State>();       
	    // predecessor on the shortest path to the start state
	    Map<State, Integer> dist = new HashMap<State, Integer>();   
	    // shortest distance to start state
	    Deque<State> bfs = new ArrayDeque<State>();  // BFS queue
	    bfs.offer(start);
	    dist.put(start, 0);
	    
	    int min = Integer.MAX_VALUE; //=========ADDED4FLIPFIVE==========

	    while (bfs.size() > 0) {
	        State s = bfs.poll();
	        int n = dist.get(s);
	        visited.add(s);
	        

	        if (s.isFinal()) {
	        	
	        	if(n < min) //=========ADDED4FLIPFIVE==========
	        	{
	        		min = n;
	        	}
	        	break;
	        }

	        for (State succ : s.successors()) {
	            if (visited.contains(succ))
	                continue;

	            if (!pred.containsKey(succ)) //this is why you need hashcode
	                pred.put(succ, s);

	            if (!dist.containsKey(succ)) {
	                dist.put(succ, n+1);
	                bfs.offer(succ);
	            }
	        }
	    }
	    
	    System.out.println(""+min); //=========ADDED4FLIPFIVE==========
	}
	
	
	/**
	 * NOTES-------------------------------------------------
	 * successors() are all the next possible states of the 3x3 flipboard
	 * 
	 * State is actually another name for a node.
	 * 
	 * ------------------------------------------------------
	 * @author emcenrue
	 * must implement equals(), hashCode(), ifFinal(), and successors()
	 */
	public static class State
	{
		char[][] flipBoard;
		
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
		 * still need to finish this
		 * @return
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
		 * No idea how to do this, but here's my assumption that we're seeing
		 * if the current objects state is indeed either all black or white
		 * @return true if it is final
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
		 * no idea how to do this in general ===========================================================================
		 * my current stab at it
		 * update this description once you get it
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
	
	
	

	// -----------MyScanner class for faster input----------
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
	// --------------------------------------------------------
}
