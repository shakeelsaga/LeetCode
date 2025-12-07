class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)

        volume = 0
        left = 0
        right = n - 1

        while left < right:
            width = right - left

            if height[left] < height[right]:
                current_vol = height[left] * width
                left += 1
            else:
                current_vol = height[right] * width
                right -= 1
            
            volume = max(current_vol, volume)

        return volume