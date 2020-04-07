package techquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlowerPlanting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 3;
		int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
//		int[][] paths = {{1,2},{3,4}};

		
		int[] ans = gardenNoAdj(N, paths);
		System.out.println(ans);
	}
	
	public static int[] gardenNoAdj(int N, int[][] paths) {
		//Create a graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //... via adjacency list
        for (int i = 0; i < paths.length; i++) graph.put(i, new HashSet<>());
        //Add the edges
        
        System.out.println("key: " + graph.keySet() + ", value: " + graph.entrySet());
        System.out.println("rows: " + paths.length + ", columns: " + paths[0].length);
        for (int[] path : paths){
        	System.out.println("NEW LOOP: " + path[0] + " " + path[1]);
            int x = path[0] - 1; //Due to 1-based indexing 
            int y = path[1] - 1; //Due to 1-based indexing
            System.out.println("x: " + x + ", y: " + y);
            //Undirected edge
            System.out.println("GRAPH x: " + graph.get(x) + ", y: " + graph.get(y));
            graph.get(x).add(y);
            graph.get(y).add(x);
            System.out.println("key: " + graph.keySet() + ", value: " + graph.entrySet());
        }
        //Here is our solution vector where res[i] represents color of garden i+1
        int[] res = new int[N];
        
        //Now run graph painting algorithm
        
        //For each garden
        for (int i = 0; i < N; i++){
            int[] colors = new int[5]; //Use 5 instead of 4 so we can easily use 1-based indexing of the garden colors
            for (int nei : graph.get(i)){
                colors[res[nei]] = 1; //Mark the color as used if neighbor has used it before.
            }
            //Now just use a color that has not been used yet
            for (int c = 4; c >= 1; c--){
                if (colors[c] != 1) //colors[c] == 0 => the color has not been used yet,
                    res[i] = c; //so let's use that one
            }
        }
        
        return res;
	}

}
