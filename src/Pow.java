package src;

public class Pow
{
    /**
     * 50. Implement pow(x, n), which calculates x raised to the power n (x^n).
     * <p>
     * Example 1:
     * <p>
     * Input: 2.00000, 10
     * Output: 1024.00000
     * <p>
     * Example 2:
     * <p>
     * Input: 2.10000, 3
     * Output: 9.26100
     * <p>
     * Example 3:
     * <p>
     * Input: 2.00000, -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/2^2 = 1/4 = 0.25
     * <p>
     * Note:
     * <p>
     * -100.0 < x < 100.0
     * n is a 32-bit signed integer, within the range [−231, 231 − 1]
     */
    public static double myPow(double x, int n)
    {
        double result = 1;
        int power = Math.abs(n);

        // Faster exponentiation by squaring:
        // 3 ^ 1
        // 3 ^ 2
        // 3 ^ 3 = 3 ^ 2 * 3 ^ 1
        // 3 ^ 4 = 3 ^ 2 * 3 ^ 2
        // 3 ^ 5 = 3 ^ 2 * 3 ^ 2 * 3 ^ 1
        while (power != 0)
        {
            // Whenever there's an odd grouping (e.g. 3^3 = 3^2 * 3^1)
            if (power % 2 != 0)
            {
                result = result * x;
            }

            power = power / 2; // Divide by 2 since we're grouping by squares
            x = x * x; // Keep squaring
        }

        if (n < 0)
        {
            return 1 / result;
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(Pow.myPow(3, 0));
        System.out.println(Pow.myPow(3, 2));
        System.out.println(Pow.myPow(3, 3));
        System.out.println(Pow.myPow(3, 4));
        System.out.println(Pow.myPow(3, -1));
    }
}
