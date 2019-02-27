package solutions;

public class IntegerToRoman
{
    // All the possible Roman numeral combinations and their corresponding values
    public static int[] INTEGERS = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    public static String[] ROMAN_NUMERALS = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",
            "IV", "I" };

    /**
     * Given an integer, convert it to a roman numeral.
     * <p>
     * Input is guaranteed to be within the range from 1 to 3999.
     */
    public String intToRoman(int num)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < INTEGERS.length; i++)
        {
            while (num >= INTEGERS[i])
            {
                num = num - INTEGERS[i];
                result.append(ROMAN_NUMERALS[i]);
            }
        }

        return result.toString();
    }

}
