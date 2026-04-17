import java.util.ArrayList;
import java.util.List;

public class LeetCode_257_BinaryTreePaths {

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
        public void paths(TreeNode root, StringBuilder sb, List<String> ans){
            if(root == null) return;

            int len = sb.length(); // save state

            // add current node
            sb.append(root.val);

            // leaf node
            if(root.left == null && root.right == null){
                ans.add(sb.toString());
            } else {
                sb.append("->");

                paths(root.left, sb, ans);
                paths(root.right, sb, ans);
            }

            // 🔥 backtrack
            sb.setLength(len);
        }

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            paths(root, new StringBuilder(), ans);
            return ans;
        }
    }
}
