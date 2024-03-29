package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 263
 * Division 2
 * Problem A
 * @author Edward McEnrue
 */
public class CF263_Appleman_and_Easy_Task {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		
		char[][] board = new char[n][n];
		
		for(int i = 0; i < n; i++)
		{
			char[] line = in.nextLine().toCharArray();
			for(int j = 0; j < n; j++)
			{
				board[i][j] = line[j];
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				int cnt = 0;
				
				if(i != 0 && board[i-1][j] == 'o')
				{
					cnt++;
				}
				if(j != 0 && board[i][j-1] == 'o')
				{
					cnt++;
				}
				if(i != n-1 && board[i+1][j] == 'o')
				{
					cnt++;
				}
				if(j != n-1 && board[i][j+1] == 'o')
				{
					cnt++;
				}
				
				if(cnt%2 != 0)
				{
					System.out.println("NO");
					return;
				}
			}
		}
		
		System.out.println("YES");
		
		

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
