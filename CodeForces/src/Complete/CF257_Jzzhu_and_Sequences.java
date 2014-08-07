package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 257 
 * Division 2
 * Problem B
 * @author Edward McEnrue
 *
 */
public class CF257_Jzzhu_and_Sequences {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int x = in.nextInt();
		int y = in.nextInt();
		
		int n = in.nextInt();
		
		int jzzhu = n%6; //datName.slsdm
		int mod = 0;
		
		if(jzzhu == 1) mod = x;
		else if(jzzhu == 2) mod = y;
		else if(jzzhu == 3) mod = y-x;
		else if(jzzhu == 4) mod = -x;
		else if(jzzhu == 5) mod = -y;
		else if(jzzhu == 0) mod = x-y;
		
		int ans = 0;
		if(mod == -1000000007) ans = 0;
		else if(mod < 0) ans = (mod % 1000000007) + 1000000007;
		else ans = (mod % 1000000007);
			
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
