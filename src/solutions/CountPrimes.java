package solutions;

import java.util.Arrays;

/**
 * 204. Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes
{
    public static int countPrimes(int n)
    {
        // Create an array of integers up to n. Starting from the first prime 2, mark off all multiples as non-prime,
        // and continue for each integer up to the square root of n.
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++)
        {
            if (isPrime[i])
            {
                // Mark off all multiples as non-prime
                for (int j = 2 * i; j < n; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }

        // Count primes
        int count = 0;
        for (int i = 2; i < isPrime.length; i++)
        {
            if (isPrime[i])
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(CountPrimes.countPrimes(1));
        System.out.println(CountPrimes.countPrimes(2));
        System.out.println(CountPrimes.countPrimes(3));
        System.out.println(CountPrimes.countPrimes(10));
    }
}
