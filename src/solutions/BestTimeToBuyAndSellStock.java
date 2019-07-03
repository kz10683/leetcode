package solutions;

public class BestTimeToBuyAndSellStock
{
    /**
     * 121. Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     * <p>
     * Note that you cannot sell a stock before you buy one.
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Not 7-1 = 6, as selling price needs to be larger than buying price.
     * <p>
     * Example 2:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */
    public static int maxProfit(int[] prices)
    {
        // One-pass: Find the min in the array, and calculate the max difference from then onwards
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++)
        {
            // Check for new min value
            if (prices[i] < min)
            {
                min = prices[i];
            }
            else if (prices[i] - min > 0)
            {
                max = Math.max(max, prices[i] - min);
            }
        }

        return max;
    }

    public static int maxProfitNaive(int[] prices)
    {
        int max = 0;
        for (int i = 0; i < prices.length; i++)
        {
            for (int j = i + 1; j < prices.length; j++)
            {
                if (prices[j] > prices[i])
                {
                    max = Math.max(prices[j] - prices[i], max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(BestTimeToBuyAndSellStock.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(BestTimeToBuyAndSellStock.maxProfit(new int[] { 7, 6, 4, 3, 1 }));

        System.out.println(BestTimeToBuyAndSellStock.maxProfitNaive(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(BestTimeToBuyAndSellStock.maxProfitNaive(new int[] { 7, 6, 4, 3, 1 }));
    }
}
