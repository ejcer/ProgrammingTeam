

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;



public class VJ1_First_Composed_Then_Transposed {

	public static void main(String[] args) {
		new VJ1_First_Composed_Then_Transposed().run();
	}
	
	
	
	HashMap<String, Integer> mScale = new HashMap<String, Integer>();
	HashMap<Integer, String> revScale = new HashMap<Integer, String>();
	

	public void run() {

		MyScanner in = new MyScanner();
		
		mScale.put("A", 1); //
		mScale.put("A#", 2); //
		mScale.put("B", 3); //
		mScale.put("C", 4); //
		mScale.put("C#", 5); //
		mScale.put("D", 6); // 
		mScale.put("D#", 7); //
		mScale.put("E", 8); //
		mScale.put("F", 9); // 
		mScale.put("F#", 10); //
		mScale.put("G", 11); // 
		mScale.put("G#", 12); //
		
		
		for (String key : mScale.keySet()){
		    revScale.put(mScale.get(key), key);
		}
		
		mScale.put("Ab", 12);
		mScale.put("Bb", 2);
		mScale.put("B#", 4);
		mScale.put("Cb", 3);
		mScale.put("Db", 5);
		mScale.put("Eb", 7);
		mScale.put("E#", 9);
		mScale.put("Fb", 8);
		mScale.put("Gb", 10);
		
		
		String notesLine = in.nextLine();
		int transpose = in.nextInt();
		
		while(!notesLine.equals("***"))
		{
			ArrayList<String> sheet = new ArrayList<String>();
			
			String[] notes = notesLine.split(" ");
			
			
			transpose = transpose%12;
			
			
			for(int i = 0; i < notes.length; i++)
			{
				int cur = mScale.get(notes[i]);
				
				if(transpose < 0)
				{
					cur = cur + transpose;
					
					if(cur < 0)
					{
						cur = 12+cur;
					}
					if(cur == 0)
					{
						cur = 12;
					}
					
				}
				else
				{
					cur = cur+transpose;
					if(cur > 12)
					{
						cur = cur - 12;
					}
					if(cur == 0)
					{
						cur = 1;
					}
				}
				
				
				sheet.add(revScale.get(cur));
			}
			
			System.out.println("");
			for(int i = 0; i < sheet.size(); i++)
			{
				System.out.print(sheet.get(i) + " ");
			}
			
			notesLine = in.nextLine();
			
			
			
			if(!notesLine.equals("***"))
			{
				transpose = in.nextInt();
			}
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
