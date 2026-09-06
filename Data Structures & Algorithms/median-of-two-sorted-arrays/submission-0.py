class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:

        # Binary search the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        m = len(nums1)
        n = len(nums2)

        left = 0
        right = m

        while left <= right:

            i = (left + right) // 2
            j = (m + n + 1) // 2 - i

            # Values immediately around the partitions
            Aleft = float('-inf') if i == 0 else nums1[i - 1]
            Aright = float('inf') if i == m else nums1[i]

            Bleft = float('-inf') if j == 0 else nums2[j - 1]
            Bright = float('inf') if j == n else nums2[j]

            # Correct partition
            if Aleft <= Bright and Bleft <= Aright:

                # Odd total length
                if (m + n) % 2 == 1:
                    return float(max(Aleft, Bleft))

                # Even total length
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2

            # nums1 partition is too far right
            elif Aleft > Bright:
                right = i - 1

            # nums1 partition is too far left
            else:
                left = i + 1