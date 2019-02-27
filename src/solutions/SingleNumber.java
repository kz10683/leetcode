package solutions;

public class SingleNumber
{
    /**
     * Given an array of integers, every element appears twice except for one. Find
     * that single one.
     */
    public int singleNumber(int[] nums)
    {
        // Xor-ing two numbers always returns 0. Xor-ing a number with 0 gives the
        // number. If one number is repeated twice, we can just xor the entire array of
        // numbers.
        int result = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            result = nums[i] ^ result;
        }

        return result;
    }
}
