package Problem3;

import Problem1.TreeNode;

public class InsertInBST {
    public static void insert(TreeNode<Integer> root, int valToInsert){
        insertHelper(root,valToInsert);
    }
    private static TreeNode<Integer> insertHelper(TreeNode<Integer> root, int valToInsert){
        if(root == null){
            root = new TreeNode<>(valToInsert);
            return root;
        }

        if(valToInsert < root.val){
            root.left = insertHelper(root.left, valToInsert);
        } else if(valToInsert >= root.val){
            root.right = insertHelper(root.right, valToInsert);
        }

        return root;
    }
}
