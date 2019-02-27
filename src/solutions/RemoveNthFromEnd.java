package solutions;

import util.ListNode;

public class RemoveNthFromEnd
{
    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     * <p>
     * Example:
     * <p>
     * Given linked list: 1->2->3->4->5, and n = 2.
     * <p>
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * <p>
     * Note:
     * <p>
     * Given n will always be valid.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode current = head;
        ListNode fast = head;

        // The "fast" node starts n ahead of the head
        for (int i = 0; i < n; i++)
        {
            fast = fast.next;
        }

        // Case when removing head (e.g. 1->2;1, 1;1, 1->2->3;3)
        if (fast == null)
        {
            head = head.next;
            return head;
        }

        // Continue until the "fast" node is the very last node
        while (fast.next != null)
        {
            fast = fast.next;
            current = current.next;
        }

        // At this point, the next node is the node to remove
        current.next = current.next.next;

        return head;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode result = removeNthFromEnd(head, 2);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
