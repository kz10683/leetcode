package solutions;

public class JumpGame
{
    /**
     * 55. Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Determine if you are able to reach the last index.
     * <p>
     * Example 1:
     * <p>
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * <p>
     * Example 2:
     * <p>
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     */
    public static boolean canJump(int[] nums)
    {
        // Backtrack from the last position reachable
        int lastKnownPosition = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--)
        {
            if (i + nums[i] >= lastKnownPosition)
            {
                lastKnownPosition = i;
            }
        }

        // If we are able to reach the beginning, then it's possible to reach the end
        return lastKnownPosition == 0;
    }

    public static boolean canJumpRecursive(int position, int[] nums)
    {
        // O(2^n)
        // Base case: the position is at the end
        if (position == nums.length - 1)
        {
            return true;
        }

        // Calculate the max jump from the current position, and recursively try all possibilities for each
        int maxJump = Math.min(position + nums[position], nums.length - 1);
        for (int current = position + 1; current <= maxJump; current++)
        {
            if (canJumpRecursive(current, nums))
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(JumpGame.canJumpRecursive(0, new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(JumpGame.canJumpRecursive(0, new int[] { 3, 2, 1, 0, 4 }));

        System.out.println(JumpGame.canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(JumpGame.canJump(new int[] { 3, 2, 1, 0, 4 }));
        System.out.println(JumpGame.canJump(new int[] { 1, 1, 1, 1, 1 }));
        System.out.println(JumpGame.canJump(new int[] { 0, 1, 1, 1, 1 }));
    }
}

