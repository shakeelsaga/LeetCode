class Solution:
    def sortColors(self, nums: List[int]) -> None:
        i = 0
        zero = 0
        two = len(nums) - 1

        while i <= two:
            curr = nums[i]

            if curr == 0:
                nums[i] = nums[zero]
                nums[zero] = curr
                zero += 1
                i += 1
            elif curr == 2:
                nums[i] = nums[two]
                nums[two] = curr
                two -= 1
            else:
                i += 1
            