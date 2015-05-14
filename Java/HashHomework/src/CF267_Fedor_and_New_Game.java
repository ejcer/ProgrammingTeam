import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 267
 * Division 2
 * Problem B
 * @author Edward McEnrue
 */
public class CF267_Fedor_and_New_Game {

	public static void main(String[] args) {
		ArrayList<Long> keyValues = new ArrayList<Long>();
		keyValues.add((long) 43);
		keyValues.add((long) 23);
		keyValues.add((long) 71);
		keyValues.add((long) 47);
		keyValues.add((long) 15);
		keyValues.add((long) 31);
		keyValues.add((long) 84);
		keyValues.add((long) 27);
		keyValues.add((long) 11);
		keyValues.add((long) 63);
		for(int i = 0; i < keyValues.size(); i++){
			System.out.println(h1(keyValues.get(i))%13);
		}
		
		
		
		
//System.out.println("b:"+(5 + quadProbe(5))%13);
		
		
		
		//HashMap<Integer, Long> hm = new HashMap<Integer, Long>();
		
		
		

	}
	
	public static long h1(long key){
		long x = (key + 7) * (key + 7);
		x = x / 16;
		x = x + key;
		return x;
	}
	
	public static long quadProbe(long k){
		return (long) ((Math.pow(k, 2) + k)/2);
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
