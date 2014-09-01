package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		MyScanner in = new MyScanner();

		int n = in.nextInt();
		int s = in.nextInt();
		
		int ans = -1;
		for(int i = 0; i < n; i++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			if(s > x && y != 0)
			{
				ans = Math.max(ans, 100-y);
			}
			if(s >= x && y == 0)
			{
				ans = Math.max(ans, 0);
			}
		}
		
		System.out.println(ans);
		
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
