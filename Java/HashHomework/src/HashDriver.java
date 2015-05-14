import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class HashDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomAccessFile raf;
		
		try {
			raf = new RandomAccessFile("CAFeatures.txt", "r");
			//record at what offsets each line begins
			long offset = raf.getFilePointer();
			String line = raf.readLine();
			double load = 2.0;
			int tableSize = (int) (97496*load);
			
			//hashcode: Collision amount
			HashMap<Long, Integer> elfHashTable = new HashMap<Long, Integer>();
			//Collision amount: frequency
			HashMap<Integer, Integer> numCollisionsMap = new HashMap<Integer, Integer>();
			
			//Initialize the hashmaps
			for(long j = 0; j < tableSize; j++){
				elfHashTable.put(j, 0);
			}
			for(int i = 0; i < 10000; i++){
				numCollisionsMap.put(i, 0);
			}
			
			
			
			
			int wordAmount = 0;
			while(line != null){
				wordAmount++;
				//run each algorithm on 'line' and store the hash code
				long elfHashCode = Hasher.elfHash(line)%tableSize; //get slot number, or hash code
				int slotNumHits = elfHashTable.get(elfHashCode); //get the # of hits for that slot in the table
				int numCollisions = numCollisionsMap.get(slotNumHits); //get the # of slots that have slotNumHits, hits 
				numCollisionsMap.put(slotNumHits, numCollisions+1); //increment the # of slots that have slotNumHits, hits
				elfHashTable.put(elfHashCode, slotNumHits+1); //increment the # of hits for that slot in the table
				
				
				offset = raf.getFilePointer();
				line = raf.readLine();
			}
			
			HashMap<Long, Integer> slotsWithHitsMap = new HashMap<Long, Integer>();
			for(long i = 0; i < 10000; i++){
				slotsWithHitsMap.put(i, 0);
			}
			for(long i = 0; i < tableSize; i++){
				long slot = elfHashTable.get(i);
				slotsWithHitsMap.put(slot, slotsWithHitsMap.get(slot)+1);
			}
			
			
			double avgSearchAmountTest = 0;
			long worst = 0;
			for(long i = 1; i < 10000; i++){
				if(slotsWithHitsMap.get(i) != 0){
					worst = i;
				}
				int stepAmount = 0;
				for(long j = i; j < 1000; j++){
					stepAmount+= slotsWithHitsMap.get(j);
				}
				avgSearchAmountTest+=stepAmount*i;
			}
			avgSearchAmountTest= avgSearchAmountTest/wordAmount;
			
			
			//calculate worst and average
			double avgSearchAmount = 0;
			int worstSearchAmount = 0;
			for(int i = 1; i < 10000; i++){
				if(numCollisionsMap.get(i) != 0){
					worstSearchAmount = i;
				}
				int stepAmount = 0;
				for(long j = i; j < 1000; j++){
					stepAmount+= slotsWithHitsMap.get(j);
				}
				avgSearchAmount+=stepAmount*i;
			}
			avgSearchAmount= avgSearchAmount/wordAmount;
			
			//calculate % of searches worse than log(tableSize)
			int totalSearches = 0;
			int totalSearchesGood = 0;
			for(int i = 0; i < 10000; i++){
				totalSearches += numCollisionsMap.get(i);
				if(i < Math.log(tableSize)){
					totalSearchesGood+=numCollisionsMap.get(i);
				}
			}
			
			
//			System.out.println(totalSearchesGood);
//			System.out.println(totalSearches);
//			System.out.println(totalSearchesGood/totalSearches);
//			System.out.println(Math.log(tableSize));
			double percentGood = ((double)totalSearchesGood)/((double)totalSearches);
			
			
			System.out.println("new load is: " + load + " test avg: " + avgSearchAmountTest + " with test worst: "+worst+ " " + "the log decimal is "+percentGood);
			
			
			System.out.println("WordData.txt: amount: "+wordAmount);
//			System.out.println("function: elf load: " + load +  " avg: "+avgSearchAmount+ " worst "+worstSearchAmount + "  % < log(N) "+ percentGood);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
