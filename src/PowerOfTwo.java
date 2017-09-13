
public class PowerOfTwo
{
    /**
     * Given an integer, write a function to determine if it is a power of two.
     */
    public static boolean isPowerOfTwo(int n)
    {
        int num = 0;

        // If we look at the binary representation of any integer that is a power of
        // two, there will only be 1 bit set. So, we can just count the number of bits
        // set.
        while (n > 0)
        {
            if ((n & 1) == 1)
            {
                num++;
            }
            n = n >> 1;
        }

        return num == 1;
    }

    public static boolean isCleverPowerOfTwo(int n)
    {
        if (n <= 0)
        {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args)
    {
        System.out.println(PowerOfTwo.isPowerOfTwo(4));
        System.out.println(PowerOfTwo.isCleverPowerOfTwo(256));

        System.out.println(PowerOfTwo.isPowerOfTwo(5));
        System.out.println(PowerOfTwo.isCleverPowerOfTwo(123));
    }

}
