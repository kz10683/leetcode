
public class NumberOf1Bits
{
    /**
     * Write a function that takes an unsigned integer and returns the number of ’1'
     * bits it has (also known as the Hamming weight).
     *
     * For example, the 32-bit integer ’11' has binary representation
     * 00000000000000000000000000001011, so the function should return 3.
     */
    public static int hammingWeight(int n)
    {
        int count = 0;
        int mask = 1;

        // We know the input is 32-bits, so iterate for each bit
        for (int i = 0; i < 32; i++)
        {
            // For example:
            // 1011 & 0001 = 0001
            // 1011 & 0010 = 0010
            // 1011 & 0100 = 0000
            // 1011 & 1000 = 1000
            if ((n & mask) != 0)
            {
                count++;
            }
            mask = mask << 1;
        }

        return count;
    }

    public static void main(String[] args)
    {

        System.out.println(NumberOf1Bits.hammingWeight(11));
    }
}
