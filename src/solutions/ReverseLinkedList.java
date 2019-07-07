package solutions;

import util.ListNode;

public class ReverseLinkedList
{
    /**
     * 206. Reverse a singly linked list.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * <p>
     * Follow up:
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     */
    public ListNode reverseList(ListNode head)
    {
        // Use two nodes to track the previous and current position, and reverse the links as we traverse
        // till the end of the list.
        ListNode prev = null;
        ListNode current = head;

        while (current != null)
        {
            ListNode next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        // At the end, current is null, so the prev is actually the new head.
        return prev;
    }
}
