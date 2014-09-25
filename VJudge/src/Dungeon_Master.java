import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.omg.PortableServer.POAManagerPackage.State;


/**
 * vjudge.com 
 * TeamRound 2
 * Division 2
 * Problem C
 * @author Edward McEnrue
 */
public class Dungeon_Master {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();

	}
	
	
	static class State
	{
		//TODO implement isFinal(), successors(), equals(), hashCode(),
		char state;
		
		//What is state?
		
		@Override
		public int hashCode() {
			//return state.hashCode();
		}
	}
	
	void solve(State start)
	{
		Set<State> visited = new HashSet<State>();
		//has this state been visited
		Map<State, State> pred = new HashMap<State, State>();
		//predecessor on the shortest path to the start state
		Map<State, Integer> dist = new HashMap<State, Integer>();
		//shortest distance to start state
		Deque<State> bfs = new ArrayDeque<State>(); //BFS queue
		bfs.offer(start);
		dist.put(start, 0);
		
		while(bfs.size() > 0)
		{
			State s = bfs.poll();
			int n = dist.get(s);
			visited.add(s);
			
			if(s.isFinal())
			{
				output(n, s, pred);
				return;
			}
			
			for(State succ : s.successors())
			{
				if(visited.contains(succ))
					continue;
				
				if(!pred.containsKey(succ))
					pred.put(succ, s);
				
				if(!dist.containsKey(succ))
				{
					dist.put(succ, n+1);
					bfs.offer(succ);
				}
			}
		}
		
	}
	
	void output(int distToSolution, State finalState, Map<State, State> pred)
	{
		System.out.println("The distance to the solution is: " + distToSolution);
		
		List<State> revPath = new ArrayList<State>();
		State s = finalState;
		while (pred.containsKey(s))
		{
			revPath.add(s);
			s = pred.get(s);
		}
		revPath.add(s);
		
		for(int i = 0; i < revPath.size(); i++)
		{
			System.out.printf("%3d %s%n", i, revPath.get(revPath.size() - 1 - i));
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
