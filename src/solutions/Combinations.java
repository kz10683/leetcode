package solutions;

import java.util.ArrayList;
import java.util.List;

public class Combinations
{
    /**
     * 77. Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * <p>
     * Example:
     * <p>
     * Input: n = 4, k = 2
     * Output:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */
    public static List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> result = new ArrayList<>();
        recurse(n, k, result, new ArrayList<>(), 1);
        return result;
    }

    public static void recurse(int n, int k, List<List<Integer>> result, List<Integer> list, int index)
    {
        if (list.size() == k)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        // We start from the index and at a given index i, we recurse with i + 1 to avoid counting the same number
        for (int i = index; i <= n; i++)
        {
            list.add(i);
            recurse(n, k, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(Combinations.combine(3, 1));
        System.out.println(Combinations.combine(4, 2));
        System.out.println(Combinations.combine(5, 3));
    }
}
