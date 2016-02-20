import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class euler18 {
	
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		//you have +1 index for each row, you can only search the position and the position +1
		int[][] pyramid = new int[][] {
			    { 75 },
			    { 95, 64 },
			    { 17, 47, 82 },
			    { 18, 35, 87, 10 },
			    { 20, 4, 82, 47, 65 },
			    { 19, 1, 23, 75, 3, 34 },
			    { 88, 2, 77, 73, 7, 63, 67 },
			    { 99, 65, 4, 28, 6, 16, 70, 92 },
			    { 41, 41, 26, 56, 83, 40, 80, 70, 33 },
			    { 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 },
			    { 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 },
			    { 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 },
			    { 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
			    { 63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
			    { 4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23 },
			};
		for(int i = 13; i >= 0; i--){
			for(int j = 0; j <= i; j++){
				pyramid[i][j] = pyramid[i][j]+Math.max(pyramid[i+1][j], pyramid[i+1][j+1]);
				
			}
		}
		
		System.out.println(pyramid[0][0]);
		
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
