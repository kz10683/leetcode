package solutions;

public class BestTimeToBuyAndSellStockII
{
    /**
     * 122. Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy
     * one and sell one share of the stock multiple times).
     * <p>
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you
     * buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * <p>
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * <p>
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */
    public static int maxProfit(int[] prices)
    {
        // Find each "low" and corresponding "high" and continually sum the difference.
        // This is more effective than attempting to skip a "high" for a potentially higher "high", and this can be
        // clearly shown mathematically if each point is plotted on a graph.
        int profit = 0;
        int low;
        int high;

        for (int i = 0; i < prices.length - 1; i++)
        {
            // Find a "low" point
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
            {
                i++;
            }
            low = prices[i];

            // Find a "high" point
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
            {
                i++;
            }
            high = prices[i];

            profit += (high - low);
        }

        return profit;
    }

    public static void main(String[] args)
    {
        System.out.println(BestTimeToBuyAndSellStock.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(BestTimeToBuyAndSellStock.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }
}

