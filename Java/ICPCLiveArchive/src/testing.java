import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;


public class testing {
	
		public static void main(String[] args)
		{
			
			
			
			
			
			//print diagonals
			
			
//			int[][] matrix = new int[5][5];
//			for(int i = 0; i < matrix.length; i++){
//				for(int j = 0; j < matrix.length; j++){
//					System.out.print(""+(i+j));
//					matrix[i][j] = i+j;
//					
//				}
//				System.out.println();
//			}
//			System.out.println();
			
//			printDiagonals(matrix);
//			printSpiral(matrix);
			
			
			//look and say sequence
//			String[] seq = look_and_say("1", 10);
//	        System.out.println(Arrays.toString(seq));
//	        lookAndSay("1", 10);
			
	        //merge sort
//			int[] a = {2, 6, 3, 5, 1, 8};
//			sortMyArray(a);
//			System.out.println(Arrays.toString(a));
			int input = 1775; // expected output 8
			
			//find all sequences by traversing bitwise through the input
			//keep a counter of the bits for a sequence
			//increment the counter til you reach a bit is different from the current one
				//add this sequence counter to your list of sequences
				//reset counter to 0
			
			
//			ArrayList<Integer> sequences = getSequences(input);
//			int max = findMaxSequence(sequences);
//			int n = 5;
//			int[][] mat = new int[5][5];
//			for(int i = 0; i < n; i++){
//				for(int j = 0; j < n; j++){
//					mat[i][j] = j;
//				}
//			}
//			
//			for(int i = 0; i < n; i++){
//				for(int j = 0; j < n; j++){
//					System.out.print(mat[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//			
//			rotateArr(mat, n);
//			
//			for(int i = 0; i < n; i++){
//				for(int j = 0; j < n; j++){
//					System.out.print(mat[i][j]);
//				}
//				System.out.println();
//			}
//			
//			
//			
//			
//			
//			
//			//0000 0101
//			//0000 1001
//			//0010 1101
//			int a = 9; //0000 0101
//			int temp = a;
//			int b = 5; //0000 1001
//			int r = 0;//0010 1101
//			int mask = 1;
//			while(a != 0){
//				
//				if((mask & a) == 1){
//					r += b;
//				}
//				a = a >> 1;
//				b = b<< 1;
//			}
//			System.out.println(r);
//			
//			int result = 0;
//			a = 5;
//			b = 9;
//			while (b != 0)
//		    {
//		        /* Using the bitwise AND trick, determine whether the ith 
//		         * bit of b is a zero or one.  If it's a zero, then the
//		         * current term in our sum is zero and we don't do anything.
//		         * Otherwise, then we should add n1 * 2^i.
//		         */
//		        if ((b & 1) != 0)
//		        {
//		            /* Recall that a = n1 * 2^i at this point, so we're adding
//		             * in the next term in the sum.
//		             */
//		            result = result + a;
//		        }
//
//		        /* To maintain that a = n1 * 2^i after i iterations, scale it
//		         * by a factor of two by left shifting one position.
//		         */
//		        a <<= 1;
//
//		        /* To maintain that b = n2 >> i after i iterations, shift it
//		         * one spot over.
//		         */
//		        b >>>= 1;
//		    }
//			
//			System.out.println(result);
//			int [][] a = new int[4][];
//			a[0] = new int[50000];
//			for(double i = 1; i < 5.5; i+=.5){
////	        	Thread.sleep(40);
//				a[0] = new int[5];
//	        	System.out.println((int)((-1120)*i*i*i + 12534*i*i - 49000*i+82118));
////	        	HeapTracker.takeLiveHeapSample();
//	        }
			
			
			
			
			
//			int dim = 5;
//		    char ch = 'A';
//		    String[][] array = new String[dim][];
//		    for( int i = 0 ; i < dim ; i++ ) {
//		        array[i] = new String[dim];
//		        for( int j = 0 ; j < dim ; j++, ch++ ) {
//		            array[i][j] = "" + ch;
//		        }
//		    }
//		    
//		    for( int diag = 0 ; diag < dim ; diag++ ) {
//		        for( int col = 0 ; col <= diag ; col++ ) {
//		            int row = diag - col;
//		            System.out.print( array[row][col] + " " );
//		        }
//		        System.out.println();
//		    }
//		    
//		    
//		    for( int diag = dim - 2 ; diag >= 0 ; diag-- ) {
//		        for( int row = 0 ; row <= diag ; row++ ) {
//		            int col = diag - row;
//		            System.out.print( array[dim - row - 1][dim - col - 1] + " " );
//		        }
//		        System.out.println();
//		    }
//		    
//		    for( int i = 0 ; i < dim ; i++ ) {
//		        for( int j = 0 ; j < dim ; j++, ch++ ) {
//		            System.out.print( array[i][j] + " " );
//		        }
//		        System.out.println();
//		    }
//		    System.out.println( "============================" );
//			
			
			
			
			
			
			
			
			
			
			
			
//			Node head = new Node(1);
//			head.left = new Node(1);
////			head.left.right = new Node(1);
//			head.right = new Node(1);
////			head.right.left = new Node(1);
//			head.left.left = new Node(1);
//			head.left.left.left = new Node(1);
//			
////			System.out.println(maxHeight(head));
////			System.out.println(minHeight(head));
////			System.out.println(maxHeight(head)-minHeight(head));
//			System.out.println("min: "+diff(head, 0)[0]+" max:"+diff(head, 0)[1]);
//			int n = 20;
//			int[] fib = new int[n];
//			fib[0] = 1;
//			fib[1] = 1;
//			for(int i = 2; i < n; i++){
//				fib[i] = fib[i-1] + fib[i-2];
//			}
//			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
//			hm.put(1, 1);
//			hm.put(2, 1);
//			System.out.println(fib(n, hm));
			
			
			
			
		}
//		
//		
//		
//		public static void serialize(HashMap hm, StringBuilder sb){
//			sb.append("{");
//			for(T key: hm.keySet()){
//				sb.append("key:");
//				T val = hm.get(key);
//				if(val instanceof HashMap){
//					serialize(val);
//				}else{
//					sb.append("val,");
//				}
//			}
//			sb.append("}");
//		}
//		
//		public static HashMap deserialize(String jsonString){
//			//create a hashmap
//			//read in each key and then delimit the value by ":"
//			//if what you read in for value is "{"
//				//then call the deserialize method recursively using a new jsonString that is created by using a stack to 
//				//keep track of when this value ends it's own object.
//			//else just add the value
//			//return the hashmap
//			
//		}

		public static int fib(int n, HashMap<Integer, Integer> hm){
			if(hm.get(n) != null){
				return hm.get(n);
			}
			if(n == 1){
				return 1;
			}
			
			if(n == 2){
				return 1;
			}
			int result = fib(n-1, hm) + fib(n-2, hm);
			hm.put(n, result);
			return result;
			
		}
		
		public static int[] diff(Node head, int height){
			
			
			if(head.left == null && head.right == null){
				int[] base = new int[2];
				base[0] = 0;
				base[1] = 0;
			}
			int[] left = new int[2];
			left[0] = Integer.MAX_VALUE;
			left[1] = Integer.MIN_VALUE;
			if(head.left != null){
				left = diff(head.left, height+1);
			}
			int[] right = new int[2];
			right[0] = Integer.MAX_VALUE;
			right[1] = Integer.MIN_VALUE;
			if(head.right != null){
				right = diff(head.right, height+1);
			}
			
			
			int[] minmax = new int[2];
			minmax[0] = 1+Math.min(left[0], right[0]);
			minmax[1] = 1+Math.max(left[1], right[1]);
			
			
			return minmax;
		}
		
		public static int maxHeight(Node head){
			if(head == null){
				return 0;
			}
			
			return 1+ Math.max(maxHeight(head.left), maxHeight(head.right));
		}
		
		public static int minHeight(Node head){
			if(head == null){
				return 0;
			}
			
			return 1+ Math.min(maxHeight(head.left), maxHeight(head.right));
		}
		
		public static class Node{
			Node left;
			Node right;
			int data;
			
			public Node(int data){
				this.data = data;
				left = null;
				right = null;
			}
		}
		
		
		public static void rotateArr(int[][] mat, int n){
			if (mat == null){
				return;
			}
			
			for(int i = 0; i < n/2; i++){
				int last = n-1-i;
				int len = n-1;
				for(int j = i; j<last;j++){
					int offset = j-i;
					int temp = mat[i][j];
					mat[i][j] = mat[len-i-offset][i];
					mat[len-i-offset][i] = mat[len-i][len-i-offset];
					mat[len-i][len-i-offset] = mat[j][len-i];
					mat[j][len-i] = temp;
				}
			}
		}
		
		public static int findMaxSequence(ArrayList<Integer> sequences){
			
			//if you encounter a sequence with length 1, then add the it's left and right sequence + 1
			//if you encounter any other kind of sequence, then only use the it + the max of it's left or right + 1
			
			
			
			return 0;//TODO
		}
		
		public static ArrayList<Integer> getSequences(int n){
			int num = n;
			ArrayList<Integer> seq = new ArrayList<Integer>();
			
			int curBit = num & 1;
			int counter = 1;
			num = num >> 1;
			for(int i = 1; i < 32; i++){
				if(curBit != (num & 1)){
					// the next one isn't the same as curBit
					seq.add(counter);
					counter = 1;
				}else{
					//they are the same
					counter++;
				}
				curBit = num & 1;
				num = num >> 1;
			}
			seq.add(counter);
			return seq;
		}
		
		
		//true = 1
		//false = 0
		public static boolean getBit(int input, int i){
			return (input & (1 << i)) != 0;
		}
		
//		public static class Node<K extends Comparable<K>, V>{
//			V value;
//			K key;
//			Node left;
//			Node right;
//			public Node(K key, V value){
//				this.value = value;
//				this.key = key;
//			}
//		}
//		
//		public static class BSTMap<K extends Comparable<K>, V>{
//			Node<K, V> root;
//			int size;
//			public BSTMap(){
//				this.size = 0;
//				this.root = null;
//			}
//			
//			public V get(K key){
//				if(key == null){
//					return null;
//				}else{
//					return get(this.root, key).value;
//				}
//			}
//			
//			public Node<K, V> get(Node<K, V> root, K key){
//				
//				if(root == null){
//					return null;
//				}
//				
//				int comp = root.key.compareTo(key);
//				if(comp > 0){
//					return get(root.left, key);
//				}else if(comp < 0){
//					return get(root.right, key);
//				}else{
//					return root;
//				}
//			}
//			
//			
//		}
		
//
//public static void printSpiral(int[][] arr){
// int i = 0;
// int row = 0; 
// int col = 0; 
// int m = arr.length;
// int n = arr[0].length;
// 
// while(col < n && row < m){
//  for (i = col; i < n; i++){
//    System.out.print(arr[row][col]);
//  }
//  row++;
//  for(i = row; i < m; i++){
//    System.out.print(arr[i][n-1]);
//  }
//  n--;
//  
//  if(row < m){
//   for(i = n-1; i >= col; i--){
//    System.out.print(arr[m-1][i]);
//   }
//   m--;
//  }
//
//  if(col < n){
//   for(i = m-1; i >= row; i--){
//    System.out.print(arr[i][col]);
//   }
//   col--;
//  }
// }
//}
//		
//		
//		public static void sprintSpiral(int[][] arr){
//			int size = arr.length;
//			for (int l = 0; l < size / 2; l++)
//		    {
//		        int min = l;
//		        int max = size - 1 - l;
//		        for (int i = min; i < max; i++)
//		            System.out.print("\t" + arr[i][min]);
//		        for (int j = min; j < max; j++)
//		            System.out.print("\t" + arr[max][j]);
//		        for (int i = max; i > min; i--)
//		            System.out.print("\t" + arr[i][max]);
//		        for (int j = max; j > min; j--)
//		            System.out.print("\t" + arr[min][j]);
//		    }
//		    // centre is special case: avoiding printing it 4 times.
//		    if (size % 2 == 1)
//		        System.out.print("\t" + arr[size / 2][size / 2]);
//		}
//		
		public static void printDiagonals(int[][] matrix){
			if(matrix == null){
				System.out.println("matrix input is null");
				return;
			}
			int n = matrix.length;
			for(int i = 0; i < n*n; i++){
				for(int j = 0; j < n; j++){
					int k = i - j;
					if(k < n && j < n){
						System.out.println(matrix[i][j]);
					}
				}
			}
//			for(int i = 1; i < matrix[0].length-1; i++){
//				//for each bottom cell except the last
//				for(int j = 0; i+j < matrix.length; j++){
//					//print diagonal loop
//					System.out.print(matrix[i+j][j]);
//				}
//				System.out.println();
//			}
//			for(int i = 0; i < matrix[0].length; i++){
//				//for each top cell
//				for(int j = 0; i+j < matrix[0].length; j++){
//					//print diagonal loop
//					System.out.print(matrix[j][i+j]);
//				}
//				System.out.println();
//			}
			
			
		}
		
		
		
//		public static void lookAndSay(String seed, int n){
//			System.out.println(seed);
//			String str = seed;
//			for(int i = 1; i < n; i++){
//				char ch = str.charAt(0);
//				int freq = 1;
//				StringBuilder sb = new StringBuilder();
//				for(int j = 1; j < str.length(); j++){
//					if(ch != str.charAt(j)){
//						//different character
//						sb.append(freq);
//						sb.append(ch);
//						ch = str.charAt(j);
//						freq = 1;
//					}else{
//						freq++;
//					}
//				}
//				sb.append(freq);
//				sb.append(ch);
//				System.out.println(sb.toString());
//				str = sb.toString();//the new string
//			}
//		}
		
		
		
		
		
//		public static String[] look_and_say(String seed, int len)
//	    {
//	        String[] seq = new String[len];
//	        seq[0] = seed;
//
//	        for (int i = 1; i < len; i++) {
//	            String val = seq[i-1];
//
//	            StringBuilder nextval = new StringBuilder();
//	            for (int ix = 0; ix < val.length(); ) {
//	                char ch = val.charAt(ix);
//	                int n;
//	                for (n = 1; ++ix < val.length() && val.charAt(ix)==ch; n++)
//	                    ;
//	                nextval.append(n).append(ch);
//	            }
//	            seq[i] = nextval.toString();
//	        }
//
//	        return seq;
//	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/////////////////////////////merge sort
		
//		public static void sortMyArray(int[] a){
//			int length = a.length;
//			int[] temp = new int[length];
////			System.out.println(((1)/2)+"");
//			mergeRecurse(a, temp, 0, a.length-1);	
//		}
//
//		public static void mergeRecurse(int[] arr, int[] temp, int left, int right){
//			
//			
//			if(left < right){
//				
//				int mid = (left+right)/2;
//				mergeRecurse(arr, temp, left, mid);
//				mergeRecurse(arr, temp, mid+1, right);
//				
//				merge(arr, temp, left, mid+1, right); 
//				
//			}
//			return;
//		}
//
//
//
//		public static void merge(int[] arr, int[] temp, int left, int mid, int right){
//			int i = left;
//			int tempLeft = left;
//			int leftEnd = mid-1;
//			int rightEnd = right;
//	
//			while( left <= leftEnd && mid <= rightEnd){
//				if(arr[left] <= arr[mid]){
//					temp[i] = arr[left];
//					left++;
//				}else{
//					temp[i] = arr[mid];
//					mid++;
//				}
//				i++;
////				System.out.println(Arrays.toString(temp));
//			}
//			// {2, 6, 3, 5, 1}
//			
//			while(left <= leftEnd){
//				temp[i] = arr[left];
//				i++;
//				left++;
//			}
//			while(mid <= rightEnd){
//				temp[i] = arr[mid];
//				i++;
//				mid++;
//			}
////			System.out.println("totaltemp: " + Arrays.toString(temp));
////			System.out.println("arraybefore: " + Arrays.toString(arr));
//			for(int j = tempLeft; j <= rightEnd; j++){
//				arr[j] = temp[j];
//			}
////			System.out.println("arrayafter: " + Arrays.toString(arr));
//		}

		
		
		

//		public static void mergeSort(Comparable [ ] a)
//		{
//			Comparable[] tmp = new Comparable[a.length];
//			mergeSort(a, tmp,  0,  a.length - 1);
//		}
//
//
//		private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
//		{
//			if( left < right ) //Do this until left is < right.
//			{
//				int center = (left + right) / 2; 		// find the center point
//				mergeSort(a, tmp, left, center); 		// Merge recursive call on the entire left half
//				mergeSort(a, tmp, center + 1, right); 	// Merge recursive call on the entire right half
//				merge(a, tmp, left, center + 1, right);	// Different method that actually merges current array, with a tmp array, and a left L point, a right R point, and a rightEnd point.
//			}
//		}
//
//		
//		
//
//	    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int mid, int rightEnd )
//	    {
//	        int leftEnd = mid - 1;
//	        int k = left;
//	        int num = rightEnd - left + 1;
//
//	        while(left <= leftEnd && mid <= rightEnd)
//	            if(a[left].compareTo(a[mid]) <= 0)
//	                tmp[k++] = a[left++];
//	            else
//	                tmp[k++] = a[mid++];
//
//	        while(left <= leftEnd)    // Copy rest of first half
//	            tmp[k++] = a[left++];
//
//	        while(mid <= rightEnd)  // Copy rest of right half
//	            tmp[k++] = a[mid++];
//
//	        // Copy tmp back
//	        for(int i = 0; i < num; i++, rightEnd--)
//	            a[rightEnd] = tmp[rightEnd];
//	    }
}