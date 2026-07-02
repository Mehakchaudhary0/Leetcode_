class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        xorr = 0
        for nums in nums:
            xorr ^= nums
        return xorr