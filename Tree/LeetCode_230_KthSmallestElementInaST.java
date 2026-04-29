import javax.swing.tree.TreeNode;

public class LeetCode_230_KthSmallestElementInaST {
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
    int k;
    int ans;

    public void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);

        if(--k == 0){
            ans = root.val;
            return;
        }

        dfs(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }
}

