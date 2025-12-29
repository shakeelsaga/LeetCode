class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq = dict()
        max_len = 0

        left = 0

        for right in range(len(s)):
            freq[s[right]] = 1 + freq.get(s[right], 0)

            if (right - left + 1) - max(freq.values()) > k:
                freq[s[left]] -= 1
                left += 1
            
            max_len = max((right - left + 1), max_len)
        
        return max_len