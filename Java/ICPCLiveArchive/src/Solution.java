import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
 
        if(matrix == null || matrix.length == 0) return result;
 
        int nrows = matrix.length;
        int ncols = matrix[0].length;
 
        int row=0; 
        int col=0;
 
        while(nrows>0 && ncols>0){
 
            //if one row/column left, no circle can be formed
            if(nrows==1){
                for(int i=0; i<ncols; i++){
                    result.add(matrix[row][col++]);
                }
                break;
            }else if(ncols==1){
                for(int i=0; i<nrows; i++){
                    result.add(matrix[row++][col]);
                }
                break;
            }
 
            //below, process a circle
 
            //top - move right
            for(int i=0;i<ncols-1;i++){
                result.add(matrix[row][col++]);
            }
 
            //right - move down
            for(int i=0;i<nrows-1;i++){
                result.add(matrix[row++][col]);
            }
 
            //bottom - move left
            for(int i=0;i<ncols-1;i++){
                result.add(matrix[row][col--]);
            }
 
            //left - move up
            for(int i=0;i<nrows-1;i++){
                result.add(matrix[row--][col]);
            }
 
            row++;
            col++;
            nrows=nrows-2;
            ncols=ncols-2;
        }
 
        return result;
    }
    
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
    	int n = 5;
		int[][] mat = new int[5][6];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 6; j++){
				mat[i][j] = j;
			}
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 6; j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		ArrayList<Integer> spiral = spiralOrder(mat);
		System.out.println(spiral);
//		for(int i = 0; i < n; i++){
//			for(int j = 0; j < n; j++){
//				System.out.print(mat[i][j]);
//			}
//			System.out.println();
//		}
    }
}