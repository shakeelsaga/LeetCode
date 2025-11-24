class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        i = 0
        j = 0

        while True:
            i = nums[i]
            j = nums[nums[j]]

            if i == j:
                break
        
        i = 0
        while i != j:
            i = nums[i]
            j = nums[j]

        return i