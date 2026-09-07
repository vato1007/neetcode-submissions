class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                if(currNode.left != null)
                    queue.offer(currNode.left);
                if(currNode.right != null)
                    queue.offer(currNode.right);
                if(i == levelSize-1)
                    res.add(currNode.val);
            }
        }
        
        return res;
    }
}