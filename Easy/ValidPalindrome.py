class Solution:
    def isPalindrome(self, s: str) -> bool:
        converted_string = ""
        for char in s:
            if char.isalnum():
                converted_string += char.lower()

        left = 0
        right = len(converted_string) - 1

        while left < right:
            if not converted_string[left] == converted_string[right]:
                return False
            left += 1
            right -= 1
        
        return True