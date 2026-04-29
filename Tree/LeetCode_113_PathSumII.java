import java.util.ArrayList;
import java.util.List;

public class LeetCode_113_PathSumII {

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

    public void solve(TreeNode root, int target, List<Integer> path, List<List<Integer>> ans){
        if(root == null) return;

        // add current node
        path.add(root.val);

        // check leaf
        if(root.left == null && root.right == null){
            if(target == root.val){
                ans.add(new ArrayList<>(path)); // copy
            }
        }
        else{
            solve(root.left, target - root.val, path, ans);
            solve(root.right, target - root.val, path, ans);
        }

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
}

