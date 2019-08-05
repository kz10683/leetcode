package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal
{
    /**
     * 144. Given a binary tree, return the preorder traversal of its nodes' values.
     * <p>
     * Example:
     * <p>
     * Input: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * Output: [1,2,3]
     */
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if (root == null)
        {
            return list;
        }

        // Use a stack to keep track of nodes that need to be visited. For each node in the stack, we immediately pop
        // and record the value, and then attempt to add its right child and then left child, in that order.
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null)
            {
                stack.push(node.right);
            }
            if (node.left != null)
            {
                stack.push(node.left);
            }
        }

        return list;
    }
}
