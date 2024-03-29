package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class CF254_DZY_Loves_Chessboards {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int rows = in.nextInt();
		int col = in.nextInt();
		
		char[][] b = new char[rows][col]; //b as in board
		
		for(int i = 0; i < rows; i++)
		{
			String line = in.nextLine();
			for(int j = 0; j < col; j++)
			{
				b[i][j] = line.charAt(j);
			}
		}
		
		// - is bad
		// . is good
		// white cannot be adjacent to black
		
		
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(b[i][j] == '.')
				{
					if(i%2 == 1)
					{
						if(j%2 == 1)
						{
							b[i][j] = 'B';
						}
						else
						{
							b[i][j] = 'W';
						}
					}
					else
					{
						if(j%2 == 1)
						{
							b[i][j] = 'W';
						}
						else
						{
							b[i][j] = 'B';
						}
					}
				}
			}
			
		}
		
		
		
		//prints board
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < col; j++)
			{
				System.out.print(b[i][j]);
			}
			System.out.println("");
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
}
