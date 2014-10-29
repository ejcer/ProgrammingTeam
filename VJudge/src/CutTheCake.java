import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.*;

/**
 * Is the answer 0 if there are no lines in the cake?
 * Do my test cases do everything?
 * 
 * @author emcenrue
 *
 */
public class Main {

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		
		double r = in.nextDouble();
		double cX = in.nextDouble();
		double cY = in.nextDouble();
		int n = in.nextInt();
		
		while(true){
			if(r == 0 && cX == 0 && cY == 0 && n == 0)
				break;
			P cCenterP = new P(cX, cY);
			Circle circle = new Circle(cCenterP, r);
			ArrayList<Line> lines = new ArrayList<Line>();
			for(int i = 0; i < n; i++){
				double x1 = in.nextDouble();
				double y1 = in.nextDouble();
				double x2 = in.nextDouble();
				double y2 = in.nextDouble();
				P p1 = new P(x1, y1);
				P p2 = new P(x2, y2);
				Line line = new Line(p1, p2);
				if(line.intersectsCircle(circle).length != 0)
					lines.add(line);
			}
			
			int pieces = 1;
			if(lines.size() == 0){
				System.out.println(pieces);
			}else{
				pieces = 2;
				for(int i = 1; i < lines.size(); i++){
					//Point of intersection of this (infinite) line w/ another, null if not // line.  //P intersects(Line l) { 
					//Compute points of intersection of this infinite line with a circle. // line.  //P [] intersectsCircle(Circle c)
					Line curLine = lines.get(i);
					int cntIntersectsInCircle = 0;
					for(int j = 0; j < i; j++){
						if(j != i){
							P intersect = curLine.intersects(lines.get(j));
							
							if(intersect != null){
								if(intersect.dist(cCenterP) < r)
									cntIntersectsInCircle++;
							}
						}
					}
					if(cntIntersectsInCircle == 0){
						pieces++;
//						System.out.println("You should not see this");
					}
					else if(cntIntersectsInCircle > 1){
						pieces+=2;
						cntIntersectsInCircle--;
						pieces+=cntIntersectsInCircle;
//						System.out.println("You should see this only once");
					}else{
						pieces+=2;
//						System.out.println("You should")
					}
				}
				System.out.println(pieces);
			}
			r = in.nextDouble();
			cX = in.nextDouble();
			cY = in.nextDouble();
			n = in.nextInt();
		}

	}
	
	
	static class P {
	    final double x, y;
	    P(double x, double y)    { this.x = x; this.y = y; }
	    P sub(P that)            { return new P(x - that.x, y - that.y); }
	    P add(P that)            { return new P(x + that.x, y + that.y); }
	    double dot(P that)       { return x * that.x + y * that.y; }
	    P mult(double s)         { return new P(x * s, y * s); }
	    // Use hypot() only if intermediate overflow must be avoided
	    double length()          { return sqrt(x*x + y*y); }    
	    double length2()         { return x * x + y * y; }
	    P rightNormal()          { return new P(-y, x); }
	    P leftNormal()           { return new P(y, -x); }
	    P normalize()            { double n = length(); return n > 0 ? new P(x/n, y/n) : origin(); }
	    P scale(double l)        { return normalize().mult(l); }
	    P project(P a)           { return mult(a.dot(this) / length2()); }
	    P reflect(P a)           { return project(a).mult(2.0).sub(a); }
	    // use if sin, cos are known
	    P rotateCCW(double sinT, double cosT) {     
	        return new P(x * cosT - y * sinT, 
	                     x * sinT + y * cosT); }
	    P rotateCW(double sinT, double cosT) { return rotateCCW(-sinT, cosT); }
	    P rotate(double theta)   { return rotateCCW(sin(theta), cos(theta)); }
	    double theta()           { return atan2(y, x); }    // from -pi to +pi
	    double angleTo(P a)      { return acos(this.dot(a) / this.length() / a.length()); }
	    boolean isOrigin()       { return x == 0 && y == 0; }
	    public String toString() { return String.format("(%f,%f)", this.x, this.y); }
	    static P read(Scanner s) { return new P(s.nextDouble(), s.nextDouble()); }
	    static P origin()        { return new P(0, 0); }
	    double det(P that)       { return this.x * that.y - this.y * that.x; }
	    double crossproduct(P that) { return this.det(that); }
	    P half(P q)              { return normalize().add(q.normalize()); }

	    double dist(P to)        { return sub(to).length(); }
	    double signedParallelogramArea(P b, P c) { return (b.sub(this).crossproduct(c.sub(this))); }
	    boolean isCollinearWith(P b, P c) { return abs(signedParallelogramArea(b, c)) < EPS; }
	    // is going from this to b to c a CCW turn? Do not use if points may be collinear
	    boolean isCCW(P b, P c)  { return signedParallelogramArea(b, c) > 0; }
	    double signedTriangleArea(P b, P c) { return signedParallelogramArea(b, c) / 2.0; }

	    /* Sum of signed triangle areas */
	    static double polygonArea(P p[]) {
	        double area = 0.0;
	        for (int i = 0; i < p.length; i++) {
	            area += p[i].det(p[(i+1) % p.length]);
	        }
	        return abs(area/2.0);
	    }

	    /**
	     * Compute x for a * x + b = 0 and ||x|| = C
	     * where 'this' is a.  
	     * Care must be taken to handle the case where
	     * either a.x or a.y is near zero.
	     */
	    P [] solveDotProductConstrainedByNorm(double b, double C) {
	        P a = this;
	        if (a.isOrigin())
	            throw new Error("degenerate case");

	        boolean transpose = abs(a.x) > abs(a.y);
	        a = transpose ? new P(a.y, a.x) : a;

	        Double [] x = solvequadratic(a.length2(), 2.0 * b * a.x, b * b - a.y * a.y * C * C);
	        P [] p = new P[x.length];
	        for (int i = 0; i < x.length; i++) {
	            double x1 = x[i];
	            double x2 = ((-b - a.x * x1) / a.y);
	            p[i] = transpose ? new P(x2, x1) : new P(x1, x2);
	        }
	        return p;
	    }
	}

	/** Solve a * x^2 + b * x + c == 0 */
	static Double [] solvequadratic(double a, double b, double c) {
	    double D = b * b - 4 * a * c;
	    if (D < EPS)
	        return new Double [] { };
	    D = max(D, 0);
	    if (D == 0)
	        return new Double [] { -b / 2.0 / a };
	    double d = sqrt(D);
	    return new Double[] { (-b + d) / 2.0 / a, (-b - d) / 2.0 / a };
	}

	/* The Line/Circle classes provide a number of methods that require dealing
	 * with floating point precision issues.  Adjust EPS to a suitable value,
	 * such as 1e-4, which should work for many problem in which the input
	 * coordinates are in integers.
	 */
	static double EPS = 0.0;

	/* A line denoted by two points p and q.
	 * For internal computations, we use the parametric representation
	 * of the line as p + t d where d = q - p.
	 * For convenience, we compute and store d in the constructor. 
	 * Most methods hide the parametric representation of the
	 * line, but it is exposed via getPointFromParameter and 
	 * intersectionParameters for those problems that need it.
	 *
	 * The line may be interpreted either as a line segment denoted
	 * by the two end points, or as the infinite line determined
	 * by these two points.  Intersection methods are provided
	 * for both cases.
	 */ 
	static class Line {
	    private P p, q, d;
	    Line(P p, P q) { this.p = p; this.q = q; d = q.sub(p); }

	    P getPointFromParameter(double t) { return p.add(d.mult(t)); }

	    // reflect vector across vector (as if line originated at (0, 0))
	    P reflect(P d2) { return d.reflect(d2); }

	    // reflect point across (infinite) line 
	    P reflectPoint(P r) { return reflect(r.sub(p)).add(p); }

	    // project p onto this (infinite) line. Returns point on line
	    P project(P a) { return p.add(d.project(a.sub(p))); }

	    // return distance of point P from this (infinite) line.
	    double distance(P a) { return project(a).dist(a); }

	    @Override
	    public String toString() { return String.format("[%s => %s]", p, q); }

	    /* Point of intersection of this line segment
	     * with another line segment.  Returns only points
	     * that lie inside both line segments, else null.
	     */
	    P intersectsInBounds(Line l) {
	        double [] st = intersectionParameters(l);
	        if (st == null)
	            return null;

	        // check that point of intersection is in direction 'd' 
	        // and within segment bounds
	        double s = st[0];
	        double t = st[1];
	        if (s >= 0 && s <= 1 && 0 <= t && t <= 1)
	            return getPointFromParameter(s);

	        return null;
	    }

	    /* Point of intersection of this (infinite) line 
	     * with other (infinite) line.  Return null if collinear. =======================================NEEDED
	     */
	    P intersects(Line l) {
	        double [] st = intersectionParameters(l);
	        if (st != null)
	            return getPointFromParameter(st[0]);
	        return null;
	    }

	    /* Intersect this line with that line
	     * Solves:  this.p + s * this.d == l.p + t l.d
	     * Return null if lines are collinear
	     * Else returns [s, t].
	     */
	    double [] intersectionParameters(Line l) {
	        P dneg = p.sub(q);
	        double D = l.d.det(dneg);
	        // Use Cramer's rule; see text
	        if (D == 0.0)
	            return null;

	        P rp = p.sub(l.p);
	        return new double[] { l.d.det(rp) / D, rp.det(dneg) / D };
	    }

	    /* Compute points of intersection of this infinite line
	     * with a circle.
	     * Computes projection 'x' of c.c onto line, then computes
	     * x +/- d.scale(h) where h is computed via Pythagoras.
	     * Sorted by decreasing 't'
	     *
	     * May return two points even if line is a tangent. =======================================NEEDED
	     */
	    P [] intersectsCircle(Circle c) {
	        P x = project(c.c);
	        double D = x.dist(c.c);
	        // outside by more than EPS
	        if (D > c.R + EPS) return new P[0];       
	        double h = sqrt(max(0, c.R * c.R - D * D));
	        if (h == 0) return new P[] { x };   // EPS (!?)
	        return new P[] { x.add(d.scale(h)), x.add(d.scale(-h)) };
	    }

	    /* Compute points of intersection of this infinite line
	     * with a circle.
	     *
	     * Solves a + t * b = c + r subject to ||r|| = R
	     * Returns zero, one, or two points on the periphery, 
	     * e.g. c + r[0,1], sorted by decreasing 't'.
	     * Alternative version which requires solving quadratic
	     * equation.
	     *
	     * Careful: set EPS if you need to handle round-off error =======================================NEEDED possibly?
	     * in discriminant.
	     */
	    P [] intersectsCircleAlternative(Circle c) { 
	        P ca = c.c.sub(p);
	        P d = q.sub(p);
	        Double [] t = solvequadratic(d.length2(), -2 * d.dot(ca), ca.length2() - c.R * c.R);
	        P [] r = new P[t.length];
	        for (int i = 0; i < t.length; i++)
	            r[i] = p.add(d.mult(t[i]));
	        return r;
	    }

	    boolean contains(P r) {
	        double t = p.signedParallelogramArea(q, r);
	        if (abs(t) > EPS)   // point not on line
	            return false;
	        return p.dist(r) < p.dist(q) + EPS && r.sub(p).dot(d) > EPS;
	    }
	}

	static class Circle {
	    P c;
	    double R;
	    Circle(P c, double R) { this.c = c; this.R = R; }
	    @Override
	    public String toString() { return String.format("{%s, %.03f}", c, R); }
	    boolean contains(P p) { return R > p.dist(c) + EPS; }
	    /* a line segment is outside a circle if both end points are outside and
	     * if any intersection points are outside the bounds of the line segment. */
	    boolean isOutside(Line l) {
	        if (contains(l.p) || contains(l.q))
	            return false;
	        P [] _is = l.intersectsCircle(this);
	        if (_is.length > 1)
	            for (P is : _is)
	                if (l.contains(is))
	                    return false;
	        return true;
	    }

	    /* Returns the tangent lines that the point p makes with this circle, if any. */
	    Line [] tangentLines(P p)
	    {
	        // Let c +/- r be the tangent points.  Then there's a 'd' such that
	        // p + d - r = c 
	        // Since d r = 0, we multiply by r and get
	        // (p - c) r - ||r|| = 0  subject to ||r|| = R
	        P [] r = p.sub(c).solveDotProductConstrainedByNorm(-R*R, R);
	        Line [] tangents = new Line[r.length];
	        for (int i = 0; i < tangents.length; i++)
	            tangents[i] = new Line(p, c.add(r[i]));
	        return tangents;
	    }
	}
	
	
	
	

	// -----------MyScanner class for faster input----------
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
	// --------------------------------------------------------
}
