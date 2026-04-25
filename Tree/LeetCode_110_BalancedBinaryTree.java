class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static boolean ans;
    public int levels(TreeNode root){
        if(root==null) return 0;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        int diff = Math.abs(leftLevels-rightLevels);
        if(diff>1) ans = false;
        return 1 + Math.max(leftLevels, rightLevels);
    }
    public boolean isBalanced(TreeNode root) {
        ans = true;
        levels(root);
        return ans;
    }
}