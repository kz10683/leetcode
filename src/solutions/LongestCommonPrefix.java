package solutions;

public class LongestCommonPrefix
{
    /**
     * Write a function to find the longest common prefix string amongst an array of
     * strings.
     */
    public static String longestCommonPrefix(String[] strs)
    {
        if (strs.length == 0)
        {
            return "";
        }

        // Vertically scan each character from the first base string
        for (int i = 0; i < strs[0].length(); i++)
        {
            char current = strs[0].charAt(i);

            // Check all remaining strings
            for (int j = 1; j < strs.length; j++)
            {
                // If the current character doesn't match or there's nothing left to check,
                // return
                if (strs[j].length() == i || strs[j].charAt(i) != current)
                {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args)
    {
        String[] strs = new String[] { "asdf", "asdfqwerty", "asdfasdf" };
        System.out.println(longestCommonPrefix(strs));

        String[] strs_2 = new String[] { "asdf", "as", "a" };
        System.out.println(longestCommonPrefix(strs_2));
    }

}
