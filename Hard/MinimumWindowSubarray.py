class Solution:
    def minWindow(self, s: str, t: str) -> str:
        map_t = dict()

        for char in t:
            map_t[char] = map_t.get(char, 0) + 1

        left, right = 0, 0
        min_len = float('inf')
        start = -1
        char_count = 0


        while right < len(s):
            if s[right] in map_t:
                if map_t[s[right]] > 0:
                    char_count += 1
                map_t[s[right]] -= 1

            
            while char_count == len(t):
                if (right - left + 1) < min_len:
                    min_len = right - left + 1
                    start = left

                if s[left] in map_t:
                    map_t[s[left]] += 1
                    if map_t[s[left]] > 0:
                        char_count -= 1
                left += 1
            right += 1
            

        return "" if start == -1 else s[start:start + min_len]