package com.trn.sol;

import java.util.HashSet;
import java.util.Set;

public class SimpleFirst {

    //check this https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/discuss/452009/Java-Straightforward-DFS-with-memoization-%2B-BFS
    private static int smallerPath = Integer.MAX_VALUE;

    public static int shortestPath(int[][] grid, int k) {
        helper(grid, k, 0, 0, 0, new HashSet<String>());
        return smallerPath;
    }

    private static void helper(int[][] grid, int k, int stepCount, int locRow, int locCol, Set<String> visited) {

        if (stepCount > smallerPath) {
            return; // we have already found a shorter path than this
        }

        if (locRow < 0 || locCol < 0 || locRow >= grid.length || locCol >= grid[0].length) {
            return; // out of bounds
        }

        if (k <= 0 && grid[locRow][locCol] == 1) { // if we have no elimination power left and we have hit 1 , then return
            return;
        }

        if (locRow == grid.length - 1 && locCol == grid[0].length - 1) {
            smallerPath = Math.min(smallerPath, stepCount);
            return; // reached end of the grid
        }

        int nextK = k;
        if (grid[locRow][locCol] == 1) { // we have some elimination power left and we have hit 1 , then use elimination power
            nextK--;
        }

        String positionString = locRow + "_" + locCol;
        if (visited.contains(positionString)) {
            return; // already visited
        } else {
            visited.add(positionString);
        }

        //System.out.println("Exploring (" + locRow + "," + locCol + ")" + ", k => " + k + " visited => " + visited);

        //try right
        if(locCol + 1 < grid[0].length)
        helper(grid, nextK, stepCount + 1, locRow, locCol + 1, visited);

        //try down
        if(locRow + 1 < grid.length)
        helper(grid, nextK, stepCount + 1, locRow + 1, locCol, visited);

        //try left
        if(locCol + 1 >= 0)
        helper(grid, nextK, stepCount + 1, locRow, locCol - 1, visited);

        //try up
        if(locRow + 1 >= 0)
        helper(grid, nextK, stepCount + 1, locRow - 1, locCol, visited);

        visited.remove(positionString);
        visited.add(0 + "_" + 0);

    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,1,1,0,0,1,1},{0,0,0,1,1,0,0,1,1,0,1,0,0,0,1},{1,1,0,0,0,0,0,1,0,1,0,0,1,0,0},{1,0,1,1,1,1,0,0,1,1,0,1,0,0,1},{1,0,0,0,1,1,0,1,1,0,0,1,1,1,1},{0,0,0,1,1,1,0,1,1,0,0,1,1,1,1},{0,0,0,1,0,1,0,0,0,0,1,1,0,1,1},{1,0,0,1,1,1,1,1,1,0,0,0,1,1,0},{0,0,1,0,0,1,1,1,1,1,0,1,0,0,0},{0,0,0,1,1,0,0,1,1,1,1,1,1,0,0},{0,0,0,0,1,1,1,0,0,1,1,1,0,1,0}};

        int result = shortestPath(grid, 1);
        System.out.println("Hey world! => " + result);
    }
}
