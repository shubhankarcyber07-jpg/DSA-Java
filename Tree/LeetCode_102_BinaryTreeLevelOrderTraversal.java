import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102_BinaryTreeLevelOrderTraversal {

 
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

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ans.add(list);
        }
        return ans;
    }
 
    // public int level(TreeNode root){
    //     if(root==null) return 0;
    //     return 1 + Math.max(level(root.left), level(root.right));
    // }
    // public void order(List<List<Integer>> ans, List<Integer> list, TreeNode root, int level, int i){
    //     if(root==null) return;
    //     if(level>i) return;
    //     if(level==i) list.add(root.val);
    //     order(ans, list, root.left, level + 1, i);
    //     order(ans, list, root.right, level + 1, i);
    // }
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     if(root == null) return ans;
    //     int n = level(root);
    //     for(int i=0; i<n; i++){
    //         List<Integer> list = new ArrayList<Integer>();
    //         order(ans, list, root, 0, i);
    //         ans.add(list);
    //     }
    //     return ans;
    // }
}
