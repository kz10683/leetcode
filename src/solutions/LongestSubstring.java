package solutions;

import java.util.HashSet;

public class LongestSubstring
{
    /**
     * 3. Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * Example 1:
     * <p>
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", which the length is 3.
     * <p>
     * Example 2:
     * <p>
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * <p>
     * Example 3:
     * <p>
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public static int lengthOfLongestSubstring(String s)
    {
        if (s.length() == 0)
        {
            return 0;
        }

        HashSet<Character> set = new HashSet();
        int length = 0;
        int startIndex = 0;
        int endIndex = 0;
        // String subStr = "";

        // Two indices track positions. If the char is seen at the end index, add it to the set and continue. Otherwise,
        // remove the char at the start index and check again. This covers all possibilities.
        while (endIndex < s.length())
        {
            if (!set.contains(s.charAt(endIndex)))
            {
                set.add(s.charAt(endIndex));
                length = Math.max(length, set.size());
                // String currSubStr = s.substring(startIndex, endIndex + 1);
                // subStr = (currSubStr.length() > subStr.length()) ? currSubStr : subStr;
                endIndex++;
            }
            else
            {
                set.remove(s.charAt(startIndex));
                startIndex++;
            }
        }

        // System.out.println(subStr);
        return length;
    }

    public static void main(String[] args)
    {
        System.out.println(LongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(LongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(LongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(LongestSubstring.lengthOfLongestSubstring("au"));
    }
}
