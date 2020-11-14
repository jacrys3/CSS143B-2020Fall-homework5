package Problem2;

import Problem1.TreeNode;

public class LCA {
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if(root == null){
            return null;
        }if((p == root) || (q == root)){
            return root;
        }
        TreeNode<Integer> left = lowestCommonAncestor(root.left,p,q);
        TreeNode<Integer> right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        //help from geeksforgeeks.com
        TreeNode<Integer> result = ((left == null) ? right : left);
        return result;
    }
}
