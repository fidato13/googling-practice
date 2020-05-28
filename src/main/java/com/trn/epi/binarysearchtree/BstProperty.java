package com.trn.epi.binarysearchtree;

import com.trn.epi.utils.TreeNode;

/**
 * Write a program that takes as input a binary tree and checks if the tree satisfies the
 * BST property.
 */
public class BstProperty {

    private TreeNode<Integer> createBST() {
        TreeNode<Integer> nodeA = new TreeNode<>(19);
        TreeNode<Integer> nodeB = new TreeNode<>(7);
        TreeNode<Integer> nodeC = new TreeNode<>(3);
        TreeNode<Integer> nodeD = new TreeNode<>(2);
        TreeNode<Integer> nodeE = new TreeNode<>(5);
        TreeNode<Integer> nodeF = new TreeNode<>(11);
        TreeNode<Integer> nodeG = new TreeNode<>(17);
        TreeNode<Integer> nodeH = new TreeNode<>(13);
        TreeNode<Integer> nodeI = new TreeNode<>(43);
        TreeNode<Integer> nodeJ = new TreeNode<>(23);
        TreeNode<Integer> nodeK = new TreeNode<>(37);
        TreeNode<Integer> nodeL = new TreeNode<>(29);
        TreeNode<Integer> nodeM = new TreeNode<>(31);
        TreeNode<Integer> nodeN = new TreeNode<>(41);
        TreeNode<Integer> nodeO = new TreeNode<>(47);
        TreeNode<Integer> nodeP = new TreeNode<>(53);

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

    private boolean bstHelper(TreeNode<Integer> node, Integer lower, Integer upper){
        if(node == null){
            return true;
        }

        if(!(node.val.intValue() >= lower.intValue() && node.val.intValue() <= upper.intValue())){
            return false;
        }

        return bstHelper(node.left, lower, node.val) && bstHelper(node.right, node.val, upper);
    }

    private boolean isBST(TreeNode<Integer> node){
        return bstHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

        BstProperty b1 = new BstProperty();

        TreeNode<Integer> node = b1.createBST();

        boolean result = b1.isBST(node);

        System.out.println("Tree satisfies BST Property : "+ result);

    }
}
