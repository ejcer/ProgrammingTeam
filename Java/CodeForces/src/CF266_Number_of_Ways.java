import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 266
 * Division 2
 * Problem C
 * @author Edward McEnrue
 */
public class CF266_Number_of_Ways {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int N = in.nextInt();
		long a[] = new long[N];
		long V = 0;
		for(int i = 0; i < N; i++) {
			a[i] = in.nextInt();
			V += a[i];
		}
		
		//compute prefix sums
		//find when the prefix sum is 1/3 and find when the prefix sum is 2/3  (thirds of the full sum)
		// multiply 2/3 split points with 1/3 split points but only for the 1/3 split points before 2/3
		
		if(V%3 != 0) {
			System.out.println(0);
			return;
		}
		V /= 3; //3

		long lcnt[] = new long[N];
		{
			long sum = 0;
			for(int i = 0; i < N; i++) { //0,1,2,3,4
				sum += a[i];//1,3,6,6,9
				if(i > 0) {
					lcnt[i] += lcnt[i-1]; //{0,1,1,1,1
				}
				if(sum == V) {
					lcnt[i]++; //{0,1,1,1,1
				}
			}
		}

		long sum = 0;
		long ans = 0;
		for(int i = N-1; i >= 0; i--) {//4, 3
			sum += a[i];//3
			if(sum == V) {
				if(i-2 >= 0) {
					ans += lcnt[i-2];//1, 
				}
			}
		}
		
		System.out.println(ans);

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
