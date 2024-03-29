package Complete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Vjudge.net
 * Round 1
 * Division 2
 * Problem A
 * @author Edward McEnrue
 */
public class VJ1_First_Composed_Then_Transposed_With_Switch_Case {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();


		String s = in.nextLine();
		int tran = in.nextInt();
		
		while(!s.equals("***"))
		{
			String[] notes = s.split("\\s+"); //there is multiple spaces
			if(!s.isEmpty() && !"".equals(s.trim()))
			{
				int pos = 0;
				for(int i = 0; i < notes.length; i++)
				{
					String note = notes[i];
					if(note.equals("Ab"))
					{
						pos = 11;
					}
					else if(note.equals("A"))
					{
						pos = 0;
					}
					else if(note.equals("A#"))
					{
						pos = 1;
					}
					else if(note.equals("Bb"))  
					{
						pos = 1;
					}
					else if(note.equals("B"))  
					{
						pos = 2;
					}
					else if(note.equals("B#"))  
					{
						pos = 3;
					}
					else if(note.equals("Cb"))  
					{
						pos = 2;
					}
					else if(note.equals("C"))  
					{
						pos = 3;
					}
					else if(note.equals("C#"))  
					{
						pos = 4;
					}
					else if(note.equals("Db"))  
					{
						pos = 4;
					}
					else if(note.equals("D"))  
					{
						pos = 5;
					}
					else if(note.equals("D#"))  
					{
						pos = 6;
					}
					else if(note.equals("Eb"))  
					{
						pos = 6;
					}
					else if(note.equals("E"))  
					{
						pos = 7;
					}
					else if(note.equals("E#"))  
					{
						pos = 8;
					}
					else if(note.equals("Fb"))  
					{
						pos = 7;
					}
					else if(note.equals("F"))  
					{
						pos = 8;
					}
					else if(note.equals("F#"))  
					{
						pos = 9;
					}
					else if(note.equals("Gb"))  
					{
						pos = 9;
					}
					else if(note.equals("G"))  
					{
						pos = 10;
					}
					else if(note.equals("G#"))  
					{
						pos = 11;
					}
					
					tran = tran % 12;
					
					pos += tran; 
					
//					pos = pos % 12;
					
					if(pos < 0)
					{
						pos = 12+pos; //12 + change % 12
					}
					else
					{
						pos = pos % 12;// array out of index bound
					}
					//mod the tran first then go
					//(t % 12) + 12) % 12
					//0 notes case
					//System.err.println(Arrays.t
					//oString(shared)); creates files though
					
					
					if(i == notes.length-1)
					{
						if(pos == 0)
						{
							System.out.print("A");
						}
						else if(pos == 1)
						{
							System.out.print("A#");
						}
						else if(pos == 2)
						{
							System.out.print("B");
						}
						else if(pos == 3)
						{
							System.out.print("C");
						}
						else if(pos == 4)
						{
							System.out.print("C#");
						}
						else if(pos == 5)
						{
							System.out.print("D");
						}
						else if(pos == 6)
						{
							System.out.print("D#");
						}
						else if(pos == 7)
						{
							System.out.print("E");
						}
						else if(pos == 8)
						{
							System.out.print("F");
						}
						else if(pos == 9)
						{
							System.out.print("F#");
						}
						else if(pos == 10)
						{
							System.out.print("G");
						}
						else if(pos == 11)
						{
							System.out.print("G#");
						}
					}
					else
					{
						if(pos == 0)
						{
							System.out.print("A ");
						}
						else if(pos == 1)
						{
							System.out.print("A# ");
						}
						else if(pos == 2)
						{
							System.out.print("B ");
						}
						else if(pos == 3)
						{
							System.out.print("C ");
						}
						else if(pos == 4)
						{
							System.out.print("C# ");
						}
						else if(pos == 5)
						{
							System.out.print("D ");
						}
						else if(pos == 6)
						{
							System.out.print("D# ");
						}
						else if(pos == 7)
						{
							System.out.print("E ");
						}
						else if(pos == 8)
						{
							System.out.print("F ");
						}
						else if(pos == 9)
						{
							System.out.print("F# ");
						}
						else if(pos == 10)
						{
							System.out.print("G ");
						}
						else if(pos == 11)
						{
							System.out.print("G# ");
						}
					}
					
//					if(i == notes.length-1)
//					{
//					System.out.print("true");
//					}
				}
				System.out.println("");
			}
			else
			{
				System.out.println("");
			}
			
			
//			System.out.println(s.isEmpty());
			
			
			
			
			s = in.nextLine();
			if(!s.equals("***"))
			{
				tran = in.nextInt();
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
