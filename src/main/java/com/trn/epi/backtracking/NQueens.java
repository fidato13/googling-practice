package com.trn.epi.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * A nonattacking placement of queens is one in which no two queens are in the same
 * row, column, or diagonal. See Figure 16.3 for an example.
 * (a) Solution 1. (b) Solution 2.
 * Figure 16.3: The only two ways in which four queens can be placed on a 4 x 4 chessboard.
 * Write a program which returns all distinct nonattacking placements of n queens on
 * an nxn chessboard, where n is an input to the program.
 */
public class NQueens {

    private List<int[][]> listOfValidPlacements = new ArrayList<>();

    private void placeNQueens(int[][] grid, int row){
        if(row >= grid.length){
            copyGridConf(grid);
            return;
        }

        for(int j = 0; j < grid[0].length; j++){
            grid[row][j] = 1;

            if(isValidPlacement(grid,row, j)){
                placeNQueens(grid, row + 1);
            }

            grid[row][j] = 0;
        }

    }

    private boolean isValidPlacement(int[][] grid, int row, int col){
        int rowSum = 0;
        int colSum = 0;
        int diaSum = 0;

        //check row
        for(int j = 0; j < grid[0].length; j++){
            if(grid[row][j] == 1){
                rowSum++;
            }
        }

        if(rowSum != 1){
            return false;
        }

        //check col
        for(int i = 0; i < grid.length; i++){
            if(grid[i][col] == 1){
                colSum++;
            }
        }

        if(colSum != 1){
            return false;
        }

        //check diagonal
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(Math.abs(row - i) == Math.abs(col - j) && grid[i][j] == 1){
                    //it is a diagonal
                    diaSum++;
                }
            }
        }

        if(diaSum != 1){
            return false;
        }

        return true;
    }

    private void copyGridConf(int[][] grid){
        int[][] newGrid = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                newGrid[i][j] = grid[i][j];
            }
        }

        listOfValidPlacements.add(newGrid);
    }

    public static void main(String[] args) {

        NQueens n1 = new NQueens();

        int[][] grid = new int[8][8];

        n1.placeNQueens(grid, 0);

        System.out.println("valid placements : "+n1.listOfValidPlacements);
    }
}
