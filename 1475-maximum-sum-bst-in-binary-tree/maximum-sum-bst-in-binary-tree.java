class Pair {
    int max;
    int min;
    int sum;
    boolean isBST;

    Pair(int max, int min, int sum, boolean isBST) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.isBST = isBST;
    }
}

class Solution {
    static int ans;

    public int maxSumBST(TreeNode root) {
        ans = 0;
        maxMin(root);
        return ans;
    }

    Pair maxMin(TreeNode root) {
        if (root == null)
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);

        Pair lst = maxMin(root.left);
        Pair rst = maxMin(root.right);

        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));

        if (!lst.isBST || !rst.isBST ||
            lst.max >= root.val || rst.min <= root.val)
            return new Pair(max, min, 0, false);

        int sum = root.val + lst.sum + rst.sum;

        ans = Math.max(ans, sum);

        return new Pair(max, min, sum, true);
    }
}