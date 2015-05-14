import java.lang.Math;

public class Hasher {

   public static int elfHash(String toHash) {

      int hashValue = 0;
      for (int Pos = 0; Pos < toHash.length(); Pos++) { // use all elements

         hashValue = (hashValue << 4) + toHash.charAt(Pos);  // shift/mix

         long hiBits = hashValue & 0xF0000000;  // get high nybble
 
         if (hiBits != 0) {
            hashValue ^= hiBits >> 56; // xor high nybble with second nybble
         }

         hashValue &= ~hiBits;         // clear high nybble
      }

      return ( hashValue & 0x7FFFFFFF );
   }
   
   public static long sumAndShiftHash(String toHash) {

      long hashValue = 0;
      for (int Pos = 0; Pos < toHash.length(); Pos++) {
         hashValue = (hashValue << 4) + toHash.charAt(Pos);
      }
      return Math.abs(hashValue);
   }

   public static long DEKHash(String str)
   {
      long hash = str.length();

      for(int i = 0; i < str.length(); i++)
      {
         hash = ((hash << 5) ^ (hash >> 27)) ^ str.charAt(i);
      }

      return Math.abs(hash);
   }
   /* End Of DEK Hash Function */

   public static long FNVHash(String str)
   {
      long fnv_prime = 0x811C9DC5;
      long hash = 0;

      for(int i = 0; i < str.length(); i++)
      {
      hash *= fnv_prime;
      hash ^= str.charAt(i);
      }

      return Math.abs(hash);
   }
   /* End Of FNV Hash Function */
};