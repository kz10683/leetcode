package solutions;

import util.TreeNode;

public class SymmetricTree
{
    /**
     * 101. Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * <p>
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * <p>
     * But the following [1,2,2,null,3,null,3] is not:
     * <p>
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     */
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        // Essentially same logic as checking if two trees are same, except that for each subtree, we check that left
        // child is equal to right child instead of left child is equal to left, and vice-versa
        return this.isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
        {
            return true;
        }

        // If one is null and the other is not, the tree cannot be mirrored
        if ((p == null && q != null) || (p != null && q == null))
        {
            return false;
        }

        // Recursively check that left child of p is equal to right child of q and vice versa
        return (p.val == q.val) && this.isSymmetricHelper(p.left, q.right) && this.isSymmetricHelper(p.right, q.left);
    }

}
