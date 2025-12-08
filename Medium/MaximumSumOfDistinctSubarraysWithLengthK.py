class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        max_sum = 0
        left = 0
        right = k - 1
        seen = dict()

        i = 0
        curr_sum = 0
        while right < len(nums):
            curr_sum += nums[i]

            if nums[i] not in seen:
                seen[nums[i]] = 1
            else:
                seen[nums[i]] += 1

            if i == right:
                if len(seen) == k:
                    max_sum = max(curr_sum, max_sum)
                curr_sum -= nums[left]
                seen[nums[left]] -= 1
                if seen[nums[left]] == 0:
                    seen.pop(nums[left])
                right += 1
                left += 1
            i += 1

        return max_sum