class Solution(object):
    def numberOfSets(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        MOD = 10**9 + 7
        ans = 1

        for i in range(1, 2 * k + 1):
            ans = ans * (n + k - i) // i

        return ans % MOD