
class Solution {
    public boolean hasPathSum(TreeNode root, int t) {
        if(root==null)return false;
        if(root.left==null && root.right==null && t-root.val==0)return true;
        return hasPathSum(root.left,t-root.val)|| hasPathSum(root.right,t-root.val);
    }
}