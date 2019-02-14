package src;

public class FirstUniqueCharacter
{
    /**
     * 387. Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist,
     * return -1.
     * <p>
     * Examples:
     * <p>
     * s = "leetcode"
     * return 0.
     * <p>
     * s = "loveleetcode",
     * return 2.
     * <p>
     * Note: You may assume the string contain only lowercase letters.
     */
    public static int firstUniqChar(String s)
    {
        // Since the input string is only lower-case letters, we can have an int array of size 26 to store the counts
        // for each letter. Each index of the array corresponds to its order in the alphabet (0->a, 1->b, ..., 25->z).
        // At the end, we just loop over the string again to check if any character count is equal to 1.
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            int charIndex = s.charAt(i) - 'a';
            arr[charIndex]++;
        }

        for (int i = 0; i < s.length(); i++)
        {
            if (arr[s.charAt(i) - 'a'] == 1)
            {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println(FirstUniqueCharacter.firstUniqChar("leetcode"));
        System.out.println(FirstUniqueCharacter.firstUniqChar("loveleetcode"));
        System.out.println(FirstUniqueCharacter.firstUniqChar("aaa"));
        System.out.println(FirstUniqueCharacter.firstUniqChar("zab"));
    }
}
