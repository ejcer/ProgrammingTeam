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
		MyScanner sc = new MyScanner();
		
		int n = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> employees = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < n; i++){
			ArrayList<Integer> conflicts = new ArrayList<Integer>();
			employees.put(i, conflicts);
		}
		int c = sc.nextInt();
		
		for(int i = 0; i < c; i++){
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			ArrayList<Integer> employee1 = employees.get(c1);
			ArrayList<Integer> employee2 = employees.get(c2);
			employee1.add(c2);
			employee2.add(c1);
		}
		
		System.out.println(""+findTeams(employees, new ArrayList<Integer>(), new ArrayList<Integer>(), 0, n));
		//list team 1
		//list team 2
		//list of employees who have a list of conflicts
		//base case is when we have a team where each employee doesn't conflict
		//we want to find the min difference
	}
	
	public static int findTeams(HashMap<Integer, ArrayList<Integer>> employees, ArrayList<Integer> t1, ArrayList<Integer> t2, int curNum, int n){
		if(curNum == n && checkTeams(employees, t1, t2)){
			return Math.abs(t1.size() - t2.size()); 
		}
		//lets put in a team member, x, into t1, and then recursively call, and then put x into t2, and then recursively call. Find the min between these two recursive calls
		
		ArrayList<Integer> t1Mod = new ArrayList<Integer>();
		t1Mod.addAll(t1);
		t1Mod.add(curNum);
		ArrayList<Integer> t2Mod = new ArrayList<Integer>();
		t2Mod.addAll(t2);
		t2Mod.add(curNum);
		
		return Math.min(findTeams(employees, t1Mod, t2, curNum+1, n), findTeams(employees, t1, t2Mod, curNum+1, n));
	}
	
	public static boolean checkTeams(HashMap<Integer, ArrayList<Integer>> employees, ArrayList<Integer> t1, ArrayList<Integer> t2) {
		for(int t1Num : t1){
			ArrayList<Integer> conflicts = employees.get(t1Num);
			for(int i = 0; i < conflicts.size(); i++){
				for(int j = 0; j < t2.size(); j++){
					if(conflicts.get(i) == t2.get(j)){
						return false;
					}
				}
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
