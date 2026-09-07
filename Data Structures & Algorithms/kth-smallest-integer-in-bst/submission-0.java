class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        ans[1] = k;
        inorder(root, ans);
        return ans[0];
    }
    
    private void inorder(TreeNode root, int[] ans) {
        if(root == null)
            return;
        inorder(root.left, ans);
        ans[1]--;
        if(ans[1] == 0)
            ans[0] = root.val;
        inorder(root.right, ans);
    }
}