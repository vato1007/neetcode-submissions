class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (Math.abs(target) > total) {
            return 0;
        }

        int[][] memo = new int[nums.length][2 * total + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }

        return dfs(nums, target, 0, 0, total, memo);
    }

    private int dfs(int[] nums, int target, int index, int sum,
                    int offset, int[][] memo) {

        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        int key = sum + offset;

        if (memo[index][key] != -1) {
            return memo[index][key];
        }

        int add = dfs(nums, target, index + 1,
                      sum + nums[index], offset, memo);

        int subtract = dfs(nums, target, index + 1,
                           sum - nums[index], offset, memo);

        memo[index][key] = add + subtract;

        return memo[index][key];
    }
}