package com.trn.epi.binarytree;

import com.trn.epi.utils.TreeNode;

/**
 * A binary tree is symmetric if you can draw a vertical line through the root and then
 * the left subtree is the mirror image of the right subtree. The concept of a symmetric
 * binary tree is illustrated in Figure 10.3 on the facing page.
 * Write a program that checks whether a binary tree is symmetric.
 */
public class Symmetric {


    private TreeNode<String> createSymmetricTree(){
        TreeNode<String> nodeA = new TreeNode<String>("314");
        TreeNode<String> nodeB = new TreeNode<String>("6");
        TreeNode<String> nodeC = new TreeNode<String>("2");
        TreeNode<String> nodeD = new TreeNode<String>("3");
        TreeNode<String> nodeE = new TreeNode<String>("6");
        TreeNode<String> nodeF = new TreeNode<String>("2");
        TreeNode<String> nodeG = new TreeNode<String>("3");

        //node A
        nodeA.left = nodeB;
        nodeA.right = nodeE;

        //node B
        nodeB.right = nodeC;

        //node C
        nodeC.right = nodeD;

        //node E
        nodeE.left = nodeF;

        //node F
        nodeF.left = nodeG;

        return nodeA;

    }

    private TreeNode<String> createASymmetricTree(){
        TreeNode<String> nodeA = new TreeNode<String>("314");
        TreeNode<String> nodeB = new TreeNode<String>("6");
        TreeNode<String> nodeC = new TreeNode<String>("561");
        TreeNode<String> nodeD = new TreeNode<String>("3");
        TreeNode<String> nodeE = new TreeNode<String>("6");
        TreeNode<String> nodeF = new TreeNode<String>("2");
        TreeNode<String> nodeG = new TreeNode<String>("1");

        //node A
        nodeA.left = nodeB;
        nodeA.right = nodeE;

        //node B
        nodeB.right = nodeC;

        //node C
        nodeC.right = nodeD;

        //node E
        nodeE.left = nodeF;

        //node F
        nodeF.left = nodeG;

        return nodeA;

    }

    private boolean symmetricHelper(TreeNode<String> node1, TreeNode<String> node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null){
            return false;
        }

        if(node2 == null){
            return false;
        }


        if(!node1.val.equalsIgnoreCase(node2.val)){
            return false;
        }

        return symmetricHelper(node1.left, node2.right) && symmetricHelper(node1.right, node2.left);
    }

    private boolean isSymmetricTree(TreeNode<String> node){
        if(node == null){
            return true;
        }

        return symmetricHelper(node.left, node.right);
    }

    public static void main(String[] args) {
        Symmetric s1 = new Symmetric();

        //TreeNode node = s1.createSymmetricTree();
        TreeNode node = s1.createASymmetricTree();

        boolean result = s1.isSymmetricTree(node);

        System.out.println("Tree is Symmetric : "+result);
    }
}
