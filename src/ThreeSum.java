import java.util.*;

public class ThreeSum
{
    /**
     * 15. Given an array S of n integers, are there elements a, b, c in S such that a +
     * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Note: The solution set must not contain duplicate triplets.
     * <p>
     * For example, given array S = [-1, 0, 1, 2, -1, -4],
     * <p>
     * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
     */
    public List<List<Integer>> threeSum(int[] nums)
    {
        Set<List<Integer>> set = new HashSet<>();

        // Sort the array. At each index, start checking the sum including the number at
        // the next index and the end. If 0, add to the solution set. If larger,
        // decrement the end, and vice versa.

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end)
            {
                int x = nums[i];
                int y = nums[start];
                int z = nums[end];
                int sum = x + y + z;

                if (sum == 0)
                {
                    List<Integer> list = new ArrayList();
                    list.add(x);
                    list.add(y);
                    list.add(z);
                    set.add(list);

                    // Continue search
                    start++;
                    end--;
                }
                else if (sum > 0)
                {
                    end--;
                }
                else
                {
                    start++;
                }
            }
        }

        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSumV2(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3)
        {
            return list;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end)
            {
                int x = nums[i];
                int y = nums[start];
                int z = nums[end];
                int sum = x + y + z;

                if (sum == 0)
                {
                    List<Integer> currentList = new ArrayList();
                    currentList.add(x);
                    currentList.add(y);
                    currentList.add(z);
                    list.add(currentList);

                    // Skip duplicates
                    while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    {
                        i++;
                    }
                    while (start < nums.length - 1 && nums[start] == nums[start + 1])
                    {
                        start++;
                    }
                    while (end > 0 && nums[end] == nums[end - 1])
                    {
                        end--;
                    }

                    // Continue search
                    start++;
                    end--;
                }
                else if (sum > 0)
                {
                    end--;
                }
                else
                {
                    start++;
                }
            }
        }
        return list;
    }

}
