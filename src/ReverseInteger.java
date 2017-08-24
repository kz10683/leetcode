
public class ReverseInteger
{
    /**
     * Reverse digits of an integer.
     *
     * Example1: x = 123, return 321 Example2: x = -123, return -321
     *
     * Note: The input is assumed to be a 32-bit signed integer. Your function
     * should return 0 when the reversed integer overflows.
     */
    public static int reverse(int x)
    {
        int multiplier = 1;
        if (x < 0)
        {
            multiplier = -1;
            x = Math.abs(x);
        }

        int result = 0;

        while (x > 0)
        {
            if (result > Integer.MAX_VALUE / 10)
            {
                return 0;
            }

            int digit = x % 10;
            x = x / 10;

            result = (result * 10) + digit;
        }

        return result * multiplier;
    }

    public static void main(String[] args)
    {
        System.out.println(ReverseInteger.reverse(123));
        System.out.println(ReverseInteger.reverse(123456));
        System.out.println(ReverseInteger.reverse(0));
        System.out.println(ReverseInteger.reverse(-123));

        System.out.println(ReverseInteger.reverse(1534236469));
        System.out.println(ReverseInteger.reverse(Integer.MAX_VALUE));
    }
}
