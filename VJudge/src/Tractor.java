import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 5
 * Division 2
 * Problem Something
 * @author Edward McEnrue
 */
public class Tractor {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int p = in.nextInt();
		
		for(int z = 0; z < p; z++)
		{
			int a = in.nextInt(); //x bound
			int b = in.nextInt(); //y bound
			int max = Math.max(a, b);
			int moves = 1;
			while(Math.pow(2, moves-1) < max)
			{
				moves++;
			}
			
			
			
			System.out.println(moves-1);
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
