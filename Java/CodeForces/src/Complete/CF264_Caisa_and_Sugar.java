package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 264
 * Division 2
 * Problem A
 * @author Edward McEnrue
 */
public class CF264_Caisa_and_Sugar {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(3.79);
		ans.add(2.99);
		ans.add(2.77);
		ans.add(2.91);
		ans.add(3.1);
		ans.add(1.84);
		ans.add(2.52);
		ans.add(3.22);
		ans.add(2.45);
		ans.add(2.14);
		ans.add(2.67);
		ans.add(2.52);
		ans.add(2.71);
		ans.add(2.75);
		ans.add(3.57);
		ans.add(3.85);
		ans.add(3.36);
		ans.add(2.05);
		ans.add(2.89);
		ans.add(2.83);
		ans.add(3.13);
		ans.add(2.44);
		ans.add(2.1);
		ans.add(3.71);
		ans.add(3.14);
		ans.add(3.54);
		ans.add(2.37);
		ans.add(2.68);
		ans.add(3.51);
		ans.add(3.37);
		
		ans.sort();
		
		
		System.out.println(ans.toString());
		
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
