import java.util.ArrayList;

public class LeetCode_1382_BalanceABST {

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
        public void inorder(TreeNode root, ArrayList<Integer> arr){
            if(root==null) return;
            inorder(root.left,arr);
            arr.add(root.val);
            inorder(root.right,arr);
        }
        public TreeNode BST(ArrayList<Integer> arr, int lo, int hi){
            if(lo>hi) return null;
            int mid = (lo+hi)/2;
            TreeNode root = new TreeNode(arr.get(mid));
            root.left = BST(arr, lo, mid-1);
            root.right = BST(arr, mid+1, hi);
            return root;
        }
        public TreeNode balanceBST(TreeNode root) {
            ArrayList<Integer> arr = new ArrayList<>();
            inorder(root,arr);
            int n = arr.size();
            return BST(arr, 0, n-1);
        }
    }
}
