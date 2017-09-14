
public class FirstBadVersion
{
    /**
     * You are a product manager and currently leading a team to develop a new
     * product. Unfortunately, the latest version of your product fails the quality
     * check. Since each version is developed based on the previous version, all the
     * versions after a bad version are also bad.
     *
     * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
     * bad one, which causes all the following ones to be bad.
     *
     * You are given an API bool isBadVersion(version) which will return whether
     * version is bad. Implement a function to find the first bad version. You
     * should minimize the number of calls to the API.
     */
    public static int firstBadVersion(int n)
    {
        int low = 1;
        int high = n;

        // Use a modified binary search to find the first occurrence of the bad version.
        // When the upper and lower bound meet, we've found it.
        while (low != high)
        {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid))
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }

        return high;
    }

    /**
     * The actual API call is on leetcode. This is for testing purposes only.
     */
    private static boolean isBadVersion(int n)
    {
        return n >= 2;
    }

    public static void main(String[] args)
    {
        System.out.println(FirstBadVersion.firstBadVersion(7));
    }

}
