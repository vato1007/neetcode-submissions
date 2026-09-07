class Solution {
    public boolean isValidBST(TreeNode root) {
        Long min = Long.MIN_VALUE;
        Long max = Long.MAX_VALUE;
        
        return helper(root, min, max);
        
    }
    
    private boolean helper(TreeNode root, Long min, Long max) {
        if(root == null)
            return true;
        Long val = (long) root.val;
        if(val <= min || val >= max)
            return false;
        return helper(root.left, min, val) && helper(root.right, val, max);
    }
}