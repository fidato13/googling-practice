package com.trn.epi.binarytree;

import com.trn.epi.utils.TreeNode;

/**
 * A binary tree is said to be height-balanced if for each node in the tree, the difference
 * in the height of its left and right subtrees is at most one. A perfect binary tree is
 * height-balanced, as is a complete binary tree. A height-balanced binary tree does not
 * have to be perfect or complete—see Figure 10.2 on the facing page for an example.
 * Write a program that takes as input the root of a binary tree and checks whether the
 * tree is height-balanced.
 */
public class HeightBalanced {

    private TreeNode<String> createHeightUnBalancedTree(){
        TreeNode<String> nodeA = new TreeNode<String>("A");
        TreeNode<String> nodeB = new TreeNode<String>("B");
        TreeNode<String> nodeC = new TreeNode<String>("C");
        TreeNode<String> nodeD = new TreeNode<String>("D");
        TreeNode<String> nodeE = new TreeNode<String>("E");
        TreeNode<String> nodeF = new TreeNode<String>("F");
        TreeNode<String> nodeG = new TreeNode<String>("G");
        TreeNode<String> nodeH = new TreeNode<String>("H");
        TreeNode<String> nodeI = new TreeNode<String>("I");
        TreeNode<String> nodeJ = new TreeNode<String>("J");
        TreeNode<String> nodeK = new TreeNode<String>("K");
        TreeNode<String> nodeL = new TreeNode<String>("L");
        TreeNode<String> nodeM = new TreeNode<String>("M");
        TreeNode<String> nodeN = new TreeNode<String>("N");
        TreeNode<String> nodeO = new TreeNode<String>("0");

        //node A
        nodeA.left = nodeB;
        nodeA.right = nodeK;

        //node B
        nodeB.left = nodeC;
        nodeB.right = nodeH;

//        //node K
//        nodeK.left = nodeL;
//        nodeK.right = nodeO;

        //node C
        nodeC.left = nodeD;
        nodeC.right = nodeG;

        //node H
        nodeH.left = nodeI;
        nodeH.right = nodeJ;

//        //node L
//        nodeL.left = nodeM;
//        nodeL.right = nodeN;

        //node D
        nodeD.left = nodeE;
        nodeD.right = nodeF;

        return nodeA;

    }

    private TreeNode<String> createHeightBalancedTree(){
        TreeNode<String> nodeA = new TreeNode<String>("A");
        TreeNode<String> nodeB = new TreeNode<String>("B");
        TreeNode<String> nodeC = new TreeNode<String>("C");
        TreeNode<String> nodeD = new TreeNode<String>("D");
        TreeNode<String> nodeE = new TreeNode<String>("E");
        TreeNode<String> nodeF = new TreeNode<String>("F");
        TreeNode<String> nodeG = new TreeNode<String>("G");
        TreeNode<String> nodeH = new TreeNode<String>("H");
        TreeNode<String> nodeI = new TreeNode<String>("I");
        TreeNode<String> nodeJ = new TreeNode<String>("J");
        TreeNode<String> nodeK = new TreeNode<String>("K");
        TreeNode<String> nodeL = new TreeNode<String>("L");
        TreeNode<String> nodeM = new TreeNode<String>("M");
        TreeNode<String> nodeN = new TreeNode<String>("N");
        TreeNode<String> nodeO = new TreeNode<String>("0");

        //node A
        nodeA.left = nodeB;
        nodeA.right = nodeK;

        //node B
        nodeB.left = nodeC;
        nodeB.right = nodeH;

        //node K
        nodeK.left = nodeL;
        nodeK.right = nodeO;

        //node C
        nodeC.left = nodeD;
        nodeC.right = nodeG;

        //node H
        nodeH.left = nodeI;
        nodeH.right = nodeJ;

        //node L
        nodeL.left = nodeM;
        nodeL.right = nodeN;

        //node D
        nodeD.left = nodeE;
        nodeD.right = nodeF;

        return nodeA;

    }

    private boolean heightBalanced = true;

    private int heightBalancedHelper(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = heightBalancedHelper(node.left);
        int rightHeight = heightBalancedHelper(node.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            heightBalanced = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private boolean isHeightBalanced(TreeNode node){
        heightBalancedHelper(node);
        return heightBalanced;
    }

    public static void main(String[] args) {
        HeightBalanced h1 = new HeightBalanced();

        //TreeNode<String> testNode = h1.createHeightBalancedTree();
        TreeNode<String> testNode = h1.createHeightUnBalancedTree();

        boolean result = h1.isHeightBalanced(testNode);

        System.out.println("Tree is Height Balanced : "+result);
    }
}
