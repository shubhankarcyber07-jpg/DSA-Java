class Solution:
    # def isMatch(self, s: str, p: str) -> bool:
    #     # 🔥 STEP 1: remove consecutive '*'
    #     new_p = []
    #     for ch in p:
    #         if not (new_p and new_p[-1] == '*' and ch == '*'):
    #             new_p.append(ch)
    #     p = "".join(new_p)

    #     dp = {}

    #     def solve(i, j):
    #         if (i, j) in dp:
    #             return dp[(i, j)]

    #         if j == len(p):
    #             return i == len(s)

    #         if p[j] == '*':
    #             ans = (solve(i, j + 1) or
    #                    (i < len(s) and solve(i + 1, j)))
    #         else:
    #             match = (i < len(s) and (s[i] == p[j] or p[j] == '?'))
    #             ans = match and solve(i + 1, j + 1)

    #         dp[(i, j)] = ans
    #         return ans

    #     return solve(0, 0)

    def isMatch(self, s: str, p: str) -> bool:
        n, m = len(s), len(p)

        # 🔥 compress pattern (important)
        new_p = []
        for ch in p:
            if not (new_p and new_p[-1] == '*' and ch == '*'):
                new_p.append(ch)
        p = "".join(new_p)
        m = len(p)

        # dp table
        dp = [[False]*(m+1) for _ in range(n+1)]

        # base case
        dp[0][0] = True

        # pattern like *, **, ***
        for j in range(1, m+1):
            if p[j-1] == '*':
                dp[0][j] = dp[0][j-1]

        # fill table
        for i in range(1, n+1):
            for j in range(1, m+1):

                if p[j-1] == '*':
                    dp[i][j] = dp[i][j-1] or dp[i-1][j]

                elif p[j-1] == '?' or s[i-1] == p[j-1]:
                    dp[i][j] = dp[i-1][j-1]

                else:
                    dp[i][j] = False

        return dp[n][m]