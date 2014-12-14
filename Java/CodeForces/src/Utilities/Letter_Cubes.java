package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * PC^2
 * Round 6
 * Division 2
 * Problem Z
 * @author Edward McEnrue
 */
public class Letter_Cubes {
	
	public static HashMap<Character, Integer> cube;
	public static HashMap<Character, ArrayList<Character>> conflicts;
	public static ArrayList<Character> chars;
	
	public static void main(String[] args) {
		MyScanner scan = new MyScanner();
		
		while (true) {
			int N = scan.nextInt();
			if (N == 0)
				break;
			char floating = scan.next().charAt(0);
			ArrayList<String> words = new ArrayList<String>();
			cube = new HashMap<Character, Integer>();
			conflicts = new HashMap<Character, ArrayList<Character>>();
			for (int i = 0; i < N; i++) {
				String w = scan.next();
				words.add(w);
				for (int j = 0; j < w.length(); j++) {
					char c = w.charAt(j);
					cube.put(c, 0);
					if(!conflicts.containsKey(c))
						conflicts.put(c, new ArrayList<Character>());
					for (int k = 0; k < w.length(); k++) {
						if (k != j) {
							conflicts.get(c).add(w.charAt(k));
						}
					}
				}
			}
			int K = words.get(0).length();

			chars = new ArrayList<Character>(cube.keySet());
			Collections.sort(chars);
			
			backTrack(K, 0, new int[5]);

			ArrayList<ArrayList<Character>> groups = new ArrayList<ArrayList<Character>>();
			for (int i = 0; i < K; i++) {
				groups.add(new ArrayList<Character>());
			}

			for (char c : chars) {
				groups.get(cube.get(c) - 1).add(c);
			}

			ArrayList<String> cubeString = new ArrayList<String>();
			for (int i = 0; i < K; i++) {
				 if(groups.get(i).size() != 6)
				 {
					 groups.get(i).add(floating);
					 Collections.sort(groups.get(i));
				 }

				StringBuilder sb = new StringBuilder();
				for (char o : groups.get(i)) {
					sb.append(o);
				}
				cubeString.add(sb.toString());
			}
			Collections.sort(cubeString);
			for (int i = 0; i < cubeString.size() - 1; i++) {
				System.out.print(cubeString.get(i) + " ");
			}
			System.out.println(cubeString.get(cubeString.size() - 1));
		}

	}
	
	public static boolean backTrack(int K, int ind, int[] found) {
		if (ind == chars.size()) {
			return true;
		}
		char c = chars.get(ind);
		for (int i = 1; i <= K; i++) {
			if (found[i] == 6)
				continue;
			
			boolean flag = true;
			for (Character o : conflicts.get(c)) {
				if (cube.get(o) == i) {
					flag = false;
					break;
				}
			}
			if (flag == false)
				continue;
			
			cube.put(c, i);
			found[i]++;
			if (backTrack(K, ind + 1, (int[])found.clone())) {
				return true;
			}
			cube.put(c, 0);
			found[i]--;
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
