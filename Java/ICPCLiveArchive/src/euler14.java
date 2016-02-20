import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import Utilities.IO_Template.MyScanner;


public class euler14 {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		HashMap<Long, Integer> countMap = new HashMap<Long, Integer>();
		countMap.put((long) 1, 1);
		
		int max = 0;
		long j = 0;
		for(long i = 999999; i >= 1; i--){
			int temp = countChains(i, countMap);
			if(max < temp){
				max = temp;
				j = i;
			}
		}
		System.out.println(j);
	}
	
	public static int countChains(long n, HashMap<Long, Integer> countMap){
		if(countMap.containsKey(n)){
			return countMap.get(n);
		}
		if(n%2 == 0){
			int result = countChains(n/2, countMap)+1; //save result
			countMap.put(n, result); //put result in map
			return result; //return result as well
		}else{
			int result = countChains(3*n+1, countMap)+1;
			countMap.put(n, result);
			return result;
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
