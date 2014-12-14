package Utilities;

//-----------Pair class for comparisons-------------
	public class Pair implements Comparable<Pair> {
	    int x, y;
	    Pair(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	    @Override
	    public int compareTo(Pair o)
	    {
	    	return Integer.compare(this.x, o.x);
	    }
	    @Override
	    public boolean equals(Object o) {
	        Pair p = (Pair)o;
	        return this.x == p.x && this.y == p.y;
	    }
	    @Override
	    public int hashCode() {
	        return x ^ y;
	    }
	}
	// -------------------------------------------------
