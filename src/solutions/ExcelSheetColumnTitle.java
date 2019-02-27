package solutions;

public class ExcelSheetColumnTitle
{
    /**
     * Given a positive integer, return its corresponding column title as appear in
     * an Excel sheet.
     * <p>
     * For example:
     * <p>
     * 1 -> A, 2 -> B, 3 -> C, ... 26 -> Z, 27 -> AA, 28 -> AB
     */
    public static String convertToTitle(int n)
    {
        String title = "";
        while (n > 0)
        {
            // We know there are 26-chars in the alphabet, so we mod by this to retrieve the
            // offset. This offset is used to determine the appropriate char to append from
            // 'A'.
            int offset = (n - 1) % 26;

            char c = (char) ('A' + offset);
            title = c + title;

            n = (n - 1) / 26;
        }
        return title;
    }

    public static void main(String[] args)
    {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(28));
    }
}
