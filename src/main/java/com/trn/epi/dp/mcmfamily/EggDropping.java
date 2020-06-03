package com.trn.epi.dp.mcmfamily;

/**
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 *
 * The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.
 * Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing.
 * We make a few assumptions:
 *
 * …..An egg that survives a fall can be used again.
 * …..A broken egg must be discarded.
 * …..The effect of a fall is the same for all eggs.
 * …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
 * …..If an egg survives a fall then it would survive a shorter fall.
 * …..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
 *
 *
 * If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way.
 * Drop the egg from the first-floor window; if it survives, drop it from the second-floor window.
 * Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available.
 * What is the least number of egg-droppings that is guaranteed to work in all cases?
 * The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that the total number of trials are minimized.
 */
public class EggDropping {

    private int[][] dp;

    /**
     *
     * @param e - number of eggs
     * @param f - number of floors
     * @return
     */
    private int minNumberOfAttempts(int e, int f){

        if(f <= 1){
            return f;
        }

        if(e == 1){
            return f;
        }

        if(dp[e][f] != -1){
            return dp[e][f];
        }

        // a loop to try out every floor with given number of eggs.. i.e. let's try dropping the egg from 1st floor and then analyse all of it's subcases...i.e. dropping then
        // 2nd egg from 2nd floor , if egg breaks, or try 1st egg from 2nd floow...
        // similarly.... let's directly try breaking the 1st egg from 2nd floor...and so on...
        // incrementing k denotes the trial of various cases

        int min = Integer.MAX_VALUE;
        for(int k = 1; k <= f; k++){
            // for every attempt that we do...either egg can break or it may not...thus for the finding the min number in the worst case... we have to choose the max
            // from when egg breaks or when it doesn't break
            int temp = 1 + Math.max(minNumberOfAttempts(e - 1, k - 1) , minNumberOfAttempts(e, f - k));

            min = Math.min(min, temp);
        }

        return dp[e][f] = min;
    }

    public static void main(String[] args) {

        EggDropping eggDropping = new EggDropping();

        int egg = 2;
        int floor = 10;

        eggDropping.dp = new int[egg + 1][floor + 1];

        for(int i = 0; i < eggDropping.dp.length; i++){
            for(int j = 0; j < eggDropping.dp[0].length; j++){
                eggDropping.dp[i][j] = -1;
            }
        }

        int result = eggDropping.minNumberOfAttempts(egg,floor);

        System.out.println("Minimum number of attempts in the worst case : "+result);

    }
}
