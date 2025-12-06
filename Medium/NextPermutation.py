class Solution:
    def rev(self, arr, first, last):
        while first < last:
            arr[first], arr[last] = arr[last], arr[first]
            first += 1
            last -= 1

    def nextPermutation(self, nums: List[int]) -> None:
        index = -1
        i = len(nums) - 1

        while i > 0:
            if nums[i] > nums[i - 1]:
                index = i - 1
                break
            i -= 1

        if index == -1:
            self.rev(nums, 0, len(nums) - 1)
            return
        
        i = len(nums) - 1
        while i > index:
            if nums[i] > nums[index]:
                nums[i], nums[index] = nums[index], nums[i]
                self.rev(nums, index + 1, len(nums) - 1)
                return
            i -= 1