package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber
{
    private static Map<Character, String> map = new HashMap<>();

    static
    {
        map.put('2' , "abc");
        map.put('3' , "def");
        map.put('4' , "ghi");
        map.put('5' , "jkl");
        map.put('6' , "mno");
        map.put('7' , "pqrs");
        map.put('8' , "tuv");
        map.put('9' , "wxyz");
    }

    /**
     * 17. Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
     * could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to
     * any letters.
     * <p>
     * Example:
     * <p>
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * <p>
     * Note:
     * <p>
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     */
    public static List<String> letterCombinations(String digits)
    {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.isEmpty())
        {
            return list;
        }

        recurse(digits, list, new StringBuilder(), 0);
        return list;
    }

    public static void recurse(String digits, List<String> list, StringBuilder sb, int currentIndex)
    {
        // Base case is when the length of the current built-up string is the same length as the digits
        if (sb.length() == digits.length())
        {
            list.add(sb.toString());
            return;
        }

        // The current index corresponds to the string of characters to iterate over at the current level
        String currentLetters = map.get(digits.charAt(currentIndex));
        for (int i = 0; i < currentLetters.length(); i++)
        {
            sb.append(currentLetters.charAt(i));
            recurse(digits, list, sb, currentIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(LetterCombinationsPhoneNumber.letterCombinations("23"));
    }
}
