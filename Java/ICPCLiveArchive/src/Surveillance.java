import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

import Utilities.IO_Template.MyScanner;


public class Surveillance {
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		int l = in.nextInt(); //length of wall
		int k = in.nextInt(); //amt of cams
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		for(int i = 0; i < k; i++){
			int s = in.nextInt();
			int e = in.nextInt();
			Pair p = new Pair(s, e);
			pairs.add(p);
		}
		
		HashMap<Integer, Boolean> wall = new HashMap<Integer, Boolean>();
		for(int i = 0; i < l; i++){
			wall.put(i, false);
		}
		
		pairs.sort(new Comp());
		
//		
		//if at any point it filled something in, set the flag so that it isn't removed
		
//		
//		
//		
		for(int i = 0; i < pairs.size(); i++){
			Pair cur = pairs.get(i);
			for(int j = 0; j < pairs.size(); j++){
				if(i != j){
					Pair p = pairs.get(j);
					if(cur.start >= p.start && cur.end <= p.end){
						pairs.remove(i);
						continue;
					}
				}
			}
		}
		pairs.sort(new CompSmall());
		for(Pair p : pairs){
			System.out.println(p.start+", "+p.end);
		}
		
		for(int i = 0; i < pairs.size(); i++){
			Pair cur = pairs.get(i);
			int zstart = Integer.MIN_VALUE;
			int zend = Integer.MAX_VALUE;
			for(int j = 0; j < pairs.size(); j++){
				Pair p = pairs.get(j);
				if(i != j){
					if(cur.end <= p.end && cur.end >= p.start && p.start <= zend){
//						cur.end = p.start;
						zend = p.start;
					}
					if(cur.start >= p.start && cur.start <= p.end && p.end >= zstart){
						zstart = p.end;
					}
				}
			}
			if(zstart != Integer.MIN_VALUE){
				cur.start = zstart;
			}
			if(zend != Integer.MAX_VALUE){
				cur.end = zend;
			}
		}
//		for(Pair p : pairs){
//			System.out.println(p.start+", "+p.end);
//		}
		pairs.sort(new Comp());
		
		
		for(int i = 0; i < pairs.size(); i++){
			Pair p = pairs.get(i);
			int s = p.start;
			int e = p.end;
			boolean shouldRemove = true;
			for(int j = s; j < e; j++){ //might need to be <=
				if(!wall.get(j)){
					shouldRemove = false;
				}
//				System.out.println(j);
				wall.put(j, true);
			}
			if(shouldRemove){
				pairs.remove(i);
				i--;
			}
		}
//		for(Pair p : pairs){
//			System.out.println(p.start+", "+p.end);
//		}
		
		
		
//		
//		
//		
		
		boolean flag = true;
		for(int i = 0; i < l; i++){
			if(!wall.get(i)){
				flag = false;
			}
		}
		if(flag){
//			for(Pair p : pairs){
//				System.out.println(p.start+", "+p.end);
//			}
			System.out.println(pairs.size());
		}else{
			System.out.println("coverage incomplete");
		}
		
	}
	
	public static class CompSmall implements Comparator<Pair>{
		 
		@Override
		public int compare(Pair o1, Pair o2) {
			int c1 = o1.end - o1.start;
			int c2 = o2.end - o2.start;
//			if(100 - o1.end > 100-o2.end){
//				return -1;
//			}else if(100 - o1.end < 100-o2.end){
//				return 1;
//			}
//			return 0;
			return c1 - c2;
//			return o1.start - o2.start;
		}
	}
	
	public static class Comp implements Comparator<Pair>{
		 
		@Override
		public int compare(Pair o1, Pair o2) {
			int c1 = o1.end - o1.start;
			int c2 = o2.end - o2.start;
//			if(100 - o1.end > 100-o2.end){
//				return -1;
//			}else if(100 - o1.end < 100-o2.end){
//				return 1;
//			}
//			return 0;
			return c2 - c1;
//			return o1.start - o2.start;
		}
	}
	
	public static class Pair{
		int start;
		int end;
		public Pair(int start, int end){
			this.start = start;
			this.end = end;
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
