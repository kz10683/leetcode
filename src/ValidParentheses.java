import java.util.Stack;

public class ValidParentheses
{
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and
     * ']', determine if the input string is valid.
     *
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid
     * but "(]" and "([)]" are not.
     */

    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++)
        {
            char current = s.charAt(i);

            if (current == '(' || current == '{' || current == '[')
            {
                stack.push(current);
            }
            else
            {
                // If a closing bracket, attempt to pop off stack and compare type
                if (stack.isEmpty())
                {
                    return false;
                }
                char top = stack.pop();
                if ((current == ')' && top != '(') || (current == '}' && top != '{') || (current == ']' && top != '['))
                {
                    return false;
                }
            }
        }

        if (!stack.isEmpty())
        {
            return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(isValid("()"));
        System.out.println(isValid(""));
        System.out.println(isValid("([)"));
        System.out.println(isValid("{[()]}"));

    }

}
