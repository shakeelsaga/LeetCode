class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = dict()

        i = 0
        while i < len(nums):
            if (target - nums[i]) in seen:
                return [i, seen[target - nums[i]]]
            else:
                seen[nums[i]] = i
                i += 1

        return []