import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

import Utilities.IO_Template.MyScanner;


public class SubsequenceSpruett {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int n = in.nextInt();
		int t = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = in.nextInt();
		}
		
		//brute force: for each number count the sums from that number
		int subSum = 0;
		int beginning = 0;
		int end = 0;
		boolean flag = true;
		for(int i = 0; i < n; i++){
			if(subSum < t){
				subSum += arr[end];
				end++;
			}else if(subSum > t){
				subSum -= arr[beginning];
				beginning++;
			}else{
				System.out.println("true");
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("false");
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
