
import java.util.Scanner;

public class TextRoll {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int lines = in.nextInt();
		
		in.nextLine();
		
		int highest = 0;
		
		for(int i = 0; i < lines; i++)
		{
			char[] line = in.nextLine().toCharArray();
			
			boolean last = true;
			
//			System.out.println(line.length);
//			System.out.println(highest);
			for(int j = highest; j < line.length; j++)
			{
//				System.out.println(line[j]);
//				System.out.println(highest);
				if(line[j] == ' ')
				{
					highest = j;
					last = false;
					break;
				}
				//might be the last line in a row of 100
				//might be a row of no letters just spaces
				
			}
			if(last && highest < line.length+1) highest = line.length;
		}
		System.out.println(highest+1);
	}
}
