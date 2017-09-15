import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate
{
    /**
     * Given an array of integers, find if the array contains any duplicates. Your
     * function should return true if any value appears at least twice in the array,
     * and it should return false if every element is distinct.
     */
    public boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            int val = nums[i];
            if (seen.contains(val))
            {
                return true;
            }
            seen.add(val);
        }

        return false;
    }

    /**
     * Given an array of integers and an integer k, find out whether there are two
     * distinct indices i and j in the array such that nums[i] = nums[j] and the
     * absolute difference between i and j is at most k.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            int val = nums[i];
            if (seen.containsKey(val))
            {
                int index = seen.get(val);
                if (i - index < k)
                {
                    return true;
                }
            }
            seen.put(val, i);
        }

        return false;
    }
}
