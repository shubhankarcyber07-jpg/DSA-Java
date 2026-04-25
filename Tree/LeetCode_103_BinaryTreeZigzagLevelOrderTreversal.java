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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                if(leftToRight){
                    list.add(node.val);
                } else {
                    list.add(0, node.val); // insert at front
                }

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            ans.add(list);
            leftToRight = !leftToRight;
        }

        return ans;
    }
}