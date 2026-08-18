class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;
        path.add(node.val);

        if (node.left == null && node.right == null && target == node.val) {
            res.add(new ArrayList<>(path));
        } else {
            dfs(node.left, target - node.val, path, res);
            dfs(node.right, target - node.val, path, res);
        }
        path.remove(path.size() - 1); // backtrack
    }
}
