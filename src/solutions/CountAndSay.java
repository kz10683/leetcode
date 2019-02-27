package solutions;

public class CountAndSay
{
    /**
     * The count-and-say sequence is the sequence of integers with the first five
     * terms as following:
     * <p>
     * 1. 1 2. 11 3. 21 4. 1211 5. 111221
     * <p>
     * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
     * off as "one 2, then one 1" or 1211.
     * <p>
     * Given an integer n, generate the nth term of the count-and-say sequence.
     * <p>
     * Note: Each term of the sequence of integers will be represented as a string.
     * <p>
     * Example 1: Input: 1 Output: "1"
     * <p>
     * Example 2: Input: 4 Output: "1211"
     */
    public static String countAndSay(int n)
    {
        // Use two strings. The "previous" string contains the string to count and say,
        // and the "current" is the one we construct. Loop over n for each "previous"
        // string. On the next outer iteration, just set the "previous" as the
        // "current".

        String previous = "1";

        for (int i = 1; i < n; i++)
        {
            int count = 1;
            StringBuilder current = new StringBuilder("");

            for (int j = 0; j < previous.length(); j++)
            {
                // Keep counting if the next char is the same as the current
                if (j + 1 < previous.length() && previous.charAt(j) == previous.charAt(j + 1))
                {
                    count++;
                }
                // Otherwise, write the count and say. Reset the counter back to 1
                else
                {
                    current.append(count).append(previous.charAt(j));
                    count = 1;
                }
            }

            previous = current.toString();
        }

        return previous;
    }

    public static void main(String[] args)
    {
        System.out.println(CountAndSay.countAndSay(1));
        System.out.println(CountAndSay.countAndSay(2));
        System.out.println(CountAndSay.countAndSay(3));
        System.out.println(CountAndSay.countAndSay(4));
        System.out.println(CountAndSay.countAndSay(5));
    }
}
