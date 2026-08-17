
class Pair {
    TreeNode node;
    int level;
    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int currLevel = 0;
        result.add(new ArrayList<>());
        boolean leftToRight = true;

        while(!q.isEmpty()) {
            Pair front = q.remove();
            TreeNode node = front.node;
            int level = front.level;

            if(level != currLevel) {
                currLevel++;
                leftToRight = !leftToRight; // flip direction
                result.add(new ArrayList<>());
            }

            if(leftToRight) {
                result.get(currLevel).add(node.val);
            } else {
                result.get(currLevel).add(0, node.val); // insert at front for reverse order
            }

            if(node.left != null) q.add(new Pair(node.left, level + 1));
            if(node.right != null) q.add(new Pair(node.right, level + 1));
        }

        return result;
    }
}
