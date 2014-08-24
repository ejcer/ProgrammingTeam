import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 256
 * Division 2
 * Problem B
 * @author Edward McEnrue
 *
 */
public class CF256_Suffix_Structures {
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		String s = in.nextLine();
		String t = in.nextLine();
		
		HashMap<Character, Integer> s1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer>
		for(int i = 0; i < t.length())
		
		
		if(t1.isEmpty())
		{
			if(s.length() == t.length())
			{
				System.out.println("array");
			}
			else 
			{
				//remove all the superflous letters in order that matches t
				int cnt = 0;
				char[] s2 = s.toCharArray();
				int highest = 0;
				for(int i = 0; i < t.length(); i++)
				{
					for(int j = highest; j < s.length(); j++)
					{
						if(t.charAt(i) == s.charAt(j))
						{
							highest = j;
							cnt++;
						}
					}
				}
				if(cnt == t.length())
				{
					System.out.println("automaton");
				}
				else
				{
					System.out.println("need both");
				}
			}
		}
		else
		{
			System.out.println("need tree");
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
