package solutions;

public class DivideTwoIntegers
{
    /**
     * 29. Given two integers dividend and divisor, divide two integers without using multiplication, division and mod
     * operator.
     * <p>
     * Return the quotient after dividing dividend by divisor.
     * <p>
     * The integer division should truncate toward zero.
     * <p>
     * Example 1:
     * <p>
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * <p>
     * Example 2:
     * <p>
     * Input: dividend = 7, divisor = -3
     * Output: -2
     * <p>
     * Note:
     * <p>
     * Both dividend and divisor will be 32-bit signed integers. The divisor will never be 0.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
     * [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division
     * result overflows.
     */
    public static int divide(int dividend, int divisor)
    {
        boolean isNegative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
        {
            isNegative = true;
        }

        long count = 1;
        long result = 0;
        long increasingDivisor = Math.abs((long) divisor);
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        // The basic idea is to increase the divisor each iteration, subtract from the dividend, and update the count
        // If at any point the increasing divisor is greater than the remaining dividend, but the regular divisor is
        // not, then backtrack and retry.
        while (longDividend >= longDivisor)
        {
            System.out.println(longDividend);
            if (longDividend >= increasingDivisor)
            {
                result += count;
                longDividend = longDividend - increasingDivisor;

                increasingDivisor = increasingDivisor << 1;
                count = count << 1;
            }
            else
            {
                // The divisor is too large at this point, so decrease and try again
                increasingDivisor = increasingDivisor >> 1;
                count = count >> 1;
            }
        }

        if (isNegative)
        {
            result = result * -1;
        }

        if (result > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args)
    {
        System.out.println(DivideTwoIntegers.divide(10, 2));
        System.out.println(DivideTwoIntegers.divide(100, 2));
        System.out.println(DivideTwoIntegers.divide(10, -2));
        System.out.println(DivideTwoIntegers.divide(-2147483648, -1));
    }
}
