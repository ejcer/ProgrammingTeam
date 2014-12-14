package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Codeforces.com 
 * Round 261 
 * Division 2
 * Problem A
 * @author Edward McEnrue
 */
public class CF261_Pashmak_and_Garden {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		//trick the output boundaries allow you to consider 4 cases of inputs: 2 diags and rows and col.
		
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		if(x1==x2) System.out.println(y2-y1+x1+" "+y1+" "+(y2-y1+x1)+" "+y2); //col
		else if(y1==y2) System.out.println(x1+" "+(x2-x1+y1)+" "+x2+" "+(x2-x1+y1)); // row
		else if(x2-x1==y2-y1 || x2 - x1 == y1 - y2) System.out.println(x1+" "+y2+" "+x2+" "+y1); // negative and pos case diag 
		else System.out.println(-1); // this isn't spaghetti
		
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
