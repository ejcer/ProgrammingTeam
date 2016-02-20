import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;


public class Testing_Intervals {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		
		Random rand = new Random();
		intervals.add(new Interval(0, 10, 19));
		intervals.add(new Interval(2, 6, 19));
		intervals.add(new Interval(3, 4, 19));
		intervals.add(new Interval(6, 10, 19));
		intervals.add(new Interval(1, 3, 19));
		intervals.add(new Interval(4, 5, 19));
		intervals.add(new Interval(7, 13, 19));
		
		System.out.println(intervals.toString());
		System.out.println(maxIntervalHeight(intervals).toString());
	}

	
	public static Interval maxIntervalHeight(ArrayList<Interval> intervals){
		
		ArrayList<Event> endpoints = new ArrayList<Event>();
		for(Interval interval : intervals){
			endpoints.add(new Event(interval.start, 1, interval));
			endpoints.add(new Event(interval.end, -1, interval));
		}
		
		Collections.sort(endpoints);
		
		int maxCount = 0;
		Event maxEvent = null;
		int curCount = 0;
		for(Event event : endpoints){
			curCount += event.type;
			if(curCount > maxCount){
				maxCount = curCount;
				maxEvent = event;
			}
		}
			
		if(maxEvent == null){
			return null;
		}else{
			return maxEvent.interval;
		}
	}
	
	public static class Event implements Comparable<Event> {
		int time;
		int type;
		Interval interval;
		public Event(int time, int type, Interval interval){
			this.time = time;
			this.type = type;
			this.interval = interval;
		}
		
		@Override
		public int compareTo(Event that){
			
			if(this.time < that.time ){
				return -1;
			}else if(this.time > that.time){
				return 1;
			}else{
				if(that.type == 1){
					return -1;
				}else{
					return 1;
				}
			}
		}
	}
	
	public static class Interval implements Comparable<Interval>{
		int start;
		int end;
		int value;
		
		public Interval(int start, int end, int value){
			this.start = start;
			this.end = end;
			this.value = value;
		}
		@Override
		public int compareTo(Interval that){
			if(this.start < that.start){
				return -1;
			}else if(this.start > that.start){
				return 1;
			}else{
				return 0;
			}
		}
		
		@Override
		public String toString(){
			return "["+this.start+", "+this.end+"]";
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
