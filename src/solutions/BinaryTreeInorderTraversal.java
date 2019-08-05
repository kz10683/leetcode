package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal
{
    /**
     * 94. Given a binary tree, return the inorder traversal of its nodes' values.
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
     * Output: [1,3,2]
     */
    public static List<Integer> inorderTraversal(TreeNode root)
    {
        // Use a stack to keep track of all visited nodes. We begin to adding every single left node in the stack.
        // If we encounter a null left child, then pop a node from the stack, visit the node, and repeat the above
        // process from the right child of the node.
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null)
        {
            if (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }

        return list;
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        recurse(root, list);
        return list;
    }

    public static void recurse(TreeNode root, List<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        recurse(root.left, list);
        list.add(root.val);
        recurse(root.right, list);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(inorderTraversalRecursive(root));
        System.out.println(inorderTraversal(root));
    }
}
