class Solution {
    private TreeNode attach(TreeNode root, int val){
        if(root == null) return new TreeNode(val);

        if(root.val < val){
            root.right = attach(root.right, val);
        } else if(root.val > val){
            root.left = attach(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return attach(root, val);
    }
}
