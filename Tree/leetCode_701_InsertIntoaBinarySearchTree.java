import javax.swing.tree.TreeNode;

public class leetCode_701_InsertIntoaBinarySearchTree {
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


    //1st approch

    // public void insert(TreeNode root, int val){
    //     if(val<root.val){
    //         if(root.left==null) root.left = new TreeNode(val);
    //         else insert(root.left, val);
    //     }
    //     else{
    //         if(root.right == null) root.right = new TreeNode(val);
    //         else insert(root.right, val);
    //     }
    // }
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if(root == null) return new TreeNode(val);
    //     insert(root,val);
    //     return root;
    // }

    //2nd approch

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val<root.val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
}
