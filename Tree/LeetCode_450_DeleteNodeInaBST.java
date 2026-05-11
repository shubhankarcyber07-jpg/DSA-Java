import javax.swing.tree.TreeNode;

public class LeetCode_450_DeleteNodeInaBST {

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
        // inorder predecessor
        public TreeNode iop(TreeNode root) {
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            return temp;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            // Search
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            }
            else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            }
            else {
                // Case 1: leaf node
                if (root.left == null && root.right == null) {
                    return null;
                }
                // Case 2: one child
                else if (root.left == null) {
                    return root.right;
                }
                else if (root.right == null) {
                    return root.left;
                }
                // Case 3: two children
                else {
                    TreeNode pred = iop(root);
                    // Replace value
                    root.val = pred.val;
                    // Delete predecessor node
                    root.left = deleteNode(root.left, pred.val);
                }
            }

            return root;
        }
    }
}
