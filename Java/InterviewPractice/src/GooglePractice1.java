import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;



public class GooglePractice1 {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		
	}
	
	public static class Node{
		
		Node next;
		int data;
		
		public Node(int val){ data = val;}
	}
	
	public static class LinkedList{
		Node head;
		
		public LinkedList(){head = null;}
	}
	
	public static class myStack{
		ArrayList<Integer> stackArray; 
		int top;
		
		public myStack(){
			top = -1;
			stackArray = new ArrayList<Integer>();
		}
		
		public void push(int val){
			stackArray.add(val);
			top++;
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
