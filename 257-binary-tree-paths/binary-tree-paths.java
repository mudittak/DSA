class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> arr, List<String> ans) {
        if (root == null) return;
        arr.add(root.val);

        if (root.left == null && root.right == null) {
            // leaf node reached - convert arr to path string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.size(); i++) {
                sb.append(arr.get(i));
                if (i < arr.size() - 1) sb.append("->");
            }
            ans.add(sb.toString());
        }

        dfs(root.left, arr, ans);
        dfs(root.right, arr, ans);
        arr.remove(arr.size() - 1); // backtracking
    }
}
