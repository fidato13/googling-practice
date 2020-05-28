package com.trn.epi.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class GeneratePermutations {

    private List<List<Integer>> listPermute = new ArrayList<>();

    private void generatePermute(int[] input, int position, HashSet<Integer> chosenNumber, List<Integer> combination){
        if(combination.size() == input.length){
            listPermute.add(new ArrayList<>(combination));
            return;
        }

        //for(int i = position; i < input.length; i++){ // fix one position
            for(int j = 0; j < input.length; j++){ // fix the indexOfNumber
                if(chosenNumber.contains(input[j])){
                    continue;
                }

                combination.add(input[j]);
                chosenNumber.add(input[j]);
                generatePermute(input, position + 1, new HashSet<>(chosenNumber), new ArrayList<>(combination));
                chosenNumber.remove(input[j]);
                combination.remove(combination.size() - 1);
            }
       // }
    }

    public static void main(String[] args) {
        GeneratePermutations g1 = new GeneratePermutations();

        int[] input = new int[]{2,3,5,7};

        g1.generatePermute(input, 0, new HashSet<>(), new ArrayList<>());

        System.out.println("Permutations : "+ g1.listPermute);
    }
}
