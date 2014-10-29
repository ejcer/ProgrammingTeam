import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * PC^2 
 * Round 6
 * Division 2
 * Problem G
 * @author Edward McEnrue
 */
public class Cash_Cow {

	public enum Color {
		EMPTY(-1),
		BLUE(0),
		RED(1),
		YELLOW(2);
		int value;
		Color(int value){
			this.value = value;
		}
		public int getValue(){
			return value;
		}
	}
	
	
	static Color[][] board;
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int counter = 0;
		for(int alpha = 'a'; alpha < 'j'; alpha++)
		{
			map.put((char) alpha, counter); // Does this work?
			counter++;
		}
		
		int n = in.nextInt();
		while(n != 0)
		{
			
			n = in.nextInt();
		}
	}

	private static void click(Color[][] board2, int row, int col) {
		
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
