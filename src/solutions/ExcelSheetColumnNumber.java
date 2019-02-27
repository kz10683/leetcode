package solutions;

public class ExcelSheetColumnNumber
{
    /**
     * Given a column title as appear in an Excel sheet, return its corresponding
     * column number.
     * <p>
     * For example:
     * <p>
     * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
     */
    public static int titleToNumber(String s)
    {
        // The formula is as follows:
        // ABA = 1 * (26^2) + 2 * (26^1) + 1 * (26^0) = 703
        // BA = 2 * (26^1) + 1 * (26^0) = 53
        // There are 26^N possibilities for a string of length N, multiplied by the
        // value of the char

        // Examples
        // A -> Z : 1 -> 26
        // AA -> AZ : 27 -> 52
        // BA -> BZ : 53 -> 78
        // AAA -> _ : 703 -> _
        // ABA -> _ : 729 -> _

        int totalVal = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int charVal = s.charAt(i) - 'A' + 1;
            int currentVal = (int) (Math.pow(26, s.length() - 1 - i) * charVal);

            totalVal += currentVal;
        }

        return totalVal;
    }

    public static void main(String[] args)
    {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("AZ"));
        System.out.println(titleToNumber("AAA"));
        System.out.println(titleToNumber("ABA"));
    }
}
