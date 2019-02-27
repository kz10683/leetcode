package solutions;

import util.ListNode;

public class LinkedListCycle
{
    /**
     * Given a linked list, determine if it has a cycle in it.
     */
    public boolean hasCycle(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return false;
        }

        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null)
        {
            if (slow == fast)
            {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
