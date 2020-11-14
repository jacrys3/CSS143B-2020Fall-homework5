package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        TreeNode<Integer> temp = root;
        Queue<TreeNode<Integer>> data = new LinkedList<>();
        // I used a linked list because I don't have to specify a size and it is easier to insert and remove from than
        // an array.

        List<Integer> list = new ArrayList<>();

        while(temp != null){
            if(temp.left != null) {
                data.add(temp.left);
            }
            if(temp.right != null) {
                data.add(temp.right);
            }

        }
        return result;
    }
}
