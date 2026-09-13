class Solution {
    public java.util.List<java.util.List<Integer>> combinationSum2(
        int[] candidates, int target) {

        java.util.List<java.util.List<Integer>> result =
            new java.util.ArrayList<>();

        java.util.Arrays.sort(candidates);

        backtrack(candidates, target, 0,
                  new java.util.ArrayList<Integer>(), result);

        return result;
    }

    private void backtrack(
        int[] candidates,
        int target,
        int start,
        java.util.List<Integer> current,
        java.util.List<java.util.List<Integer>> result) {

        if (target == 0) {
            result.add(new java.util.ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            backtrack(
                candidates,
                target - candidates[i],
                i + 1,
                current,
                result
            );

            current.remove(current.size() - 1);
        }
    }
}