package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * vjudge.com 
 * Team Round 2 
 * Division 2
 * Problem D
 * @author Edward McEnrue
 */
public class Freds_Lotto_Tickets {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		
		
		int n = in.nextInt();
		while(n != 0)
		{
			boolean works = true;
			HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < 6; j++)
				{
					map.put(in.nextInt(), true);
				}
			}
			for(int i = 1; i < 50; i++)
			{
				if(map.get(i) == null)
				{
					works = false;
					System.out.println("No");
					break;
				}
			}
			if(works)
			{
				System.out.println("Yes");
			}
			n = in.nextInt();
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
