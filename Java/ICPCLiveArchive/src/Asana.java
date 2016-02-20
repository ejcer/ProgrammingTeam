
public class Asana {
	public static void main(String[] args)
	{
		int[][] matrix = new int[4][4];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				System.out.print(""+(i+j));
				matrix[i][j] = i+j;
				
			}
			System.out.println();
		}
		System.out.println();
		
		printSpiralMatrix(matrix);
	}
	
	public static void printSpiralMatrix(int[][] arr){
		int n = arr.length;
		for(int i = 0; i < n/2; i++){ //layer loop
			int start = i;
			int end = n - i - 1;
			
			for(int j = start; j < end; j++){
				System.out.print(arr[j][start]); // top
			}
			
			for(int j = start; j < end; j++){
				System.out.print(arr[end][j]); // right
				
			}
			for(int j = end; j > start; j--){
				System.out.print(arr[j][end]); // bot
			}
			
			for(int j = end; j > start; j--){
				System.out.print(arr[start][j]); // left
			}
		}
		if(n%2 == 0){
			System.out.print(arr[n/2][n/2]);
		}
		
	}
}
