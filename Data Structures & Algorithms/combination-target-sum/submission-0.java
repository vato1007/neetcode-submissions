class Solution {
    public java.util.List<java.util.List<Integer>> combinationSum(
        int[] nums,
        int target
    ) {
        java.util.List<java.util.List<Integer>> ans =
            new java.util.ArrayList<>();

        java.util.Arrays.sort(nums);

        backtrack(
            nums,
            target,
            0,
            new java.util.ArrayList<Integer>(),
            ans
        );

        return ans;
    }

    private void backtrack(
        int[] nums,
        int target,
        int start,
        java.util.List<Integer> curr,
        java.util.List<java.util.List<Integer>> ans
    ) {
        if (target == 0) {
            ans.add(new java.util.ArrayList<Integer>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (nums[i] > target) {
                break;
            }

            curr.add(nums[i]);

            // Use i because the same number can be reused
            backtrack(
                nums,
                target - nums[i],
                i,
                curr,
                ans
            );

            curr.remove(curr.size() - 1);
        }
    }
}