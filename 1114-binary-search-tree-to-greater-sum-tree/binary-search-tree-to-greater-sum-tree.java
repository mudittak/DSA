class Solution {
    private void inorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    private void replace(TreeNode root, List<Integer> vals) {
        if(root == null) return;
        replace(root.left, vals);

        // find index of current value in sorted list
        int idx = vals.indexOf(root.val);

        // compute suffix sum from idx to end
        int sum = 0;
        for(int i = idx; i < vals.size(); i++) {
            sum += vals.get(i);
        }
        root.val = sum;

        replace(root.right, vals);
    }

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);     // Step 1: collect sorted values
        replace(root, vals);     // Step 2: update nodes using suffix sums
        return root;
    }
}
