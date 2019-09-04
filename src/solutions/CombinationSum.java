package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum
{
    /**
     * 39. Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all
     * unique combinations in candidates where the candidate numbers sums to target.
     * <p>
     * The same repeated number may be chosen from candidates unlimited number of times.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * <p>
     * Example 1:
     * <p>
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     * [7],
     * [2,2,3]
     * ]
     * <p>
     * Example 2:
     * <p>
     * Input: candidates = [2,3,5], target = 8,
     * A solution set is:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
        {
            return result;
        }

        // Sort the array ahead of time to account for checking duplicates
        Arrays.sort(candidates);

        recurse(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    public static void recurse(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int index)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        else if (target < 0)
        {
            return;
        }

        // Set start to index since we don't need to recheck the same numbers again
        for (int i = index; i < candidates.length; i++)
        {
            // Skip if same as previous integer since the recursion already accounted for it
            if (i >= 1 && candidates[i] == candidates[i - 1])
            {
                continue;
            }

            list.add(candidates[i]);
            recurse(candidates, target - candidates[i], result, list, i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(CombinationSum.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
        System.out.println(CombinationSum.combinationSum(new int[] { 2, 3, 5 }, 8));
    }
}
