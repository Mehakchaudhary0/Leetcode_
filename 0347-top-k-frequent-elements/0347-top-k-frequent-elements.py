class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        freq = Counter(nums)
        heap = []

        for num in freq:
            heapq.heappush(heap, (freq[num], num)) 
        
            if len(heap) > k:
                heapq.heappop(heap)
        return [num for frequency, num in heap]