/* Hassan/Andriy/Nathan problem E at 4:14  (254) */
import java.io.*;
import java.util.*;

public class LetterCubes {
   public static HashMap<Character, Integer> cube;
   public static HashMap<Character, ArrayList<Character>> conflicts;
   public static ArrayList<Character> chars;

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      while (true) {
      
         int N = scan.nextInt();
         if (N == 0)
            break;
         
         char floating = scan.next().charAt(0);
         
         ArrayList<String> words = new ArrayList<String>();
         
         // This HashMap maps a character to the cube on which it is, so C: 1 means the letter C is on cube 1
         cube = new HashMap<Character, Integer>();
         
         // This HashMap maps a character to a list of characters which it could not be on the same cube with. 
         // EX. If the word CALM was given, then C can't be on the same cube as A, L and M
         conflicts = new HashMap<Character, ArrayList<Character>>();
         
         // This block just populates the conflicts and cube HashMaps
         for (int i = 0; i < N; i++) {
            String w = scan.next();
            words.add(w);
            // Loop over each letter in w
            for (int j = 0; j < w.length(); j++) {
               char c = w.charAt(j);
               
               // Initialize the map with a 0, as we don't know which cube to put it on
               cube.put(c, 0);
               
               // If we haven't encountered this character before, we need to create a new list of conflicts
               if(!conflicts.containsKey(c))
                  conflicts.put(c, new ArrayList<Character>());
                  
               // Loop over the rest of the characters in the word and add them to the conflict list
               for (int k = 0; k < w.length(); k++) {
                  if (k != j) {
                     conflicts.get(c).add(w.charAt(k));
                  }
               }
            }
         }
         // Get the number of cubes (the length of any word)
         int K = words.get(0).length();
         
         // The list of all the charcters, we get this by finding the key set of the cube mapping
         chars = new ArrayList<Character>(cube.keySet());
         Collections.sort(chars);
         
         // Launch the back tracking
         backTrack(K, 0, new int[5]);
      
         // Now that we have all the letters and which cube they belong to we just have to make the groups
         ArrayList<ArrayList<Character>> groups = new ArrayList<ArrayList<Character>>();
         for (int i = 0; i < K; i++) {
            groups.add(new ArrayList<Character>());
         }
      
         for (char c : chars) {
            groups.get(cube.get(c) - 1).add(c);
         }
         
         // Make the strings representing the groups
         ArrayList<String> cubeString = new ArrayList<String>();
         for (int i = 0; i < K; i++) {
            // If one of the groups doesn't have 6 letters then the floating character from the input in needed
            if(groups.get(i).size() != 6)
            {
               groups.get(i).add(floating);
               Collections.sort(groups.get(i));
            }
         
            // Make a string for the letters
            StringBuilder sb = new StringBuilder();
            for (char o : groups.get(i)) {
               sb.append(o);
            }
            cubeString.add(sb.toString());
         }
         // Sort them as the problem states
         Collections.sort(cubeString);
         
         // Output
         for (int i = 0; i < cubeString.size() - 1; i++) {
            System.out.print(cubeString.get(i) + " ");
         }
         System.out.println(cubeString.get(cubeString.size() - 1));
      }
   }

   // K is the number of cubes that each letter could map to
   // ind is the character we are currently trying to map
   // int[] found is an array that counts the number of letters already mapped to a cube (to make sure we don't go over 6)
   public static boolean backTrack(int K, int ind, int[] found) {
      // Base case, if ind is equal to the number of characters then we found a mapping for everything
      if (ind == chars.size()) {
         return true;
      }
      
      // Get the current character
      char c = chars.get(ind);
      
      // Loop through the possible cube assignments
      for (int i = 1; i <= K; i++) {
         // If this cube already has 6 elements we can't place it here
         if (found[i] == 6)
            continue;
      	
         // A flag to check if there is no conflicts
         boolean flag = true;
         // Loop through all the characters that the current one can't be on the same cube as, and make sure none of them are on cube i
         // if they are set the flag to false
         for (Character o : conflicts.get(c)) {
            if (cube.get(o) == i) {
               flag = false;
               break;
            }
         }
         
         // If the flag is false this cube assignment doesn't work and we need to try the next one
         if (flag == false)
            continue;
      	
         // Otherwise it is possible that this assignment works
         
         // Map the letter to the cube and add one to the number of letters on the cube
         cube.put(c, i);
         found[i]++;
         
         // call the recursive call with the next index, if it returns true then we are done and we return true as well
         if (backTrack(K, ind + 1, found)) {
            return true;
         }
         
         // We get here if the recursive call didn't return true, so now we clear this option and move on
         cube.put(c, 0);
         found[i]--;
      }
      
      // If we tried all the options and none worked then we return false to signify that there is an incorrect assignment higher up
      return false;
   }

}