
public class ClimbingStairs
{
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can
     * you climb to the top?
     *
     * Note: Given n will be a positive integer.
     */
    public int climbStairs(int n)
    {
        if (n == 1)
        {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
        {
            // At step i, the total # ways is the sum of the ways to reach steps i-1
            // and i-2
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
