class Solution(object):
    def filterOccupiedIntervals(self, occupiedIntervals, freeStart, freeEnd):
        """
        :type occupiedIntervals: List[List[int]]
        :type freeStart: int
        :type freeEnd: int
        :rtype: List[List[int]]
        """
        if not occupiedIntervals:
            return []
        occupiedIntervals.sort()
        merged = []
        for start, end in occupiedIntervals:
            if not merged or start > merged[-1][1] + 1:
                merged.append([start, end])
            else:
                merged[-1][1] = max(merged[-1][1], end)
        ans = []
        for start, end in merged:
            if end < freeStart or start > freeEnd:
                ans.append([start, end])
                continue
            if start < freeStart:
                ans.append([start, freeStart - 1])
            if end > freeEnd:
                ans.append([freeEnd + 1, end])

        return ans