package solutions;

public class PalindromeNumber
{
    /**
     * Determine whether an integer is a palindrome. Do this without extra space.
     */
    public boolean isPalindrome(int x)
    {
        int num = x;
        int reversed = 0;

        while (num > 0)
        {
            if (reversed > Integer.MAX_VALUE / 10)
            {
                return false;
            }

            int digit = num % 10;
            num = num / 10;

            reversed = (reversed * 10) + digit;
        }

        return x == reversed;
    }
}
