class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        smallest_price = float('inf')
        max_profit = 0

        for price in prices:
            if price <= smallest_price:
                smallest_price = price
            else:
                max_profit = max(price - smallest_price, max_profit)
            
        return max_profit