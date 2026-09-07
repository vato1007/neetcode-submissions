class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = -1001;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        int val = root.val;
        max = Math.max(max, val);
        int lVal = helper(root.left);
        int rVal = helper(root.right);
        max = Math.max(max, Math.max(rVal+val, Math.max(lVal+val, lVal+rVal+val)));
        
        return Math.max(rVal+val, Math.max(lVal+val, val));
    }
}
