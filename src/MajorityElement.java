
public class MajorityElement
{
    /**
     * Given an array of size n, find the majority element. The majority element is
     * the element that appears more than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and the majority element always
     * exist in the array.
     */
    public int majorityElement(int[] nums)
    {
        // Boyer-Moore majority vote algorithm
        // https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
        int num = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (count == 0)
            {
                num = nums[i];
                count = 1;
            }
            else if (nums[i] == num)
            {
                count++;
            }
            else
            {
                count--;
            }
        }

        return num;
    }
}
