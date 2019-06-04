package solutions;

import util.TreeNode;

public class MinimumDepthBinaryTree
{
    /**
     * 111. Given a binary tree, find its minimum depth.
     * <p>
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf
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
     * return its minimum depth = 2.
     */
    public int minDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        /**
         * Similar to the max depth of binary tree but with two additional cases where either the left or right child
         * node is null.
         *
         * This accounts for cases like the following, where the depth is 2:
         *            1
         *           /
         *          2
         */
        if (root.left == null)
        {
            return 1 + this.minDepth(root.right);
        }

        if (root.right == null)
        {
            return 1 + this.minDepth(root.left);
        }

        return 1 + Math.min(this.minDepth(root.left), this.minDepth(root.right));
    }
}
