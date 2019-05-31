package solutions;

public class MinStack
{
    /**
     * 155. Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * <p>
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     * <p>
     * Example:
     * <p>
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> Returns -3.
     * minStack.pop();
     * minStack.top();      --> Returns 0.
     * minStack.getMin();   --> Returns -2.
     */

    /**
     * Use a linked list to represent the min stack. Each node tracks the last seen node at time of insertion/push.
     * The head node represents the "top" of the stack. Each insertion/push becomes the new head.
     */
    public class MinListNode
    {
        public MinListNode next;
        public int val;
        public int min; // Tracks min val seen so far

        public MinListNode(int val, int min)
        {
            this.val = val;
            this.min = min;
        }
    }

    private MinListNode head; // Represents the "top" node

    public MinStack()
    {

    }

    public void push(int x)
    {
        if (this.head == null)
        {
            this.head = new MinListNode(x, x);
        }
        else
        {
            MinListNode node = new MinListNode(x, Math.min(x, this.head.min));
            node.next = this.head;
            this.head = node;
        }
    }

    public void pop()
    {
        this.head = this.head.next;
    }

    public int top()
    {
        return this.head.val;
    }

    public int getMin()
    {
        return this.head.min;
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static void main(String[] args)
    {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
