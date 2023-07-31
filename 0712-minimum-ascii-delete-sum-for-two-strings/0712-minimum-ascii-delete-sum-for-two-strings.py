class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        dp = [[0] * (m + 1) for _ in range(n + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if s1[i - 1] == s2[j - 1]:
                    dp[j][i] = dp[j - 1][i - 1] + ord(s1[i - 1])
                else:
                    dp[j][i] = max(dp[j - 1][i], dp[j][i - 1])
        
		# ASCII Sum of S1 - Max ASCII Sum of CS +  ASCII Sum of S2 - Max ASCII Sum of CS
        return sum(map(ord, s1 + s2)) - dp[-1][-1] * 2