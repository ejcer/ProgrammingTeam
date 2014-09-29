package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * Kattis 
 * Round 5
 * Division 2
 * Problem A
 * @author Edward McEnrue
 */
public class Eight_Queens {

	static int[] qPos;
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		HashMap<Integer, Boolean> rChk = new HashMap<Integer, Boolean>();
		HashMap<Integer, Boolean> cChk = new HashMap<Integer, Boolean>(); // column check
		
		qPos = new int[8]; //8 rows storing the column number
		for(int i = 0; i < 8; i++) // rows
		{
			String row = in.nextLine();
			for(int j = 0; j < 8; j++) //columns
			{
				if(row.charAt(j) == '*')
				{
					if(rChk.get(i) != null || cChk.get(j) != null)
					{
						System.out.println("invalid");
						return;
					}
					else
					{
						rChk.put(i, true);
						cChk.put(j, true);
					}
					qPos[i] = j;
				}
			}
		}
		for(int i = 0; i < 8; i++)
		{
			if(backtrack(i))
			{
				System.out.println("invalid");
				return;
			}
		}
		System.out.println("valid");
	}
	
	
	//True if there is an intersection
	public static boolean backtrack(int n) {
        for (int i = 0; i < n; i++) {
            if ((qPos[i] - qPos[n]) == (n - i)) return true;   // same major diagonal
            if ((qPos[n] - qPos[i]) == (n - i)) return true;   // same minor diagonal
        }
        return false;
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
