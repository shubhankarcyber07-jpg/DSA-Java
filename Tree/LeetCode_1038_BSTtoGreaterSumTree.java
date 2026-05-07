import javax.swing.tree.TreeNode;

public class LeetCode_1038_BSTtoGreaterSumTree {
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
        TreeNode prev = null;
        public void reverseInorder(TreeNode root){
            if(root==null) return;
            reverseInorder(root.right); 
            if(prev!=null) root.val = root.val + prev.val;
            prev = root;
            reverseInorder(root.left); 
        }
        public TreeNode bstToGst(TreeNode root) {
            reverseInorder(root);
            return root;
        }
    }
}
