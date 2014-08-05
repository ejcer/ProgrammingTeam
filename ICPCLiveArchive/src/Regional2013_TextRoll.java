import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Regional2013_TextRoll {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int lines = in.nextInt();
		
		int highest = 0;
		
		for(int i = 0; i < lines; i++)
		{
			char[] line = in.nextLine().toCharArray();
			
			for(int j = highest; j < line.length; j++)
			{
				if(line[j] == ' ')
				{
					highest = j;
					break;
				}
			}
		}
		
		System.out.println(highest+1);
		
		

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
}
