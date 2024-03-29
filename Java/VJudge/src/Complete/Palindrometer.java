package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Codeforces.com 
 * Round 3 
 * Division 2
 * Problem C
 * @author Edward McEnrue
 */
public class Palindrometer {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
	
		String sNum = in.nextLine();
//		sNum = sNum.substring(0, sNum.length()-1);
		
		while(!sNum.equals("0"))
		{
			int size = sNum.length();
			int cnt = 0;
			int debug = 0;
			while(!isPalindrome(sNum))
			{
				
				int num = Integer.valueOf(sNum);
				num++;
				StringBuilder bSNum = new StringBuilder();
				bSNum.append(num);
				while(bSNum.length() != size)
				{
					bSNum.insert(0, '0');
				}
				sNum = bSNum.toString();
				cnt++;
				
//				debug++;
//				if(debug == 1000)
//					break;
			}
			
			
			
			System.out.println(cnt);
			sNum = in.nextLine();
//			sNum = sNum.substring(0, sNum.length()-1);
		}
		
	}
	
	public static boolean isPalindrome(String s)
	{
		int n = s.length();
		for (int i=0;i<(n / 2) + 1;++i) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				return false;
			}
		}

		return true;
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
