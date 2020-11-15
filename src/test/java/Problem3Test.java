import Problem1.InOrderTraverse;
import Problem1.TreeNode;
import Problem3.InsertInBST;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Problem3Test {
    public static class BSTTestCase<T> {
        final TreeNode<T> tree;
        final int valueToInsert;
        final List<T> expect;

        public BSTTestCase(TreeNode<T> tree, int valueToInsert, List<T> expect) {
            this.tree = tree;
            this.valueToInsert = valueToInsert;
            this.expect = expect;
        }
    }

    @Test
    public void testInsertBST() {
        List<BSTTestCase<Integer>> testCases = getBSTTestCases();

        for (BSTTestCase<Integer> testCase : testCases) {
            InsertInBST.insert(testCase.tree, testCase.valueToInsert);
            List<Integer> actual = inOrderTraverse(testCase.tree);
            assertEquals(testCase.expect, actual);
        }
    }

    @Test
    public void testInOrderTraverse() {
        List<BSTTestCase<Integer>> testCases = getBSTTestCases();

        int[][] tests = {
                {0, 1},
                {1, 1},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3},
                {0, 1, 2},
                {1, 2, 4, 6},
                {2, 3, 4, 6},
                {2, 4, 5, 6},
                {2, 4, 6, 7},
                {3, 4, 5, 6, 9, 10, 13},
                {3, 4, 5, 6, 9, 10, 11, 13},
                {2, 3, 4, 5, 6, 9, 10, 11, 13},
                {2, 3, 4, 5, 6, 9, 10, 11, 13, 15},
                {1, 2},
                {1, 2, 3},
                {1, 2, 3, 4},
                {1, 2, 3, 4, 5}

        };

        int count = 0;
        for (BSTTestCase<Integer> testCase : testCases) {
            InsertInBST.insert(testCase.tree, testCase.valueToInsert);
            List<Integer> actual = inOrderTraverse(testCase.tree);

            assertEquals(tests[count].length, actual.size()); //testing if the lengths of the lists are the same.

            for (int i = 0; i < tests[count].length; i++) {
                // testing each value in the lists to see if they are equal.
                assertEquals(tests[count][i], (int) actual.get(i));
            }
            count++;
        }
    }

    private static List<Integer> inOrderTraverse(TreeNode<Integer> node) {
        List<Integer> result = new ArrayList<>();
        inOrderTraverse(node, result);
        return result;
    }

    private static void inOrderTraverse(TreeNode<Integer> node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left, result);
        result.add(node.val);
        inOrderTraverse(node.right, result);
    }


    private List<BSTTestCase<Integer>> getBSTTestCases() {
        List<BSTTestCase<Integer>> testCases = new ArrayList<>();

        //      1
        //     / \
        //    N   N
        testCases.add(new BSTTestCase<>(new TreeNode<>(1), 0, Arrays.asList(0, 1)));

        //      1
        //     / \
        //    N   N
        testCases.add(new BSTTestCase<>(new TreeNode<>(1), 1, Arrays.asList(1, 1)));

        //      1
        //     / \
        //    N   N
        testCases.add(new BSTTestCase<>(new TreeNode<>(1), 2, Arrays.asList(1, 2)));

        //      2
        //     / \
        //    1   N
        TreeNode<Integer> root = new TreeNode<>(2);
        root.left = new TreeNode<>(1);
        testCases.add(new BSTTestCase<>(root, 3, Arrays.asList(1, 2, 3)));

        //      2
        //     / \
        //    1   N
        root = new TreeNode<>(2);
        root.left = new TreeNode<>(1);
        testCases.add(new BSTTestCase<>(root, 3, Arrays.asList(1, 2, 3)));

        //      2
        //     / \
        //    1   N
        root = new TreeNode<>(2);
        root.left = new TreeNode<>(1);
        testCases.add(new BSTTestCase<>(root, 0, Arrays.asList(0, 1, 2)));

        //      4
        //     / \
        //    2   6
        root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(6);
        testCases.add(new BSTTestCase<>(root, 1, Arrays.asList(1, 2, 4, 6)));

        //      4
        //     / \
        //    2   6
        root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(6);
        testCases.add(new BSTTestCase<>(root, 3, Arrays.asList(2, 3, 4, 6)));

        //      4
        //     / \
        //    2   6
        root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(6);
        testCases.add(new BSTTestCase<>(root, 5, Arrays.asList(2, 4, 5, 6)));

        //      4
        //     / \
        //    2   6
        root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(6);
        testCases.add(new BSTTestCase<>(root, 7, Arrays.asList(2, 4, 6, 7)));

        //      9
        //     / \
        //    5   10
        //   / \   \
        //  3   6   13
        root = new TreeNode<>(9);
        root.left = new TreeNode<>(5);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(6);
        root.right = new TreeNode<>(10);
        root.right.right = new TreeNode<>(13);
        testCases.add(new BSTTestCase<>(root, 4, Arrays.asList(3, 4, 5, 6, 9, 10, 13)));
        testCases.add(new BSTTestCase<>(root, 11, Arrays.asList(3, 4, 5, 6, 9, 10, 11, 13)));
        testCases.add(new BSTTestCase<>(root, 2, Arrays.asList(2, 3, 4, 5, 6, 9, 10, 11, 13)));
        testCases.add(new BSTTestCase<>(root, 15, Arrays.asList(2, 3, 4, 5, 6, 9, 10, 11, 13, 15)));

        //      1
        //     / \
        //    N   N
        // homework
        // what problem can you see for insertInBst from this test case?
        // answer:
        // discuss how you would solve it in a comment below
        // answer:
        root = new TreeNode<>(1);
        testCases.add(new BSTTestCase<>(root, 2, Arrays.asList(1, 2)));
        testCases.add(new BSTTestCase<>(root, 3, Arrays.asList(1, 2, 3)));
        testCases.add(new BSTTestCase<>(root, 4, Arrays.asList(1, 2, 3, 4)));
        testCases.add(new BSTTestCase<>(root, 5, Arrays.asList(1, 2, 3, 4, 5)));

        return testCases;
    }
}