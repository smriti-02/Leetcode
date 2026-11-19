class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        res = []
        x = len(nums)//2
        j = x
        i = 0
        while i < x:
            res.append(nums[i])
            res.append(nums[j])
            i += 1
            j += 1
        return res