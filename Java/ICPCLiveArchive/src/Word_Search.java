import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Utilities.IO_Template.MyScanner;


public class Word_Search {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int n = in.nextInt();//square size
		int wordCount = in.nextInt();//words
		
		char[][] grid = new char[n][n];
		
		for(int i = 0; i < n; i++){
			String line = in.nextLine();
			for(int j = 0; j < n; j++){
				grid[i][j] = line.charAt(j);
			}
		}
		ArrayList<String> words = new ArrayList<String>();
		for(int i = 0; i < wordCount; i++){
			words.add(in.nextLine());
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				StringBuilder sb = new StringBuilder();
				for(int k = j; k < n; k++){
					sb.append(grid[i][k]);
					String value = sb.toString();
					if(words.contains(value)){
						words.remove(value);
					}
				}
				
			}
		}
		for(int j = 0; j < n; j++){
			for(int i = 0; i < n; i++){
				StringBuilder sb = new StringBuilder();
				for(int k = i; k < n; k++){
					sb.append(grid[k][j]);
					String value = sb.toString();
					if(words.contains(value)){
						words.remove(value);
					}
				}
				
			}
		}
		if(words.isEmpty()){
			System.out.println("yes");
		}else{
			System.out.println("no");
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
