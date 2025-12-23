class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequency = dict()

        for num in nums:
            if num in frequency:
                frequency[num] += 1
            else:
                frequency[num] = 1

        bucket = [[] for x in range(len(nums) + 1)]

        for key, value in frequency.items():
            bucket[value].append(key)
        
        top = []
        for i in range(len(bucket) - 1, 0, -1):
            for number in bucket[i]:
                top.append(number)
                if len(top) == k:
                    return top

        return top
