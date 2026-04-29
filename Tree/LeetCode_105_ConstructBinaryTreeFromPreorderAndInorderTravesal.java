import javax.swing.tree.TreeNode;

public class LeetCode_105_ConstructBinaryTreeFromPreorderAndInorderTravesal {
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

    public TreeNode helper(int[] preorder, int[] inorder,
                           int preLo, int preHi,
                           int inLo, int inHi){

        if(preLo > preHi || inLo > inHi) return null;

        // root from preorder
        TreeNode root = new TreeNode(preorder[preLo]);

        // find root in inorder
        int idx = inLo;
        while(inorder[idx] != preorder[preLo]) idx++;

        int leftSize = idx - inLo;

        // build left
        root.left = helper(preorder, inorder,
                           preLo + 1, preLo + leftSize,
                           inLo, idx - 1);

        // build right
        root.right = helper(preorder, inorder,
                            preLo + leftSize + 1, preHi,
                            idx + 1, inHi);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}

