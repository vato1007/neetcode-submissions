class Solution:
    def maxArea(self, heights):
        left = 0
        right = len(heights) - 1
        maximum = 0

        while left < right:
            width = right - left
            height = min(heights[left], heights[right])

            maximum = max(maximum, width * height)

            if heights[left] < heights[right]:
                left += 1
            else:
                right -= 1

        return maximum