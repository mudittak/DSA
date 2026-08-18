class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        return build(0, preorder.length - 1, 0, inorder.length - 1, inorder, preorder);
    }

    private TreeNode build(int preLo, int preHi, int inLo, int inHi, int[] inorder, int[] preorder) {
        if (preLo > preHi || inLo > inHi) return null;

        int val = preorder[preLo];
        TreeNode root = new TreeNode(val);

        int r = 0;
        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == val) {
                r = i;
                break;
            }
        }

        int cnt = r - inLo; // left subtree size
        root.left = build(preLo + 1, preLo + cnt, inLo, r - 1, inorder, preorder);
        root.right = build(preLo + cnt + 1, preHi, r + 1, inHi, inorder, preorder);

        return root;
    }
}
