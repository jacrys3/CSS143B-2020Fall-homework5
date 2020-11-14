package Problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        // homework
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode<Integer>> tmp = new Stack<>();
        TreeNode<Integer> temp = root;
        while(temp != null && !tmp.isEmpty()) {
            tmp.push(temp);
            temp = temp.left;
            if (temp == null) {
                TreeNode<Integer> pop = tmp.pop();
                result.add(pop.val);
                temp = pop.right;
            }
        }
        return result;  // place holder
    }
}
