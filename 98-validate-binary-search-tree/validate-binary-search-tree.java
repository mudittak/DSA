//method 2
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        long prev = Long.MIN_VALUE;  // use long to handle edge cases

        while (curr != null) {
            if (curr.left != null) {
                // find predecessor
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) { // link
                    pred.right = curr;
                    curr = curr.left;
                } else { // unlink
                    pred.right = null;
                    if (curr.val <= prev) return false;
                    prev = curr.val;
                    curr = curr.right;
                }
            } else {
                if (curr.val <= prev) return false;
                prev = curr.val;
                curr = curr.right;
            }
        }
        return true;
    }
}


//method 1
// class Solution {
//     private void inorder(TreeNode root, List<Integer> ans) {
//         if(root == null) return;
//         inorder(root.left, ans);
//         ans.add(root.val);
//         inorder(root.right, ans);
//     }
//     public boolean isValidBST(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         inorder(root, ans);
//         for(int i = 1; i < ans.size(); i++) {
//             if(ans.get(i) <= ans.get(i - 1)) { // here we check that preoder is in increasing order
//                 return false;
//             }
//         }
//         return true;
        
//     }
// }