public class LeetCode_112_PathSum {
  
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
    // public boolean sum(TreeNode root, int targetSum){
    //     if(root==null) return false;
    //     if(root.left==null && root.right==null) return targetSum==root.val;
    //     return sum(root.left, targetSum-root.val) || sum(root.right, targetSum-root.val);
    // }
    // public boolean hasPathSum(TreeNode root, int targetSum) {
    //     if(root==null) return false;
    //     return sum(root, targetSum);
    // }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        // leaf node
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }

        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) ||
               hasPathSum(root.right, remaining);
    }
}
}
