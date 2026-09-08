class Solution(object):
    def countCommas(self, n):
        count = 0

        for digits in range(4, len(str(n)) + 1):
            start = 10 ** (digits - 1)
            end = min(n, 10 ** digits - 1)

            if start <= end:
                count += (end - start + 1) * ((digits - 1) // 3)

        return count