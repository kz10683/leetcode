package solutions;

public class FactorialTrailingZeroes
{
    /**
     * 172. Given an integer n, return the number of trailing zeroes in n!.
     * <p>
     * Example 1:
     * <p>
     * Input: 3
     * Output: 0
     * Explanation: 3! = 6, no trailing zero.
     * <p>
     * Example 2:
     * <p>
     * Input: 5
     * Output: 1
     * Explanation: 5! = 120, one trailing zero.
     * <p>
     * Note: Your solution should be in logarithmic time complexity.
     */
    public int trailingZeroes(int n)
    {
        /**
         * The number of trailing zeros in a factorial is dependent on how many times it is divisible by 10.
         * We can calculate this by determining how many times 5 * 2 occurs, which can further be reduced to how many
         * times a 5 occurs since each 5 will always be followed by a 2.
         *
         * Just count how many times we can divide 5.
         * e.g. 10! = 10 * 9 * 8 * ... * 5 * ... 2 * 1 = 3628800; 10 / 5 = 2
         * e.g. 7! = 4320; 7 / 5 = 1
         * e.g. 5! = 120; 5 / 5 = 1
         * e.g. 3! = 6; 3 / 5 = 0
         */
        int count = 0;
        while (n > 0)
        {
            n = n / 5;
            count += n;
        }

        return count;
    }
}
