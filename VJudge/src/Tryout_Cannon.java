import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tryout_Cannon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Tryout_Cannon().run();
	}

	public void run() {

		Scanner in = new Scanner(System.in);

		Node initP = new Node(0, in.nextDouble(), in.nextDouble());
		Node finalP = new Node(1, in.nextDouble(), in.nextDouble());
		int n = in.nextInt();
		Node[] nodes = new Node[n + 2];
		nodes[0] = initP;
		nodes[1] = finalP;
		for (int i = 2; i < nodes.length; i++) {
			Node newNode = new Node(i, in.nextDouble(), in.nextDouble());
			nodes[i] = newNode;
		}

		// Add all walking edges
		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes.length; j++) {
				if (i == j) {
					continue;
				}
				double dx = nodes[i].x - nodes[j].x;
				double dy = nodes[i].y - nodes[j].y;
				double cost = Math.sqrt(dx * dx + dy * dy) / 5.0;
				nodes[i].outEdges.add(new Edge(nodes[i], nodes[j], cost));
			}
		}

		// Add all shooting edges
		for (int i = 2; i < nodes.length; i++) {
			for (int j = 0; j < nodes.length; j++) {
				if (i == j) {
					continue;
				}
				double dx = nodes[i].x - nodes[j].x;
				double dy = nodes[i].y - nodes[j].y;
				double fullDist = Math.sqrt(dx * dx + dy * dy);

				double remDist = Math.abs(fullDist - 50);
				double cost = 2 + remDist / 5.0;

				nodes[i].outEdges.add(new Edge(nodes[i], nodes[j], cost));
			}
		}

		//Dijkstra
		boolean[] seen = new boolean[nodes.length];
		PriorityQueue<Entry> PQ = new PriorityQueue<Entry>();
		PQ.add(new Entry(0, initP));

		while (!PQ.isEmpty()) {

			Entry e = PQ.poll();
			Node curr = e.to;
			if (seen[curr.ind]) {
				continue;
			}
			seen[curr.ind] = true;

			if (curr == finalP) {
				System.out.println(e.dist);
				return;
			}

			for (Edge neighEdge : curr.outEdges) {

				if (seen[neighEdge.to.ind]) {
					continue;
				}

				PQ.add(new Entry(e.dist + neighEdge.cost, neighEdge.to));
			}
		}

	}

	public class Entry implements Comparable<Entry> {

		double dist;
		Node to;

		public Entry(double dist, Node to) {
			this.dist = dist;
			this.to = to;
		}

		@Override
		public int compareTo(Entry arg0) {
			return Double.compare(this.dist, arg0.dist);
		}

	}

	public class Node {

		double x, y;
		int ind;
		ArrayList<Edge> outEdges = new ArrayList<Edge>();

		public Node(int ind, double x, double y) {
			this.x = x;
			this.y = y;
			this.ind = ind;
		}

	}

	public class Edge {
		Node from;
		Node to;
		double cost;

		public Edge(Node from, Node to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

	}

}
