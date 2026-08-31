class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [1] * n

        # Products to the left
        prefix = 1
        for i in range(n):
            res[i] = prefix
            prefix *= nums[i]

        # Products to the right
        suffix = 1
        for i in range(n - 1, -1, -1):
            res[i] *= suffix
            suffix *= nums[i]

        return res