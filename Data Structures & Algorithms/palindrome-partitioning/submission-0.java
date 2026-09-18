class Solution {
    public java.util.List<java.util.List<String>> partition(String s) {
        java.util.List<java.util.List<String>> ans = new java.util.ArrayList<>();

        backtrack(s, 0, new java.util.ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(
        String s,
        int start,
        java.util.List<String> current,
        java.util.List<java.util.List<String>> ans
    ) {
        if (start == s.length()) {
            ans.add(new java.util.ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {

                current.add(s.substring(start, end + 1));

                backtrack(s, end + 1, current, ans);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}