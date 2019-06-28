package solutions;

public class ValidAnagram
{
    /**
     * 242. Given two strings s and t , write a function to determine if t is an anagram of s.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * <p>
     * Example 2:
     * <p>
     * Input: s = "rat", t = "car"
     * Output: false
     * <p>
     * Note: You may assume the string contains only lowercase alphabets.
     */
    public boolean isAnagram(String s, String t)
    {
        if (s.length() != t.length())
        {
            return false;
        }

        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++)
        {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++)
        {
            counts[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < counts.length; i++)
        {
            if (counts[i] != 0)
            {
                return false;
            }
        }

        return true;
    }
}
