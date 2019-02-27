package solutions;

import util.ListNode;

public class RemoveDuplicatesSortedList
{
    /**
     * Given a sorted linked list, delete all duplicates such that each element
     * appear only once.
     * <p>
     * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
     */
    public static ListNode deleteDuplicates(ListNode head)
    {
        ListNode current = head;
        while (current != null && current.next != null)
        {
            // Since the values are sorted, simply check the next node value at each
            // iteration. If the values are equal, set current node to point to the next
            // next node and so on.
            if (current.val == current.next.val)
            {
                current.next = current.next.next;
            }
            else
            {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node;
        node.next = node2;

        ListNode result = RemoveDuplicatesSortedList.deleteDuplicates(head);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
