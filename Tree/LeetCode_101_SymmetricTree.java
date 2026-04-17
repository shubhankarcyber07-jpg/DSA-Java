public class LeetCode_101_SymmetricTree {

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
            return p == q;

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        TreeNode left = invertTree(root.left);
        return isSameTree(left,root.right);
    }
} 
}
