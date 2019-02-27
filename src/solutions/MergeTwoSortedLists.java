package solutions;

import util.ListNode;

public class MergeTwoSortedLists
{
    /**
     * Merge two sorted linked lists and return it as a new list. The new list
     * should be made by splicing together the nodes of the first two lists.
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode merged = new ListNode(0);
        ListNode head = merged;

        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                merged.next = new ListNode(l1.val);
                l1 = l1.next;
                merged = merged.next;
            }
            else
            {
                merged.next = new ListNode(l2.val);
                l2 = l2.next;
                merged = merged.next;
            }
        }

        while (l1 != null)
        {
            merged.next = new ListNode(l1.val);
            l1 = l1.next;
            merged = merged.next;
        }

        while (l2 != null)
        {
            merged.next = new ListNode(l2.val);
            l2 = l2.next;
            merged = merged.next;
        }

        return head.next;
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);

        ListNode head = mergeTwoLists(l1, l2);
        while (head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
