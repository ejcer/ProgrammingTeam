import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class testingVJudge {
	
	static HashMap<String, Integer> mScale = new HashMap<String, Integer>();
	static HashMap<Integer, String> revScale = new HashMap<Integer, String>();
	
	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
				
				mScale.put("Ab", 12);
				mScale.put("A", 1); //
				mScale.put("A#", 2); //
				mScale.put("Bb", 2);
				mScale.put("B", 3); //
				mScale.put("B#", 4);
				mScale.put("Cb", 3);
				mScale.put("C", 4); //
				mScale.put("C#", 5); //
				mScale.put("Db", 5);
				mScale.put("D", 6); // 
				mScale.put("D#", 7); //
				mScale.put("Eb", 7);
				mScale.put("E", 8); //
				mScale.put("E#", 9);
				mScale.put("Fb", 8);
				mScale.put("F", 9); // 
				mScale.put("F#", 10); //
				mScale.put("Gb", 10);
				mScale.put("G", 11); // 
				mScale.put("G#", 12); //
				
				
				for (String key : mScale.keySet()){
				    revScale.put(mScale.get(key), key);
				}
				
				// Main loop
				while (true) {

					System.out.println("a;skdjf;alskjdfal");
					ArrayList<Integer> sheet = new ArrayList<Integer>();
					
					String note = in.next();
					
					while(!isNumeric(note) && !note.equals("***"))
					{
						sheet.add(mScale.get(note));
					}
					if(isNumeric(note))
					{
						int scale = Integer.parseInt(note);
						scale = scale%12; //does not work for negatives
						
						for(int sNote:sheet)
						{
							sNote += scale;
							sNote = sNote%12;
							System.out.print(revScale.get(sNote) + " ");
						}
					}
					else
					{
						break;
					}
				}

			}
			
			public static boolean isNumeric(String str)  
			{  
			  try  
			  {  
			    double d = Double.parseDouble(str);  
			  }  
			  catch(NumberFormatException nfe)  
			  {  
			    return false;  
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
