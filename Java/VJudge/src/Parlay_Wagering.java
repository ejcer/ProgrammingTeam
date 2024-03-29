import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.StringTokenizer;


/**
 * vjudge.com 
 * TeamRound 2  
 * Division 2
 * Problem C
 * @author Edward McEnrue
 */
public class Parlay_Wagering {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int wagers = in.nextInt();
		
		for(int u = 0; u < wagers; u++)
		{
			int init = in.nextInt();
			int n = in.nextInt();
			
			double ans = init;
			boolean loss = false;
			boolean high = false;
			for(int i = 0; i < n; i++)
			{
				double mL = in.nextInt();
				
				String wTL = in.next();
				
				if(wTL.equals("Loss"))
				{
					loss = true;
				}
				else if(wTL.equals("Win")) 
				{
					if(mL >= 0)
					{
						ans+=(.001 * Math.floor((mL/100)*1000) + Math.pow(10, -8))*ans;
						ans = .01 * Math.floor(ans * 100 + Math.pow(10, -8));
					}
					else
					{
						ans+=(.001 * Math.floor((100/Math.abs(mL)*1000) + Math.pow(10, -8)))*ans;
						ans = .01 * Math.floor(ans * 100 + Math.pow(10, -8));
						
					}
					if(ans >= 1000000)
					{
						high = true;
					}
					
				}
			}
			if(loss)
			{
				System.out.println("$0.00");
			}
			else if(high)
			{
				System.out.println("$1,000,000.00");
			}
			else
			{
				NumberFormat fmt = NumberFormat.getCurrencyInstance();
				System.out.println(fmt.format(ans));
			}
			
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
