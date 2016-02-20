import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;



public class Euler31 {
	
	static int[] coinTypes;
	static HashMap<Integer, Integer> sumCache;
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		
		
		//TODO use a 7x200 array
		//TODO initially fill in the 7x200 array with any place where you can just do 1, so like slots for multiples of 5 for 5 pence
		//TODO the significance of slot [5][100]: how many ways can I make 100 with any coin category from 1-5
		//TODO recursively ask from row 7, column 200, add the sum from -1, -2, -5, -10, -20, -50, -100. The base case is 0 and that returns 1, you store that in the array [0][0] = 1 when you get there
		coinTypes = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
		sumCache = new HashMap<Integer, Integer>();
		
		System.out.println(findSumChangeToTotal(0, 200));
		
	}
	
	public static int findSumChangeToTotal(int typeIndex, int total){
//		if(sumCache.containsKey(total)){
//			return sumCache.get(total);
//		}
		if(typeIndex >= coinTypes.length){
			if(total == 0){
				return 1;
			}else{
				return 0;
			}
		}
		
		
		int totalDistinctWays = 0;
		for(int i = 0; i < total+1; i+=coinTypes[typeIndex]){
			totalDistinctWays += findSumChangeToTotal(typeIndex+1, total-i);
			
		}
//		sumCache.put(total, totalDistinctWays);
		return totalDistinctWays;
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
