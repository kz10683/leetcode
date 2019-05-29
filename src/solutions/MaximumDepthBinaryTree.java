package solutions;

import util.TreeNode;

public class MaximumDepthBinaryTree
{
    /**
     * 104. Given a binary tree, find its maximum depth.
     * <p>
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf
     * node.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given binary tree [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * return its depth = 3.
     */
    public int maxDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        return 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
    }
}
