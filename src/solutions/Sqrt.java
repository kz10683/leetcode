package solutions;

public class Sqrt
{
    /**
     * Implement int sqrt(int x).
     * <p>
     * Compute and return the square root of x.
     */
    public static int mySqrt(int x)
    {
        if (x == 0 || x == 1)
        {
            return x;
        }

        // Use binary search, up to x/2 because the square root can never exceed it
        int low = 0;
        int high = x / 2;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            // Multiplying two ints potentially gives overflow, so cast to longs
            long square = (long) mid * (long) mid;

            if (square == x)
            {
                return mid;
            }
            else if (square > x)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return high;
    }

    public static void main(String[] args)
    {
        System.out.println(Sqrt.mySqrt(5));
        System.out.println(Sqrt.mySqrt(256));
        System.out.println(Sqrt.mySqrt(2147395599));
    }
}
