
public class RomanToInteger
{
    /**
     * Given a roman numeral, convert it to an integer.
     *
     * Input is guaranteed to be within the range from 1 to 3999.
     */

    public static int romanToInt(String s)
    {
        int result = 0;

        for (int i = 0; i < s.length() - 1; i++)
        {
            char currentChar = s.charAt(i);
            char peekChar = s.charAt(i + 1);

            int currentVal = lookup(currentChar);
            int peekVal = lookup(peekChar);

            // e.g. IV
            if (peekVal > currentVal)
            {
                result -= currentVal;
            }
            // e.g. XII
            else
            {
                result += currentVal;
            }

        }

        result += lookup(s.charAt(s.length() - 1));

        return result;
    }

    public static int lookup(char c)
    {

        switch (c)
        {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return 0;
        }
    }

}
