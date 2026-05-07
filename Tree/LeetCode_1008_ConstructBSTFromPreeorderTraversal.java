import java.util.Arrays;

public class LeetCode_1008_ConstructBSTFromPreeorderTraversal {

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
        public TreeNode BST(int[] pre, int preLo, int preHi, int[] in, int inLo, int inHi){
            if(preLo>preHi && inLo>inHi) return null;
            int leftSize = 0;
            while(pre[preLo]!=in[inLo+leftSize]) leftSize++;
            TreeNode root = new TreeNode(pre[preLo]);
            root.left = BST(pre, preLo+1, preLo + leftSize, in, inLo, inLo+leftSize-1);
            root.right = BST(pre, preLo + leftSize + 1, preHi, in, inLo+leftSize+1, inHi);
            return root;
        }
        public TreeNode bstFromPreorder(int[] preorder) {
            int n = preorder.length;
            int[] inorder = new int[n];
            for(int i=0; i<n; i++){
                inorder[i] = preorder[i];
            }
            Arrays.sort(inorder);
            return BST(preorder, 0, n-1, inorder, 0, n-1);
        }
    }
}
