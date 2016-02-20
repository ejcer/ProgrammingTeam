import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

import Utilities.IO_Template.MyScanner;


public class Dedupe {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int n = in.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		int h = in.nextInt();
		System.out.print(h);
		set.add(h);
		for(int i = 1; i < n; i++){
			int k = in.nextInt();
			if(!set.contains(k)){
				System.out.print(" "+k);
			}
			set.add(k);
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
