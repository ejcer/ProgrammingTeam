import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Codeforces.com 
 * Round 262
 * Division 2
 * Problem B
 * @author Edward McEnrue
 *
 */
public class CF262_Little_Dima_and_Equation {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		//Determine limit to s(x) is 81 from x = 999,999,999
		//Iterate through values for s(x) to get value for x
		//Determine if x is a solution by plugging it into s(x) and seeing if that s(x) did indeed
		//match the chosen/iterated value for s(x)s
		
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		ArrayList<Long> solns = new ArrayList<Long>();
		
		for(int i = 0; i <= 81; i++)
		{
			long x = (long) (b * Math.pow(i, a) + c);
			
			long v = x;
			long soln = 0;
			
			while(x > 0)
			{
				soln += x%10;
				x /= 10;
			}
			
			if((long)i == soln && v > 0 && v < 1000000000)
			{
				solns.add(v);
			}
		}
		
		System.out.println(solns.size());
		for(int i = 0; i < solns.size(); i++)
		{
			System.out.print(solns.get(i) + " ");
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
