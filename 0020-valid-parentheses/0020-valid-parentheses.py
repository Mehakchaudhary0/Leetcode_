class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        closeToOpen = {")": "(", "]": "[", "}": "{"}

        for c in s:
            if c in closeToOpen:
                if not stack or stack[-1] != closeToOpen[c]:
                    return False
                stack.pop()
            else:
                stack.append(c)

        return not stack