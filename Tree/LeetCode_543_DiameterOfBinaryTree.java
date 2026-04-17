public class LeetCode_543_DiameterOfBinaryTree {
    
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
     
    class Solution {
        static int dia;
        public int levels(TreeNode root){
            if(root == null) return 0;
            int leftLevels = levels(root.left);
            int rightLevels = levels(root.right);
            int path = leftLevels + rightLevels;
            dia = Math.max(dia, path);
            return 1+Math.max(leftLevels, rightLevels);
        }
        public int diameterOfBinaryTree(TreeNode root) {
            dia=0;
            levels(root);
            return dia;
        }
    }
}
