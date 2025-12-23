from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)

        for word in strs:
            map = [0] * 26

            for char in word:
                map[ord(char) - ord('a')] += 1
            
            groups[tuple(map)].append(word)

        return [x for x in groups.values()]