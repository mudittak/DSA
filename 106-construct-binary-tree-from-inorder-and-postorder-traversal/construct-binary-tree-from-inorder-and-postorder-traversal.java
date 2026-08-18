class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(0, n-1, 0, n-1, inorder, postorder);
    }

    public static TreeNode build(int inLo, int inHi, int postLo, int postHi, int[] inorder, int[] postorder) {
        if (inLo > inHi || postLo > postHi) return null;

        // Root is last element of postorder
        int val = postorder[postHi];
        TreeNode root = new TreeNode(val);

        // Locate root in inorder
        int r = 0;
        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == val) {
                r = i;
                break;
            }
        }

        int cnt = r - inLo; // Number of nodes in left subtree

        // Left subtree: inorder[inLo..r-1], postorder[postLo..postLo+cnt-1]
        root.left = build(inLo, r-1, postLo, postLo+cnt-1, inorder, postorder);

        // Right subtree: inorder[r+1..inHi], postorder[postLo+cnt..postHi-1]
        root.right = build(r+1, inHi, postLo+cnt, postHi-1, inorder, postorder);

        return root;
    }
}
