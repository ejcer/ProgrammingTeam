import java.io.*;
import java.util.*;

public class F {
	public static TreeSet<Connection> toRemove;

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		for(int t = 1; true; t++)
		{
			int m = scan.nextInt();
			if(m==0)
				break;

			System.out.printf("Case %d: ", t);
			toRemove = new TreeSet<Connection>();

			HashMap<String, Node> idToNode = new HashMap<String, Node>();

			for(int i = 0; i<m; i++)
			{
				String s1 = scan.next();
				String s2 = scan.next();

				Node one;
				Node two;

				if(idToNode.containsKey(s1))
				{
					one = idToNode.get(s1);
				}
				else
				{
					one = new Node(s1);
					idToNode.put(s1, one);
				}

				if(idToNode.containsKey(s2))
				{
					two = idToNode.get(s2);
				}
				else
				{
					two = new Node(s2);
					idToNode.put(s2, two);
				}

				one.children.add(two);
			}

			for(Node p : idToNode.values())
			{
				HashSet<Node> overOne = new HashSet<Node>();
				Queue<Node> q = new ArrayDeque<Node>();
				for(Node c : p.children)
				{
					for(Node c2 : c.children)
					{
						if(!overOne.contains(c2))
						{
							q.add(c2);
							overOne.add(c2);
						}
					}
				}
				
				while(!q.isEmpty())
				{
					Node next = q.poll();
					overOne.add(next);
					for(Node c : next.children)
					{
						if(!overOne.contains(c))
						{
							q.add(c);
							overOne.add(c);
						}
					}
				}
				
				for(Node c : p.children)
				{
					if(overOne.contains(c))
					{
						toRemove.add(new Connection(p.id, c.id));
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(toRemove.size() + " ");		
			for(Connection c : toRemove)
			{
				sb.append(c + " ");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb);
		}
	}

	public static class Node
	{
		public String id;
		public HashSet<Node> children;
		public Node(String i)
		{
			id = i;
			children = new HashSet<Node>();
		}
		
		@Override
		public boolean equals(Object o)
		{
			Node n = (Node)o;
			return this.id.equals(n.id);
		}
		
		@Override
		public int hashCode()
		{
			return id.hashCode();
		}


	}

	public static class Connection implements Comparable<Connection>
	{
		String s1, s2;
		public Connection(String one, String two)
		{
			s1 = one;
			s2 = two;
		}

		public int compareTo(Connection o) {
			if(s1.compareTo(o.s1) != 0)
			{
				return s1.compareTo(o.s1);
			}
			else
				return s2.compareTo(o.s2);
		}
		
		public String toString()
		{
			return s1 + "," + s2;
		}

	}
}
