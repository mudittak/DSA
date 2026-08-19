class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse until you find the split point
        while(root != null) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;   // both nodes lie in left subtree
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;  // both nodes lie in right subtree
            } else {
                return root;        // split point - LCA
            }
        }
        return null;
    }
}
