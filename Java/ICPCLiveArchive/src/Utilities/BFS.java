package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import Utilities.IO_Template.MyScanner;

public class BFS {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		//given node 1 and node 2
		
		Node start = new Node("hodor");
		
		Node end = new Node("balfor");
		boolean flag = false;
		
		LinkedList<Node> queue = new LinkedList<Node>();
		start.state = State.VISITED;
		queue.addFirst(start);
		while(!queue.isEmpty()){
			Node cur = queue.pop();
			for(Node n : start.neighbors){
				if(n.name.equals(end.name)){
					flag = true;
					break;
				}
				n.state = State.VISITED;
				queue.addLast(n);
			}
			cur.state = State.UNVISITED;
		}
		
		if(flag){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
	
	public enum State{
		VISITED, UNVISITED
	}

	public static class Node {
		
		ArrayList<Node> neighbors;
		String name;
		State state;
		
		public Node(String name){
			this.name = name;
			neighbors = new ArrayList<Node>();
			state = State.UNVISITED;
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
