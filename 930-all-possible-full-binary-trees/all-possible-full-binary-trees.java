class Solution {

    // memo[n] = all possible full binary trees with n nodes
    List<List<TreeNode>> memo = new ArrayList<>();

    public List<TreeNode> allPossibleFBT(int n) {

        // We only need indexes up to n
        while (memo.size() <= n) {
            memo.add(null);
        }

        // Even number of nodes -> impossible
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        // Already calculated
        if (memo.get(n) != null) {
            return memo.get(n);
        }

        List<TreeNode> result = new ArrayList<>();

        // Base case: one node
        if (n == 1) {
            result.add(new TreeNode(0));
            memo.set(n, result);
            return result;
        }

        // Try every possible odd size for left subtree
        for (int left = 1; left < n; left += 2) {

            int right = n - 1 - left;

            List<TreeNode> leftTrees = allPossibleFBT(left);
            List<TreeNode> rightTrees = allPossibleFBT(right);

            // Combine every left tree with every right tree
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {

                    TreeNode root = new TreeNode(0);

                    root.left = l;
                    root.right = r;

                    result.add(root);
                }
            }
        }

        // Store result for future use
        memo.set(n, result);

        return result;
    }
}