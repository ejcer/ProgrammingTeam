import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;



public class AssigningTeams {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		int n = in.nextInt();
		int e = in.nextInt();
		
		HashMap<Integer, Node> graph = new HashMap<Integer, Node>();
		for(int i = 0; i < n; i++){
			graph.put(i, new Node(new ArrayList<Node>(), -1, i));
		}
		for(int i = 0; i < e; i++){
			int team1 = in.nextInt();
			int team2 = in.nextInt();
			
			graph.get(team1).neighbors.add(graph.get(team2));
			graph.get(team2).neighbors.add(graph.get(team1));
		}
		boolean hasNo = false;
		boolean flag = true;
		for(int i = 0; i < n; i++){
			if(graph.get(i).visited == 0 && !hasNo){
				if(!color(graph, i)){
					System.out.println("no");
					flag = false;
					hasNo = true;
				}
			}
		}
		if(flag && !hasNo){
			System.out.println("yes");
		}
		
	}
	
	public static boolean color(HashMap<Integer, Node> graph, int startID){
		
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		graph.get(startID).team = 0;
		queue.offerLast(graph.get(startID));
		
		
		while(!queue.isEmpty()){
			
			
			Node cur = queue.pollFirst();
			cur.visited = 1;
			for(Node adj : cur.neighbors){
				if(adj.visited == 0){
					adj.team = (cur.team == 1) ? 0:1;
					queue.offerLast(adj);
				}else if(adj.team == cur.team){
					return false;
				}
			}
		}
		return true;
	}
	
	public static class Node {
		ArrayList<Node> neighbors;
		int team;
		int id;
		int visited;
		
		public Node(ArrayList<Node> neighbors, int team, int id){
			this.neighbors = neighbors;
			this.team = team;
			this.id = id;
			visited = 0;
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
