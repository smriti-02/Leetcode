class Solution:
    def maximumWealth(self, accounts: list[list[int]]) -> int:
        x = len(accounts)
        y = len(accounts[0])
        res = 0
        for i in range(x):
            sum = 0
            for j in range(y):
                sum += accounts[i][j]
            res = max(res, sum)

        return res
        