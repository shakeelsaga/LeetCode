class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        count = 0
        left = 0
        right = k - 1

        i = 0
        sum = 0
        while right < len(arr):
            sum += arr[i]

            if i == right:
                if sum / k >= threshold:
                    count += 1
                sum -= arr[left]
                left += 1
                right += 1
            i += 1

        return count