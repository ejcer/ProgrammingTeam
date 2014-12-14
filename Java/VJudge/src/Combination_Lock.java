import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Combination_Lock {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int n = in.nextInt();
		int t1 = in.nextInt();
		int t2 = in.nextInt();
		int t3 = in.nextInt();
		
		
		while(n != 0 || t1 != 0 || t2 != 0 || t3 != 0)
		{
			int ans = 0;
			
			ans = n*4-1;
			if(t2 > t1)
				ans += (t2-t1);
			else
				ans += n - (t1 - t2);
			if(t3 < t2)
				ans += (t2-t3);
			else
				ans +=  (t3-t2);
			
			System.out.println(ans);
			n = in.nextInt();
			t1 = in.nextInt();
			t2 = in.nextInt();
			t3 = in.nextInt();
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
