
import java.util.Scanner;

/*
 * For LiveArchive and many other sites where you copy-paste your code in to 
 * a text box, the class must be called "Main". For codeforces and other sites
 * where you upload a file, you can generally name the class whatever you want,
 * so long as it matches the file name. I recommend giving your class an 
 * informative name as you code, then changing it to "Main" just to submit.
 */
public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	// Since we're no longer working in static context, we can use class
	// variables! However, be very careful not to re-use these between problem
	// instances.
	int a, b;

	public void run() {

		// Scanner reads input
		Scanner in = new Scanner(System.in);

		// Main loop
		while (true) {

			// Read input and test for termination
			a = in.nextInt();
			b = in.nextInt();
			if (a == 0 && b == 0) {
				break;
			}

			// Solve the problem
			int res = a + b;

			// Print the answer
			System.out.println(res);
		}

	}

}