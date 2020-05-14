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
		// create an integer array of the lowest vertex that a node can reach
		int[] lowestV = new int[n];
		// construct a graph, make sure to account for the fact that
		// every connection is undirected
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < connections.size(); i++) {
			int toVertex = connections.get(i).get(1);
			int fromVertex = connections.get(i).get(0);
			System.out.println("to Vertex is: " + toVertex +
					", and from vertex is: " + fromVertex);
			graph[toVertex].add(fromVertex);
			graph[fromVertex].add(toVertex);
		}
		for (List<Integer> directions: graph) {
			System.out.println(directions.toString());
		}
		return connections;
	}
}
