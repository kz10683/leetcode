package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations
{
    /**
     * 46. Given a collection of distinct integers, return all possible permutations.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     * Output:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */
    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        recurse(nums, result, new ArrayList<>(), new HashSet<>());
        return result;
    }

    public static void recurse(int[] nums, List<List<Integer>> result, List<Integer> list, Set<Integer> indices)
    {
        if (list.size() == nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        // We enumerate all possible permutations except for numbers at indices that have previously been visited,
        // so use a set to keep track of all previously seen indices
        for (int i = 0; i < nums.length; i++)
        {
            if (!indices.contains(i))
            {
                indices.add(i);
                list.add(nums[i]);
                recurse(nums, result, list, indices);
                list.remove(list.size() - 1);
                indices.remove(i);
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println(permute(new int[] { 1, 2, 3 }));
    }
}
