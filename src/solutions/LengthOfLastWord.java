package solutions;

public class LengthOfLastWord
{
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space
     * characters ' ', return the length of last word in the string.
     * <p>
     * If the last word does not exist, return 0.
     * <p>
     * Note: A word is defined as a character sequence consists of non-space
     * characters only.
     * <p>
     * For example, Given s = "Hello World", return 5.
     */
    public static int lengthOfLastWord(String s)
    {
        s = s.trim();
        String[] arr = s.split(" ");

        if (arr.length > 0)
        {
            return arr[arr.length - 1].length();
        }

        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println(LengthOfLastWord.lengthOfLastWord("Hello World"));
        System.out.println(LengthOfLastWord.lengthOfLastWord("Goodbye, Cruel World"));
        System.out.println(LengthOfLastWord.lengthOfLastWord("Goodbye"));
        System.out.println(LengthOfLastWord.lengthOfLastWord(" "));
        System.out.println(LengthOfLastWord.lengthOfLastWord("asdf "));
        System.out.println(LengthOfLastWord.lengthOfLastWord(" day"));
    }

}
