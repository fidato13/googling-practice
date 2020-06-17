package com.trn.epi.dp.UnknownFamily;

/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 *
 * We have a sequence of books: the i-th book has thickness books[i][0] and height books[i][1].
 *
 * We want to place these books in order onto bookcase shelves that have total width shelf_width.
 *
 * We choose some of the books to place on this shelf (such that the sum of their thickness is <= shelf_width), then build another level of shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down.  We repeat this process until there are no more books to place.
 *
 * Note again that at each step of the above process, the order of the books we place is the same order as the given sequence of books.  For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
 *
 * Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
 * Output: 6
 * Explanation:
 * The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
 * Notice that book number 2 does not have to be on the first shelf.
 */
public class FillingBookcaseShelves {

    private static int shelf_width_static;

    private static int minHeightShelves(int[][] books, int shelf_width) {
        if(books.length == 0){
            return 0;
        }

        shelf_width_static = shelf_width;

        return helper(books, 0, shelf_width, 0);
        //return minHeight(books, 0, shelf_width, 0, shelf_width);
    }

    public static int minHeight(int[][] books, int cur, int widthLeft, int curHeight, int shelf_width){
        if(cur==books.length){
            return curHeight;
        }

        int current_shelf = Integer.MAX_VALUE;

        int nextShelf =  curHeight+minHeight(books,cur+1,shelf_width-books[cur][0],books[cur][1],shelf_width);
        if(widthLeft>=books[cur][0]){
            current_shelf =  minHeight(books,cur+1,widthLeft-books[cur][0],Math.max(curHeight,books[cur][1]),shelf_width);
        }
        return Math.min(nextShelf, current_shelf);
    }

    private static int helper(int[][] books, int index, int width_remaining, int current_row_max_height){
        if(index == books.length){
            return current_row_max_height;
        }

        int placeOnNextShelf = Integer.MAX_VALUE - 50000;
        int placeOnCurrentShelf = Integer.MAX_VALUE - 50000;

        int next_max_height = Math.max(current_row_max_height, books[index][1]);

        placeOnNextShelf = current_row_max_height + helper(books, index + 1, shelf_width_static - books[index][0], books[index][1]);

        if(width_remaining >= books[index][0]){
            placeOnCurrentShelf = helper(books, index + 1, width_remaining - books[index][0], next_max_height);
        }



        return Math.min(placeOnCurrentShelf,placeOnNextShelf);
        //}
//        else { // it can't fit on the shelf
//            int placeOnNextShelf = books[index][1] + helper(books, index + 1, shelf_width_static - books[index][0], books[index][1]);
//
//            return placeOnNextShelf;
//        }
    }

    public static void main(String[] args) {

//        int[][] books = new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
//        int shelf_width = 4;

        int[][] books = new int[][]{{7,3},{8,7},{2,7},{2,5}};
        int shelf_width = 10;

        int result = minHeightShelves(books, shelf_width);

        System.out.println("The result : "+ result);

    }
}
