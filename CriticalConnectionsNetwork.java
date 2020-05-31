package techQuestions;

/*
Purpose: There are n servers numbered from 0 to n-1 connected
by undirected server-to-server connections forming a network,
where connections[i] = [a, b] represents a connection between
servers a and b. Any server can reach any other server directly
or indirectly through the network.

A critical connection is a connection that, if removed, will
make some server unable to reach some other server.

Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.

Return all critical connections in the network in any order.
Author: Erich Meissner
Date: 5/12/20
Time: 2:04 AM
 */

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

		System.out.println(output.toString());
	}
	
	public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		// construct a graph, make sure to account for the fact that
		// every connection is undirected
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < connections.size(); i++) {
			int toVertex = connections.get(i).get(1);
			int fromVertex = connections.get(i).get(0);
//			System.out.println("to Vertex is: " + toVertex +
//					", and from vertex is: " + fromVertex);
			graph[toVertex].add(fromVertex);
			graph[fromVertex].add(toVertex);
		}
		int timer = 0;
		int[] timestampAtNode = new int[n];
		boolean[] visited = new boolean[n];
		List<List<Integer>> criticalConnections = new ArrayList<List<Integer>>();
		dfsTarjan(graph, -1, 0, visited, timer, timestampAtNode, criticalConnections);
		return criticalConnections;
	}

	public static void dfsTarjan(List<Integer>[] graph, int parent, int node, boolean[] visited,
								 int timer, int[] timestampAtNode, List<List<Integer>> criticals) {
		// this node has now been visited:
		visited[node] = true;
		timer++;
		timestampAtNode[node] = timer;
		int currentTime = timestampAtNode[node];

		// entire a loop that will look at each node's neighbors
		for (int neighbor: graph[node]) {
			// if the neighbor is in fact this current node's parent, continue
			if (neighbor == parent) {
				continue;
			}
			// if the neighbor hasn't been visited, we do not know the timestamp!
			// dfs recurse to visit that neighbor
			if (!visited[neighbor]) {
				dfsTarjan(graph, node, neighbor, visited, currentTime, timestampAtNode, criticals);
			}
			timestampAtNode[node] = Math.min(timestampAtNode[node], timestampAtNode[neighbor]);
			if (currentTime < timestampAtNode[neighbor]) {
				criticals.add(Arrays.asList(node, neighbor));
			}
		}
		System.out.println("when time is: " + currentTime + ", the timestamp array is: " + Arrays.toString(timestampAtNode));
	}
}
