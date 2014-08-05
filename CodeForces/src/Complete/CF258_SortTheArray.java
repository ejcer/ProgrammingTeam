package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CF258_SortTheArray {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

		int s = in.nextInt();

		int[] a = new int[s];
		int[] as = new int[s];

		for (int i = 0; i < s; i++) {
			int input = in.nextInt();

			a[i] = input;
			as[i] = input;
		}

		Arrays.sort(as);

		ArrayList<Integer> valuesOfDifferent = new ArrayList<Integer>();
		ArrayList<Integer> indexOfDifferent = new ArrayList<Integer>();
		ArrayList<Integer> valuesOfSame = new ArrayList<Integer>();
		ArrayList<Integer> indexOfSame = new ArrayList<Integer>();

		int segStart = -1;
		int segEnd = -1;

		for (int i = 0; i < s; i++) {
			if (a[i] != as[i] && segStart == -1 && segEnd == -1) {
				segStart = i;
			}
			if (a[i] != as[i] && segStart != -1) {
				segEnd = i;
			}

		}

		for (int i = 0; i < s; i++) {
			if (i >= segStart && i <= segEnd) {
				valuesOfDifferent.add(a[i]);
				indexOfDifferent.add(i);
			} else {
				valuesOfSame.add(a[i]);
				indexOfSame.add(i);
			}
		}

		Collections.reverse(valuesOfDifferent); // works

		Map<Integer, Integer> tm = new TreeMap<Integer, Integer>();

		for (int i = 0; i < indexOfDifferent.size(); i++) {
			tm.put(indexOfDifferent.get(i), valuesOfDifferent.get(i));
			// System.out.println("index: "+indexOfDifferent.get(i)+" value: "+valuesOfDifferent.get(i));
		}

		for (int i = 0; i < indexOfSame.size(); i++) {
			tm.put(indexOfSame.get(i), valuesOfSame.get(i));
		}

		boolean isGood = true;

		for (int i = 1; i < s; i++) {
			int cur = tm.get(i);
			int prev = tm.get(i - 1);

			if (prev > cur) {
				isGood = false;
				break;
			}

		}

		if (isGood) {
			System.out.println("yes");
			if (segStart == -1) {
				System.out.println("1 1");
			} else {
				System.out.println((segStart + 1) + " " + (segEnd + 1));
			}

		} else {
			System.out.println("no");
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
}
