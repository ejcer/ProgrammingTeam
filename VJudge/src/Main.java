import java.util.ArrayList;
import java.util.Scanner;

/*
 * For LiveArchive and many other sites where you copy-paste your code in to 
 * a text box, the class must be called "Main". For codeforces and other sites
 * where you upload a file, you can generally name the class whatever you want,
 * so long as it matches the file name. I recommend giving your class an 
 * informative name as you code, then changing it to "Main" just to submit.
 */
public class Main{

	public static void main(String[] args) {

		// Scanner reads input
		Scanner in = new Scanner(System.in);

		double length = in.nextDouble();
		
		ArrayList<Double> x1s = new ArrayList<Double>();
		
		double x1 = in.nextDouble();
		double x2 = in.nextDouble();
		
		while(x2 >= x1)
		{
			x1s.add(x1);
			
			
			
			
			x1 = in.nextDouble();
			x2 = in.nextDouble();
		}

	}

}