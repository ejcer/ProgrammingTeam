import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * Codeforces.com 
 * Round 6
 * Division 2
 * Problem F
 * @author Edward McEnrue
 */
public class Digit_Sum {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		while(true)
		{
			int n = in.nextInt();
			if(n == 0)
				break;
			
			int[] nums = new int[n];
			int zcnt = 0;
			for(int i = 0; i < n;i++)
			{
				int z = in.nextInt();
				if(z == 0)
					zcnt++;
				nums[i] = z;
			}
			Arrays.sort(nums);
			
			
			int num1 = 0;
			int num2 = 0;
			
			
			int cnt = 0;
			
			num1+=nums[zcnt];
			num2+=nums[zcnt+1];
			
			int tempz = zcnt;
			while(tempz > 0)
			{
				if(cnt%2==0)
					num1*=10;
				else
					num2*=10;
				tempz--;
			}
			for(int i = zcnt+1; i < n; i++) //err zcnt+1 only if zcnt == 2
			{
				System.out.println(nums[i]);
				num1*=10;
				num1+=nums[i];
				
				i++;
				if(i < n)
				{
					num2*=10;
					num2+=nums[i];
				}
			}
			System.out.println("num1: "+ num1);
			System.out.println("num2: "+ num2);
			
			System.out.println(num1+num2);
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
