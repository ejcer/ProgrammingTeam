import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import Utilities.IO_Template.MyScanner;


public class CF257_Jzzhu_and_Chocolate 
{

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt(); //cuts
		
		//find the maximum ways to divide the cake evenly.
		//If you can't divide the cake evenly, choose the top one and go with that size.
		
		int maxCuts = n-1+m-1;
		
		if(maxCuts > k)
		{
			int big = Math.max(n, m);
			int small = Math.min(n, m);
			
			int dif = big-small;
			
			while(big > 1 && small > 2)
			{
				big = Math.max(big, small);
				small = Math.max(big, small);
				
				big = (int) Math.ceil(big/2);
			}
			
			System.out.print(big*small);
		}
		else
		{
			System.out.println("-1");
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
