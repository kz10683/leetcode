package solutions;

import util.TreeNode;

public class SortedArrayToBST
{
    /**
     * 108. Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     * <p>
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
     * subtrees of every node never differ by more than 1.
     * <p>
     * Example:
     * <p>
     * Given the sorted array: [-10,-3,0,5,9],
     * <p>
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     */
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return null;
        }

        return this.recurse(nums, 0, nums.length - 1);
    }

    /**
     * The value in the middle of the sorted array will be the root node value. The root node's left child value will
     * be in the middle of the first half of the array (from 0 up to mid - 1) and the root node's right child value will
     * be in the middle of the last half of the array (from mid + 1 to end). Based on these conditions, we can then
     * recursively set each node's left and right child nodes until the start index exceeds the end index.
     */
    public TreeNode recurse(int[] nums, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = this.recurse(nums, start, mid - 1);
        node.right = this.recurse(nums, mid + 1, end);

        return node;
    }

}
