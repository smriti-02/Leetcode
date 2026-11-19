class Solution:
    def getConcatenation(self, nums: list[int]) -> list[int]:
        res = []
        res.extend(nums)
        res.extend(nums)
        return res