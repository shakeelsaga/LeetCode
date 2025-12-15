class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s) < 10:
            return []

        left = 0
        right = left + 1

        seen = dict()
        while(right <= len(s)):
            string = s[left:right]

            if (right - left) == 10:
                if string not in seen:
                    seen[string] = 1
                else:
                    seen[string] += 1
                left += 1
            
            right += 1
        
        repeated = []
        for key in seen.keys():
            if seen[key] > 1:
                repeated.append(key)
        
        return repeated