class Solution {
    static int sum;

    private void revInorder(TreeNode root) {
        if(root == null) return;

        // Step 1: go right (larger values first)
        revInorder(root.right);

        // Step 2: update sum and node value
        sum += root.val;
        root.val = sum;

        // Step 3: go left
        revInorder(root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        revInorder(root);
        return root;
    }
}
