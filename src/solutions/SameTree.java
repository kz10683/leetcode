package solutions;

import util.TreeNode;

public class SameTree
{
    /**
     * 100. Given two binary trees, write a function to check if they are the same or not.
     * <p>
     * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
     */
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
        {
            return true;
        }

        // If one is null and the other is not, the tree cannot be the same
        if (p == null || q == null)
        {
            return false;
        }

        return p.val == q.val && this.isSameTree(p.right, q.right) && this.isSameTree(p.left, q.left);
    }
}
