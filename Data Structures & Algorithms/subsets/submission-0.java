class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // We've considered every number
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: include nums[index]
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);

        // Undo
        current.remove(current.size() - 1);

        // Choice 2: don't include nums[index]
        backtrack(index + 1, nums, current, result);
    }
}