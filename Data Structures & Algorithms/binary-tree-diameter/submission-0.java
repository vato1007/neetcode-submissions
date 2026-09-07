class Solution {
    int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }
    
    public int height(TreeNode root) {
        if(root == null)
            return -1;
        int left = height(root.left);
        int right = height(root.right);
        int h = 1 + Math.max(left, right);
        maxDiameter = Math.max(maxDiameter, left + right + 2);
        return h;
    }
}