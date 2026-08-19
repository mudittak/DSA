class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    private TreeNode convert(int[] nums, int lo, int hi) {
        if(lo > hi) return null;

        int mid = lo + (hi - lo) / 2;   // pick middle for balance
        TreeNode root = new TreeNode(nums[mid]);

        root.left = convert(nums, lo, mid - 1);
        root.right = convert(nums, mid + 1, hi);

        return root;
    }
}
