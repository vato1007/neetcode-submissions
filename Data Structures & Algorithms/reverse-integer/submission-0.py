class Solution:
    def reverse(self, x: int) -> int:
        MIN = -2**31
        MAX = 2**31 - 1

        sign = -1 if x < 0 else 1
        x = abs(x)

        res = 0

        while x:
            digit = x % 10
            x //= 10

            # Check if res * 10 + digit would overflow
            if res > (MAX - digit) // 10:
                return 0

            res = res * 10 + digit

        return sign * res