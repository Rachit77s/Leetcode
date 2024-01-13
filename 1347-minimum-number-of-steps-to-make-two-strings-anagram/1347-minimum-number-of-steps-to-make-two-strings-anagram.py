class Solution:
    def minSteps(self, s: str, t: str) -> int:
        count_s = [0] * 26
        count_t = [0] * 26

        for char_s in s:
            count_s[ord(char_s) - ord('a')] += 1

        for char_t in t:
            count_t[ord(char_t) - ord('a')] += 1

        result = 0
        for i in range(26):
            if count_s[i] > count_t[i]:
                result += count_s[i] - count_t[i]

        return result