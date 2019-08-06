package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal
{
    /**
     * 102. Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level
     * by level).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * return its level order traversal as:
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null)
        {
            return levelList;
        }

        // For a given node at a given level, attempt to add its child nodes, if any, to a queue
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);

        while (!linkedList.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            // Note that we only check up to the size of the queue at the current level
            int size = linkedList.size();

            for (int i = 0; i < size; i++)
            {
                // Poll the nodes at the current level, add to the current list, and add its child nodes
                TreeNode node = linkedList.poll();
                list.add(node.val);

                if (node.left != null)
                {
                    linkedList.add(node.left);
                }
                if (node.right != null)
                {
                    linkedList.add(node.right);
                }
            }

            levelList.add(list);
        }

        return levelList;
    }
}
