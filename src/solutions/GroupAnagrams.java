package solutions;

import java.util.*;

public class GroupAnagrams
{
    /**
     * 49. Given an array of strings, group anagrams together.
     * <p>
     * Example:
     * <p>
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * <p>
     * Note:
     * <p>
     * All inputs will be in lowercase. The order of your output does not matter.
     */
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return new ArrayList<>();
        }

        // If two strings are anagrams of each other, then sorting them would yield the same result.
        // For e.g., aab -> [aab, aba, baa, ...], so use a map to track each resulting sorted string (key) with a
        // list (value) of the initial unsorted input strings.
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs)
        {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedKey = String.valueOf(c);
            if (!map.containsKey(sortedKey))
            {
                map.put(sortedKey, new ArrayList<>());
            }
            map.get(sortedKey).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args)
    {
        System.out.println(
                GroupAnagrams.groupAnagrams(new String[] { "\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"" }));
    }
}
