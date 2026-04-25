class Solution {
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
 
    public void preorder(TreeNode root, List<Integer> list, int level){
        if(root==null) return;
        if(list.size()==level) list.add(root.val);
        else list.set(level,root.val);
        preorder(root.left, list, level+1);
        preorder(root.right, list, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans, 0);
        return ans;
    }
}