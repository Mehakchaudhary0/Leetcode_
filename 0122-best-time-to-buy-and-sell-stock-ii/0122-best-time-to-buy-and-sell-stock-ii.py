class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        hold = -float('inf')
        sell = 0
        for price in prices:
            sell = max(sell, hold + price)
            hold = max(hold, sell - price)
        return sell   