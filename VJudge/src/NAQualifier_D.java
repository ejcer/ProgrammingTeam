import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class NAQualifier_D
{
    static State target;
    static StringBuilder out;

    public static void main(String[] args)
    {
        Scanner in = new Scanner();

        out = new StringBuilder();
        int n = in.nextInt();

        for (int index = 0; index < n; index++)
        {
            char[][] grid = new char[3][3];
            char[][] startGrid = new char[3][3];
            for (int i = 0; i < 3; i++)
            {
                String line = in.readNextLine();
                for (int j = 0; j < 3; j++)
                {
                    grid[i][j] = line.charAt(j);
                    startGrid[i][j] = '.';
                }
            }

            target = new State(grid);
            State start = new State(startGrid);

            solve(start);
        }

        String result = out.toString();
        System.out.println(result.substring(0, result.length() - 1));
    }


    // bfs
    public static void solve(State start)
    {
        Set<State> visited = new HashSet<State>();
        Map<State, Integer> dist = new HashMap<State, Integer>();
        Deque<State> bfs = new ArrayDeque<State>();

        bfs.offer(start);
        dist.put(start, 0);

        int min = Integer.MAX_VALUE;

        while (bfs.size() > 0)
        {
            State s = bfs.poll();
            int n = dist.get(s);
            visited.add(s);

            if (s.isfinal())
            {
                if (n < min) // tracks shortest path
                {
                    min = n;
                }
                break;
            }

            for (State succ : s.successors())
            {
                if (visited.contains(succ))
                    continue;

                if (!dist.containsKey(succ))
                {
                    dist.put(succ, n + 1);
                    bfs.offer(succ);
                }
            }
        }

        out.append(min);
        out.append("\n");
    }


    public static class State
        implements Comparable<State>
    {
        char[][] grid;


        public State(char[][] inGrid)
        {
            grid = new char[3][3];

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    grid[i][j] = inGrid[i][j];
                }
            }
        }


        // successors are all adjacent possible moves
        // so in the cube, its going up or down a level, left right up and down
        // in the current level
        public List<State> successors()
        {
            List<State> list = new ArrayList<State>();

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    State temp = new State(grid);
                    temp.flip(i, j);
                    list.add(temp);
                }
            }

            return list;
        }


        public void flip(int x, int y)
        {
            if (x > 0)
            {
                grid[x - 1][y] = opposite(grid[x - 1][y]);
            }
            if (y > 0)
            {
                grid[x][y - 1] = opposite(grid[x][y - 1]);
            }
            if (x < 2)
            {
                grid[x + 1][y] = opposite(grid[x + 1][y]);
            }
            if (y < 2)
            {
                grid[x][y + 1] = opposite(grid[x][y + 1]);
            }

            grid[x][y] = opposite(grid[x][y]);
        }


        public char opposite(char curr)
        {
            if (curr == '*')
            {
                return '.';
            }

            return '*';
        }


        // is the final state when it reaches E
        public boolean isfinal()
        {
            for (int i = 0; i < 3; i++)
            {
                if (!Arrays.equals(grid[i], target.getGrid()[i]))
                {
                    return false;
                }
            }
            return true;
        }


        public char[][] getGrid()
        {
            return grid;
        }


        @Override
        public boolean equals(Object o)
        {
            State other = (State)o;

            for (int i = 0; i < 3; i++)
            {
                if (!Arrays.equals(grid[i], other.getGrid()[i]))
                {
                    return false;
                }
            }

            return true;
        }


        @Override
        public int compareTo(State other)
        {
            return Integer.compare(0, 0);
        }


        // guaranteed a unique hash code for each state
        // b/c max of 30 for each l, x, and y
        @Override
        public int hashCode()
        {
            int count = 0;
            int mult = 1;

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    count += mult * hash(grid[i][j]);
                    mult *= 2;
                }
            }

            return count;
        }


        public int hash(char c)
        {
            if (c == '*')
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
    }


    // -----------Pair class for comparisons--------------
    public static class Pair
        implements Comparable<Pair>
    {
        int x, y;


        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Pair o)
        {
            return Integer.compare(this.x, o.x);
        }


        @Override
        public int hashCode()
        {
            return x ^ y;
        }


        @Override
        public boolean equals(Object o)
        {
            Pair p = (Pair)o;
            return p.x == x && p.y == y;
        }
    }


    // -----------Scanner class for faster input----------
    /*
     * Provides similar API as java.util.Scanner but does not use regular
     * expression engine.
     */
    public static class Scanner
    {
        BufferedReader  br;
        StringTokenizer st;


        public Scanner(Reader in)
        {
            br = new BufferedReader(in);
        }


        public Scanner()
        {
            this(new InputStreamReader(System.in));
        }


        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }


        int nextInt()
        {
            return Integer.parseInt(next());
        }


        long nextLong()
        {
            return Long.parseLong(next());
        }


        double nextDouble()
        {
            return Double.parseDouble(next());
        }


        // Slightly different from java.util.Scanner.nextLine(),
        // which returns any remaining characters in current line,
        // if any.
        String readNextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    // --------------------------------------------------------
}
