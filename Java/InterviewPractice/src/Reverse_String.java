import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author Edward McEnrue
 */
public class Reverse_String {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		char[] rev = in.next().toCharArray();
		int end = rev.length-1;
		
		for(int i = 0; i < rev.length; i++)
		{
			if(end < i)
				break;
			char temp = rev[i];
			rev[i] = rev[end];
			rev[end] = temp;
			end--;
		}
		
		for(int i = 0; i < rev.length; i++)
		{
			System.out.print(rev[i]);
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
