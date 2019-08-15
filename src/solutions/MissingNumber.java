package solutions;

public class MissingNumber
{
    /**
     * 268. Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from
     * the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,0,1]
     * Output: 2
     * <p>
     * Example 2:
     * <p>
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * <p>
     * Note:
     * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space
     * complexity?
     */
    public static int missingNumber(int[] nums)
    {
        // Since we know there are n distinct numbers, we can calculate the expected sum of all numbers up to n.
        // We can then compare this to the actual sum of all the numbers in the nums array. The missing number can be
        // found by subtracting the actual from the expected.
        // E.g. [0, 1, 3] -> (0 + 1 + 2 + 3) - (0 + 1 + 3) = 2
        int expectedSum = 0;
        for (int i = 0; i <= nums.length; i++)
        {
            expectedSum += i;
        }

        int actualSum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            actualSum += nums[i];
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args)
    {
        System.out.println(MissingNumber.missingNumber(new int[] {}));
        System.out.println(MissingNumber.missingNumber(new int[] { 3, 0, 1 }));
        System.out.println(MissingNumber.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    }
}
