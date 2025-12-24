class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        pool = set(nums)
        max_count = 0

        for num in pool:
            if (num - 1) not in pool:
                count = 1

                while True:
                    if (num + count) in pool:
                        count += 1
                    else:
                        break
                        
                max_count = max(count, max_count)

        return max_count