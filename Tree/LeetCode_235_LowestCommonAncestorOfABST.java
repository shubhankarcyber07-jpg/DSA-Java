import javax.swing.tree.TreeNode;

public class LeetCode_235_LowestCommonAncestorOfABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if(root == null) return null;

            // both smaller → go left
            if(p.val < root.val && q.val < root.val){
                return lowestCommonAncestor(root.left, p, q);
            }

            // both greater → go right
            if(p.val > root.val && q.val > root.val){
                return lowestCommonAncestor(root.right, p, q);
            }

            // split point
            return root;
        }
    }
}
