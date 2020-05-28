package com.trn.sol;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComputerConnections {

    private static Set<Integer> visited = new HashSet<>();
    private static Map<Integer, Set<Integer>> graph = new HashMap<>();

    public static int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1){
            return -1;
        }

        //buildGraph
        buildGraph(n, connections);

        int connectedComponents = 0;

        // a simple thing could be to find number of connected components and the minimum number would be , that number - 1
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                connectedComponents++;
                dfs(i);
            }
        }

        return connectedComponents - 1;
    }

    private static void buildGraph(int n, int[][] connections){

        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<>());
        }

        for(int[] connection : connections){
            Set<Integer> set0 = graph.get(connection[0]);
            Set<Integer> set1 = graph.get(connection[1]);

            set0.add(connection[1]);
            set1.add(connection[0]);
        }
    }

    private static void dfs(int node){

        if(visited.contains(node)){
            return;
        }

        //afterwards mark the node as visited
        visited.add(node);

        for(Integer neighbour : graph.get(node)){
            //visit all neighbours
            if(!visited.contains(neighbour))
            dfs(neighbour);
        }


    }

    public static void main(String[] args) {
        int result = makeConnected(12, new int[][]{{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}});

        System.out.println("The result => "+ result);
    }
}
