class Solution:
    def largestVariance(self, s: str) -> int:
        answer = 0
        
        counter = collections.Counter(s)
        
        for ch1 in counter.keys():
            for ch2 in counter.keys():
                if ch1 == ch2:
                    continue

                diff = 0
                has_ch2 = False
                remain_ch2_count = counter[ch2]
                for ch in s:
                    if ch == ch1:
                        diff += 1
                    elif ch == ch2:                        
                        diff -= 1
                        has_ch2 = True
                        remain_ch2_count -= 1
                        if diff < 0 and remain_ch2_count > 0:
                            diff = 0
                            has_ch2 = False

                    if has_ch2:
                        answer = max(answer, diff)

        return answer