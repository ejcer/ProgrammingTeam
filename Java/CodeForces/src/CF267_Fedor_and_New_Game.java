import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 267
 * Division 2
 * Problem B
 * @author Edward McEnrue
 */
public class CF267_Fedor_and_New_Game {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int n = in.nextInt(); //n types of soldiers 0 - (n-1)
		int m = in.nextInt(); //m+1 players in total 1 - (m+1)
		int k = in.nextInt(); //can be friends if differ in at most k bits
		
		long[] p = new long[m]; // player army #s
		for(int i = 0; i < m; i++)
		{
			p[i] = in.nextInt();
		}
		
		long fed = in.nextInt();
		
		
		int ans = 0;
		
        for (int i = 0; i < m; i++) {
            long o = p[i];
            int diff = 0;
            for (int j = 0; j < n; j++) {
//            	System.out.println(Integer.toBinaryString((1 << j)));
//            	System.out.println(Integer.toBinaryString((int) (o ^ fed)));
//            	System.out.println(Integer.toBinaryString((int) ((1 << j) & (o ^ fed))));
                
            	if(((1 << j) & (o ^ fed)) != 0)
            	{
            		diff++;
            	}
            	
            }
//            System.out.println("break");

            if (diff <= k) ans++;
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
