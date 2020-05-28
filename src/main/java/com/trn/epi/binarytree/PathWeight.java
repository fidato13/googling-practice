package com.trn.epi.binarytree;

import com.trn.epi.utils.TreeNode;

/**
 * You are given a binary tree where each node is labeled with an integer. The path
 * weight of a node in such a tree is the sum of the integers on the unique path from the
 * root to that node. For the example shown in Figure 10.1 on Page 150, the path weight
 * of E is 591.
 * Write a program which takes as input an integer and a binary tree with integer node
 * weights, and checks if there exists a leaf whose path weight equals the given integer.
 */
public class PathWeight {

    private TreeNode createWeightedTree(){
        TreeNode<Integer> nodeA = new TreeNode<>(314);
        TreeNode<Integer> nodeB = new TreeNode<>(6);
        TreeNode<Integer> nodeC = new TreeNode<>(271);
        TreeNode<Integer> nodeD = new TreeNode<>(28);
        TreeNode<Integer> nodeE = new TreeNode<>(0);
        TreeNode<Integer> nodeF = new TreeNode<>(561);
        TreeNode<Integer> nodeG = new TreeNode<>(3);
        TreeNode<Integer> nodeH = new TreeNode<>(17);
        TreeNode<Integer> nodeI = new TreeNode<>(6);
        TreeNode<Integer> nodeJ = new TreeNode<>(2);
        TreeNode<Integer> nodeK = new TreeNode<>(1);
        TreeNode<Integer> nodeL = new TreeNode<>(401);
        TreeNode<Integer> nodeM = new TreeNode<>(641);
        TreeNode<Integer> nodeN = new TreeNode<>(257);
        TreeNode<Integer> nodeO = new TreeNode<>(271);
        TreeNode<Integer> nodeP = new TreeNode<>(28);

        //node A
        nodeA.left = nodeB;
        nodeA.right = nodeI;

        //node B
        nodeB.left = nodeC;
        nodeB.right = nodeF;

        //node I
        nodeI.left = nodeJ;
        nodeI.right = nodeO;

        //node C
        nodeC.left = nodeD;
        nodeC.right = nodeE;

        //node F
        nodeF.right = nodeG;

        //node J
        nodeJ.right = nodeK;

        //node O
        nodeO.right = nodeP;

        //node G
        nodeG.left = nodeH;

        //node K
        nodeK.left = nodeL;
        nodeK.right = nodeN;

        //node L
        nodeL.right = nodeM;

        return nodeA;

    }

    private boolean present = false;

    private boolean isPresent(TreeNode<Integer> node, Integer sum){

        if(present){
            return true;
        }

        if(node == null || sum < 0){
            return false;
        }

        if(sum.intValue() == node.val.intValue()){
            present = true;
            return true;
        }

        return isPresent(node.left, sum - node.val) || isPresent(node.right, sum - node.val);
    }

    public static void main(String[] args) {
        PathWeight p1 = new PathWeight();

        TreeNode node = p1.createWeightedTree();

        boolean result = p1.isPresent(node, 900);

        System.out.println("Path Sum is Present : "+ p1.present);
    }
}
