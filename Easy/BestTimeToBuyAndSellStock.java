package LeetCode.Easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int buy = Integer.MAX_VALUE; // To track the minimum price encountered
        int profit = 0; // To track the maximum profit

        for(int i : prices) {
            buy = Math.min(buy, i);
            profit = Math.max(profit, i - buy); // Calculate profit if the current price gives a better profit
        }

        return profit;

        //Another approach
        // if(prices.length < 2) return 0;

        // int buy = Integer.MAX_VALUE;
        // int profit = Integer.MIN_VALUE;

        // int i = 0;
        // while(i + 1 < prices.length) {
        //     if(prices[i] < prices[i + 1]) {
        //         buy = Math.min(buy, prices[i]);
        //         if(buy != Integer.MAX_VALUE) {
        //             profit = Math.max(profit, prices[i + 1] - buy);
        //         }
        //     }
            
        //     i++;
        // }

        // return (profit == Integer.MIN_VALUE) ? 0 : profit;
    }
}
