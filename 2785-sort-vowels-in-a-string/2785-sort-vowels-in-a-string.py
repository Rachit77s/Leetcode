class Solution:
    def sortVowels(self, s: str) -> str:
        freq = Counter(s)
        vowels = list('uoieaUOIEA')
        vowels_set = set(vowels)
        res = []
        for c in s:
            if c in vowels_set:
                while freq[vowels[-1]] == 0:
                    vowels.pop()
                res.append(vowels[-1])
                freq[vowels[-1]] -= 1
            else:
                res.append(c)
        return ''.join(res)