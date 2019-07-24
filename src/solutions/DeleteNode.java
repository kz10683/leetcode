package solutions;

import util.ListNode;

public class DeleteNode
{
    /**
     * 237. Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     * Example 1:
     * <p>
     * Input: head = [4,5,1,9], node = 5
     * Output: [4,1,9]
     * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling
     * your function.
     * <p>
     * Example 2:
     * <p>
     * Input: head = [4,5,1,9], node = 1
     * Output: [4,5,9]
     * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling
     * your function.
     * <p>
     * Note:
     * <p>
     * The linked list will have at least two elements.
     * All of the nodes' values will be unique.
     * The given node will not be the tail and it will always be a valid node of the linked list.
     * Do not return anything from your function.
     */
    public void deleteNode(ListNode node)
    {
        // Normally, you would just have the previous node point to the next node of the current node to delete.
        // We only have access to the node to delete, so just reassign the next node as the current node.
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
