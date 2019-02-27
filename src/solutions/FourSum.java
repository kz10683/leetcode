package solutions;

import java.util.*;

public class FourSum
{
    /**
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a
     * + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     * <p>
     * Note:
     * <p>
     * The solution set must not contain duplicate quadruplets.
     * <p>
     * Example:
     * <p>
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     * <p>
     * A solution set is:
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     */
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        if (nums == null || nums.length < 4)
        {
            return new ArrayList<>();
        }

        Set<List<Integer>> set = new HashSet();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++)
        {
            int a = nums[i];

            // Reduce to 3-sum problem
            for (int j = i + 1; j < nums.length - 2; j++)
            {
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end)
                {
                    int b = nums[j];
                    int c = nums[start];
                    int d = nums[end];
                    int sum = a + b + c + d;

                    if (sum == target)
                    {
                        List<Integer> list = new ArrayList();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        list.add(d);
                        set.add(list);

                        start++;
                        end--;
                    }
                    else if (sum < target)
                    {
                        start++;
                    }
                    else
                    {
                        end--;
                    }
                }
            }
        }

        return new ArrayList(set);
    }
}
