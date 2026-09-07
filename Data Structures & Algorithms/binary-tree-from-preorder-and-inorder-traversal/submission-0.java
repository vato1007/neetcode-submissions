class Solution {
    int preInd;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preInd = 0;
        int n = inorder.length;
        int startIndex = 0, endIndex = n-1;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < n; i++)
            inorderMap.put(inorder[i], i);
        return helper(preorder, inorder, startIndex, endIndex, inorderMap);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int startIndex, int endIndex, Map<Integer, Integer> inorderMap) {
        if(startIndex > endIndex)
            return null;
        int val = preorder[preInd++];
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, inorder, startIndex, inorderMap.get(val)-1, inorderMap);
        root.right = helper(preorder, inorder, inorderMap.get(val)+1, endIndex, inorderMap);
        return root;
    }
}