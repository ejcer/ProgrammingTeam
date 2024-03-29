package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import static java.lang.Math.*;


/**
 * Codeforces.com 
 * Round 5
 * Division 2
 * Problem H
 * @author Edward McEnrue
 */
public class Narrow_Art_Gallery {

	static Map<Key, Integer> dp; // Used to store a subproblem's score value (the amt of room money)
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt();
		int k = in.nextInt();
		
		
		int[][] r = new int[n][2];
		
		for(int i = 0; i < n; i++)
		{
			r[i][0] = in.nextInt();
			r[i][1] = in.nextInt();
		}
		
		dp = new HashMap<Key, Integer>();
		
		System.out.println(best(r, 0, k, false, false)); // Begin recursion from a top down approach: EG score value = 0, k = k
		
	}
	
	/**
	 * Must Override equals() and hashCode()
	 * 
	 * This wrapper class creates unique key's for recording a subproblem's score value in the hashMap.
	 * @author emcenrue
	 *
	 */
	static class Key
	{
		int h;
		int k;
		boolean closedLeft;
		boolean closedRight;
		
		Key(int h, int k, boolean l, boolean r)
		{
			this.h = h;
			this.k = k;
			this.closedLeft = l;
			this.closedRight = r;
		}
		
		/**
		 * Provides a unique identifier for recording a subproblem's score value in the hashMap
		 */
		@Override
		public int hashCode() {
			return this.h*1000 + k + (closedLeft ? 1000 : -1000) + (closedRight ? 4000 : -4000);
		}

		
		@Override
		public boolean equals(Object _that) {
			Key that = (Key) _that;
			if(this.h == that.h && this.k == that.k && this.closedLeft == that.closedLeft && this.closedRight == that.closedRight)
				return true;
			else
				return false;
		}
	}
	
	/**
	 * Beginning from the top of the art gallery, this recursive method finds the best score one row at a time
	 * 
	 * Base cases:
	 * r.length == h:
	 * k == 0:
	 * 
	 * Recursive routes:
	 * 1: You close the left room
	 * 2: You close the right room
	 * 3: You don't close either room
	 * 
	 * @param r The narrow art gallery rooms
	 * @param h The row level of a subproblem
	 * @param k The amount of rooms that still need to be closed
	 * @param closedLeft If the left room was closed in a previous subproblem
	 * @param closedRight If the right room was closed in a previous subproblem
	 * @return the maximum value of the subproblem
	 */
	static int best(int[][] r, int h, int k, boolean closedLeft, boolean closedRight)
	{
		// Check if the hashMap has stored this subproblem before, and if it has return it's value
		Key ansKey = new Key(h, k, closedLeft, closedRight);
		Integer ansK = dp.get(ansKey);
		if(ansK != null)
			return ansK;
		
		int ans = -9999;
		
		// Check the base cases
		if(r.length == h)
		{
			if(k == 0)
				ans = 0;
			else
				ans = -1;
		}
		else if(k == 0)
		{
			ans = 0;
			for(int i = h; i < r.length; i++)
			{
				ans+=r[i][0];
				ans+=r[i][1];
			}
		}
		else // The subproblem is not a base case, run the recursive routes
		{
			
			/*
			 * The following assigns the ans to be the value of both being open for subproblems
			 * and checks to see if that is greater than the choice of closing left, and then checks to see if that
			 * is greater than closing right. Subsequent subproblems run all three options for themselves.
			 */
			//ans = -1; //why is this needed?
			
			//Leaving both open
			int b = best(r, h+1, k, false, false);
			if(b != -1)
				ans = max(ans, r[h][0]+r[h][1]+b);
			
			
			// Closing off the left room for this subproblem
			if(!closedLeft) //Check to see if previous subproblem closed the left room
			{
				b = best(r, h+1, k-1, false, true);
				if(b != -1)
					ans = max(ans, r[h][0]+b);
			}
			
			// Closing off the right room for this subproblem
			if(!closedRight) //Check to see if the previous subproblem closed the right room
			{
				b = best(r, h+1, k-1, true, false);
				if(b != -1)
					ans = max(ans, r[h][1]+b);
			}
		}
		
		
		// Store the key value associated with the answer for this subproblem
		dp.put(ansKey, ans);
		return ans;
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
