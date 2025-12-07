class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)

        volume = 0
        left = 0
        right = n - 1

        while left < right:
            width = right - left

            if height[left] < height[right]:
                prod = height[left] * width
                left += 1
            else:
                prod = height[right] * width
                right -= 1
            
            volume = max(prod, volume)

        return volume