class Solution(object):
    def countCommas(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans = 0

        if n >= 1000:
            ans += n - 999
        if n >= 1000000:
            ans += n - 999999
        if n >= 1000000000:
            ans += n - 999999999
        power = 10**12

        while n >= power:
            ans += n - power + 1
            power *= 1000

        return ans