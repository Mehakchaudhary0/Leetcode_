class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        '''total = 0
        tank = 0
        start = 0
        n = len(gas)
        for i in range(n):
            d = gas[i] - cost[i]
            tank += d
            total += d

            if tank < 0:
                start = i+1
                tank = 0

        if total < 0:
            return -1

        return start'''

        if sum(gas) < sum(cost):
            return -1
        start = 0
        tank = 0
        for i in range(len(gas)):
            tank += gas[i] - cost[i]
            if tank < 0:
                start = i + 1
                tank = 0
        return start
