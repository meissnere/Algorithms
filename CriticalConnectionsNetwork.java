package techQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsNetwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> connections = new ArrayList<List<Integer>>();
		List<Integer> first = new ArrayList<Integer>();
		
		first.add(0);
		first.add(1);
		
		List<Integer> second = new ArrayList<Integer>();
		second.add(1);
		second.add(2);
		
		List<Integer> third = new ArrayList<Integer>();
		third.add(2);
		third.add(0);
		
		List<Integer> fourth = new ArrayList<Integer>();
		fourth.add(1);
		fourth.add(3);

		connections.add(0, first);
		connections.add(1, second);
		connections.add(2, third);
		connections.add(3, fourth);
		
		List<List<Integer>> output = criticalConnections(4, connections);
		
		for (int i = 0; i < output.size(); i++) {
			List<Integer> connect = output.get(i);
			for (int j = 0; j < connect.size(); j++) {
				System.out.println(i + " connection has index: " + j + ", connection is: " + connect.get(j));
			}
		}
	}
	
	public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		// start with initializing two integer arrays with length n
		// disc will record the time when a vertex u was discovered
		// low will record the lowest vertex a vertex u can reach
		int[] disc = new int[n], low = new int[n];
		// use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
		List<Integer>[] graph = new ArrayList[n];
		List<List<Integer>> res = new ArrayList<>();
		Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
		System.out.println(Arrays.toString(disc));
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		// build graph
		for (int i = 0; i < connections.size(); i++) {
			int from = connections.get(i).get(0), to = connections.get(i).get(1);
			System.out.println("from is: " + from + ", to is: " + to);
			graph[from].add(to);
			graph[to].add(from);
			System.out.println(graph[from].toString());
			System.out.println(graph[to].toString());
		}

		for (int i = 0; i < n; i++) {
			if (disc[i] == -1) {
				dfs(i, low, disc, graph, res, i);
			}
		}
		return res;
	}

	static int time = 0; // time when discover each vertex

	private static void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
		disc[u] = low[u] = ++time; // discover u
		for (int j = 0; j < graph[u].size(); j++) {
			int v = graph[u].get(j);
			if (v == pre) {
				continue; // if parent vertex, ignore
			}
			if (disc[v] == -1) { // if not discovered
				dfs(v, low, disc, graph, res, u);
				low[u] = Math.min(low[u], low[v]);
				if (low[v] > disc[u]) {
					// u - v is critical, there is no path for v to reach back to u or previous vertices of u
					res.add(Arrays.asList(u, v));
				}
			} else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}

}
