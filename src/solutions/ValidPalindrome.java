package solutions;

public class ValidPalindrome
{
    /**
     * Given a string, determine if it is a palindrome, considering only
     * alphanumeric characters and ignoring cases.
     * <p>
     * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
     * is not a palindrome.
     * <p>
     * Note: Have you consider that the string might be empty? This is a good
     * question to ask during an interview.
     * <p>
     * For the purpose of this problem, we define empty string as valid palindrome.
     */
    public boolean isPalindrome(String s)
    {
        StringBuilder strBuilder = new StringBuilder();

        // Remove extraneous characters
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c))
            {
                strBuilder.append(Character.toLowerCase(c));
            }
        }

        // If the reversed string is the same, it's a palindrome
        String str = strBuilder.toString();
        String reversedStr = strBuilder.reverse().toString();

        return str.equals(reversedStr);
    }
}
