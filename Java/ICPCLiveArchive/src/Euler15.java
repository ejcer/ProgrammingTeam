import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Euler15 {
	static long[][] grid;
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		grid = new long[21][21];
		for(int i = 0; i < 21; i++){
			for(int j = 0; j < 21; j++){
				grid[i][j] = 0;
			}
		}
		grid[0][0] = 1;
		System.out.println(permute(20, 20));
		System.out.println(grid[20][20]);
	}
	public static long permute(int row, int col){
		if(row < 0 || col < 0){
			return 0;
		}
		if(grid[row][col] != 0){
			return grid[row][col];
		}
		
		long waysToCell = permute(row-1, col) + permute(row, col-1);
		grid[row][col] = waysToCell;
		grid[col][row] = waysToCell;
		return waysToCell;
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
