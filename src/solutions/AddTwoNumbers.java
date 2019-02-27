package solutions;

import util.ListNode;

public class AddTwoNumbers
{
    /**
     * You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order and each of their nodes
     * contain a single digit. Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the
     * number 0 itself.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode newHead = new ListNode(0);
        ListNode dummy = newHead;

        int carry = 0;
        while (l1 != null || l2 != null)
        {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;

            int val = val1 + val2 + carry;
            carry = (val > 9) ? 1 : 0;

            ListNode node = new ListNode(val % 10);
            newHead.next = node;
            newHead = newHead.next;

            if (l1 != null)
            {
                l1 = l1.next;
            }

            if (l2 != null)
            {
                l2 = l2.next;
            }
        }

        if (carry > 0)
        {
            newHead.next = new ListNode(1);
        }

        return dummy.next;
    }
}
