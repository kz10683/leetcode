package solutions;

public class MaximumSubarray
{
    /**
     * Find the contiguous subarray within an array (containing at least one number)
     * which has the largest sum.
     * <p>
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
     * [4,-1,2,1] has the largest sum = 6.
     */
    public int maxSubArray(int[] nums)
    {
        // Keep track of max sum ending at index vs max sum seen so far.
        // We know that at some index i, we either include the value at i, or select it
        // as the new starting point. We compare this to the running total each
        // iteration.
        int maxSum = nums[0];
        int maxSumAtIndex = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            maxSumAtIndex = Math.max(maxSumAtIndex + nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxSumAtIndex);
        }

        return maxSum;
    }

    public int maxSubArrayIndex(int[] nums)
    {
        // If we want largest sum at each index, use DP
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            result[i] = Math.max(nums[i], result[i - 1] + nums[i]);
        }

        // For the sake of the question, return max
        int max = 0;
        for (int num : result)
        {
            max = Math.max(max, num);
        }

        return max;
    }
}
