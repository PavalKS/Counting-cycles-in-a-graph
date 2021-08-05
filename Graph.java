import java.util.*;
class Graph
{
	static final int N = 100000;
	@SuppressWarnings("unchecked")
	static Vector<Integer>[] graph = new Vector[N];
	@SuppressWarnings("unchecked")
	static Vector<Integer>[] cycles = new Vector[N];
	static int cyclenumber;
	
	static void dfs_cycle(int u, int p, int[] color,int[] mark, int[] par)
	{
		if (color[u] == 2)
		{
			return;
		}
        if (color[u] == 1)
        {
			cyclenumber++;
			int cur = p;
			mark[cur] = cyclenumber;
			while (cur != u)
			{
				cur = par[cur];
				mark[cur] = cyclenumber;
			}
			return;
		}
		par[u] = p;
		color[u] = 1;
		for (int v : graph[u])
		{
			if (v == par[u])
			{
				continue;
			}
			dfs_cycle(v, u, color, mark, par);
		}
		color[u] = 2;
	}
	
	static void addEdge(int u, int v)
	{
		graph[u].add(v);
		graph[v].add(u);
	}

	public static void main(String[] args)
	{

		for (int i = 0; i < N; i++)
		{
			graph[i] = new Vector<>();
			cycles[i] = new Vector<>();
		}

		addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3,4);
        addEdge(4,1);
        addEdge(5,2);
        addEdge(3,5);

		int[] color = new int[N];
		int[] par = new int[N];
		int[] mark = new int[N];

		cyclenumber = 0;

		dfs_cycle(1, 0, color, mark, par);

		if(cyclenumber>0)
		{
			System.out.println("CYCLE DETECTED!");
			System.out.println("Number of cycles: "+cyclenumber);
		}
		else
		{
			System.out.println("CYCLE NOT DETECTED");
		}
	}
}
