package Complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF257_JzzhuAndChildren 
{
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int maxDiv = -1;
		int maxInd = -1;
		
		for(int i = 0; i < n; i++)
		{
			
			int c = in.nextInt();
			
			int temp;
			
			if(c%m == 0)
			{
				temp = ((int) Math.floor(c/m)) - 1;
			}
			else
			{
				temp = (int) Math.floor(c/m);
			}
			
			
			
			//System.out.print(temp+" ");
			if(maxDiv <= temp)
			{
				maxDiv = temp;
				maxInd = i;
			}
			
		}
		System.out.println(""+(maxInd+1));
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
