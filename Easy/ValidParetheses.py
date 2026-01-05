from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()

        closed_bracket = {')': '(', '}': '{', ']': '['}

        for char in s:
            if char in closed_bracket:
                if stack and stack[-1] == closed_bracket[char]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)

        return not stack