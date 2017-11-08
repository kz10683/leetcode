
public class IntersectionOfTwoLinkedLists
{
    /**
     * Write a program to find the node at which the intersection of two singly
     * linked lists begins.
     *
     * If the two linked lists have no intersection at all, return null.
     *
     * The linked lists must retain their original structure after the function
     * returns.
     *
     * You may assume there are no cycles anywhere in the entire linked structure.
     *
     * Your code should preferably run in O(n) time and use only O(1) memory.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        // There are only three possibilities: length(A) == length(B), length(A) >
        // length(B) or length(B) < length(A). If there exists an intersection, the
        // length at that point onwards is obviously the same between the two linked
        // lists. So, we just need to make the starting point the same such that when we
        // iterate through, it ends on the last node. If at any point the nodes are the
        // same, we have the intersecting node.

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        // Figure out the longer linked list if it exists, and iterate up to the
        // difference to make the starting point the same
        int diff = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB)
        {
            for (int i = 0; i < diff; i++)
            {
                headA = headA.next;
            }
        }
        else
        {
            for (int i = 0; i < diff; i++)
            {
                headB = headB.next;
            }
        }

        // At this point, the lengths are the same, so check if there exists an
        // intersecting node
        while (headA != null)
        {
            if (headA == headB)
            {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static int getLength(ListNode head)
    {
        int length = 0;
        ListNode dummy = head;
        while (dummy != null)
        {
            length++;
            dummy = dummy.next;
        }

        return length;
    }
}
