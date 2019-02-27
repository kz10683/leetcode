package solutions;

import java.util.HashSet;

public class HappyNumber
{
    /**
     * 202. Write an algorithm to determine if a number is "happy".
     * <p>
     * A happy number is a number defined by the following process: Starting with any positive integer, replace the
     * number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will
     * stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1
     * are happy numbers.
     * <p>
     * Example:
     * <p>
     * Input: 19
     * Output: true
     * Explanation:
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     */
    public static boolean isHappy(int n)
    {
        // Set keeps track of sums when an infinite cycle occurs
        // Otherwise, keep summing squares of digits until it equals 1
        HashSet<Integer> set = new HashSet();
        while (!set.contains(n))
        {
            set.add(n);

            int sum = 0;
            while (n > 0)
            {
                int digit = n % 10;
                sum += digit * digit;

                n = n / 10;
            }

            if (sum == 1)
            {
                return true;
            }

            n = sum;
        }

        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(HappyNumber.isHappy(21));
        System.out.println(HappyNumber.isHappy(19));
        System.out.println(HappyNumber.isHappy(239));
    }
}
