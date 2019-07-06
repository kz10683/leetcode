package solutions;

public class AddStrings
{
    /**
     * 415. Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
     * <p>
     * Note:
     * <p>
     * The length of both num1 and num2 is < 5100.
     * Both num1 and num2 contains only digits 0-9.
     * <p>
     * Both num1 and num2 does not contain any leading zero.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */
    public static String addStrings(String num1, String num2)
    {
        String sum = "";
        int carry = 0;

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        while (index1 >= 0 || index2 >= 0)
        {
            int a = (index1 >= 0 ? num1.charAt(index1) - '0' : 0);
            int b = (index2 >= 0 ? num2.charAt(index2) - '0' : 0);

            int currentSum = a + b + carry;
            int digit = currentSum % 10;
            sum = digit + sum;

            carry = (currentSum > 9 ? 1 : 0);

            index1--;
            index2--;
        }

        if (carry == 1)
        {
            sum = '1' + sum;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(AddStrings.addStrings("123", "456"));
        System.out.println(AddStrings.addStrings("123", "1000"));
        System.out.println(AddStrings.addStrings("99", "99"));
    }
}
