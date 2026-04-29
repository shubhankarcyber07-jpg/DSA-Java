import javax.swing.tree.TreeNode;

public class LeetCode_106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
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
    
    public TreeNode helper(int[] inorder, int[] postorder, int inLo, int inHi, int postLo, int postHi){
        if(inLo> inHi && postLo>postHi) return null;
        TreeNode root = new TreeNode(postorder[postHi]);

        int idx = inLo;
        while(inorder[idx]!=postorder[postHi]) idx++;

        int leftSize = idx - inLo;

        root.left = helper(inorder, postorder, inLo, idx-1, postLo, postLo+leftSize-1);
        root.right = helper(inorder, postorder, idx+1, inHi, postLo+leftSize, postHi-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(inorder, postorder, 0, n-1, 0, n-1);
    }
}
