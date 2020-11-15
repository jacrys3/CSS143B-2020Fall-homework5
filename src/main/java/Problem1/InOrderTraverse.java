package Problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode<Integer>> tmp = new Stack<>();
        TreeNode<Integer> temp = root;

        while(temp != null || tmp.size() > 0) {
            while(temp != null){
                tmp.push(temp);
                temp = temp.left;
            }
            temp = tmp.pop();
            result.add(temp.val);
            temp = temp.right;
        }
        return result;
    }
}
