package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        // I got help from geeksforgeeks.com

        Queue<TreeNode<Integer>> data = new LinkedList<>();
        // I used a linked list because I don't have to specify a size and it is easier to insert and remove from than
        // an array.

        List<Integer> list = new ArrayList<>();
        data.add(root);
        data.add(null);

        while(data.size() > 0){

            TreeNode<Integer> temp = data.poll();

            if(temp == null){
                result.add(list);
                if(!data.isEmpty()){
                    data.add(null);
                    list = new ArrayList<>();
                }
            } else {
                if (temp.left != null) {
                    data.add(temp.left);
                }
                if (temp.right != null) {
                    data.add(temp.right);
                }
                list.add(temp.val);
            }


        }
        return result;
    }
}
