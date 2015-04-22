package main;

import java.util.Stack;

/**
 * Created by uarem on 4/18/2015.
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();

        TreeNode cursor = root;
        while (cursor != null) {
            stack.push(cursor);
            if (cursor.left != null)
                cursor = cursor.left;
            else
                break;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();

        TreeNode cursor = node.right;
        while(cursor != null) {
            stack.push(cursor);
            if (cursor.left != null)
                cursor = cursor.left;
            else
                break;
        }
        return node.val;
    }
}
