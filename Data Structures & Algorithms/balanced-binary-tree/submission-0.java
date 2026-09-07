class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int res = helper(root);
        return res == -1?false:true;
    }
    
    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        int leftH = helper(root.left);
        if(leftH == -1)
            return -1;
        int rightH = helper(root.right);
        if(rightH == -1)
            return -1;
        return Math.abs(leftH - rightH)>1?-1:1+Math.max(leftH, rightH);
    }
}