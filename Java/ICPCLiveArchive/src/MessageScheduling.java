import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class MessageScheduling {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		PriorityQueue<Message> pQueue = new PriorityQueue<Message>(new MessageComparator());
		String curCmd = in.next();
		while(!curCmd.equals("quit")){
			if(curCmd.equals("post")){
				pQueue.add(new Message(in.nextInt(), in.nextInt(), in.nextInt()));
			}else{
				if(pQueue.isEmpty()){
					System.out.println("No messages");
				}else{
					System.out.println(pQueue.poll().id);
				}
				
			}
			curCmd = in.next();
		}
		
		
	}
	
	public static class MessageComparator implements Comparator<Message>{
		@Override
		public int compare(Message m1, Message m2){
			
			if(m1.priority == m2.priority){
				return m1.length - m2.length;
			}else{
				return m2.priority - m1.priority;
			}
		}
	}
	
	public static class Message{
		int id;
		int priority;
		int length;
		
		public Message(int id, int priority, int length){
			this.id = id;
			this.priority = priority;
			this.length = length;
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
