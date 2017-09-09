import java.util.Arrays;

public class PlusOne
{
    /**
     * Given a non-negative integer represented as a non-empty array of digits, plus
     * one to the integer.
     *
     * You may assume the integer do not contain any leading zero, except the number
     * 0 itself.
     *
     * The digits are stored such that the most significant digit is at the head of
     * the list.
     */
    public static int[] plusOne(int[] digits)
    {
        if (digits.length == 0)
        {
            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--)
        {
            // If digit < 9, then simply add one
            if (digits[i] < 9)
            {
                digits[i] = digits[i] + 1;
                return digits;
            }

            // Set to 0, try to add 1 to next digit in next iteration
            digits[i] = 0;
        }

        // If it reaches here, most significant digit is 9 with carry
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;

        return arr;
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(PlusOne.plusOne(new int[] { 1, 2, 3 })));
        System.out.println(Arrays.toString(PlusOne.plusOne(new int[] { 1, 2, 9 })));
        System.out.println(Arrays.toString(PlusOne.plusOne(new int[] { 1, 9, 9 })));
        System.out.println(Arrays.toString(PlusOne.plusOne(new int[] { 9, 9, 9 })));
    }
}
