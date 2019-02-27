package solutions;

public class AddBinary
{
    /**
     * 67. Given two binary strings, return their sum (also a binary string).
     * <p>
     * The input strings are both non-empty and contains only characters 1 or 0.
     * <p>
     * Example 1:
     * <p>
     * Input: a = "11", b = "1"
     * Output: "100"
     * <p>
     * Example 2:
     * <p>
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     */
    public static String addBinary(String a, String b)
    {
        int aLength = a.length();
        int bLength = b.length();

        int carry = 0;
        String result = "";

        while (aLength > 0 || bLength > 0)
        {
            int aVal = (aLength > 0) ? a.charAt(aLength - 1) - '0' : 0;
            int bVal = (bLength > 0) ? b.charAt(bLength - 1) - '0' : 0;

            /**
             * The resulting digit at each index is calculated by xor-ing with the carry
             * 0 + 0 + 0 = 0 | 0 + 0 + 1 = 1
             * 0 + 1 + 0 = 1 | 0 + 1 + 1 = 0
             * 1 + 0 + 0 = 1 | 1 + 0 + 1 = 0
             * 1 + 1 + 0 = 0 | 1 + 1 + 1 = 1
             */
            int val = aVal ^ bVal ^ carry;
            carry = (aVal + bVal + carry > 1) ? 1 : 0;

            result = val + result;

            aLength--;
            bLength--;
        }

        if (carry == 1)
        {
            result = '1' + result;
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
